#include <Adafruit_NeoPixel.h>

#include <MD_TCS230.h>
#include <FreqCount.h>


#define S0    10
#define S1    9
#define LED   8
#define S3    7
#define S2    6
#define out   5
#define RGB   13
// TCS230 sensor calibration and color readings
//
// Input and output using the Serial console.
//


#define  BLACK_CAL 0
#define WHITE_CAL 1
#define READ_VAL  2


MD_TCS230 CS(S2, S3);
Adafruit_NeoPixel strip = Adafruit_NeoPixel(1, RGB, NEO_GRB + NEO_KHZ800);

void setup() 
{
  pinMode(RGB, OUTPUT);
  Serial.begin(57600);
  Serial.print(F("\n[TCS230 Calibrator Example]"));

  CS.begin();
  
  strip.begin();
  strip.show();
  colorWipe(strip.Color(150,255,255));
    
  digitalWrite(LED, HIGH);

}

char getChar()
// blocking wait for an input character from the input stream
{
  while (Serial.available() == 0)
    ;
  return(toupper(Serial.read()));
}

void clearInput()
// clear all characters from the serial input
{
  while (Serial.read() != -1)
    ;
}

uint8_t fsmReadValue(uint8_t state, uint8_t valType, uint8_t maxReads)
// Finite State Machine for reading a value from the sensor
// Current FSM state is passed in and returned
// Type of value being read is passed in
{
  static  uint8_t selChannel;
  static  uint8_t readCount;
  static  sensorData  sd;

  switch(state)
  {
  case 0: // Prompt for the user to start
    Serial.print(F("\n\nReading value for "));
    switch(valType)
    {
    case BLACK_CAL: Serial.print(F("BLACK calibration")); break;
    case WHITE_CAL: Serial.print(F("WHITE calibration")); break;
    case READ_VAL:  Serial.print(F("DATA"));        break;
    default:    Serial.print(F("??"));          break;
    }
    
    Serial.print(F("\nPress any key to start ..."));
    state++;
    break;

  case 1: // Wait for user input
    getChar();
    clearInput();
    state++;
    break;

  case 2: // start the reading process
    CS.read();
    state++;
    break;

  case 3: // wait for a read to complete
    if (CS.available()) 
    {
      sensorData  sd;
      colorData rgb;

      switch(valType)
      {
      case BLACK_CAL: 
        CS.getRaw(&sd); 
        CS.setDarkCal(&sd);   
        break;

      case WHITE_CAL: 
        CS.getRaw(&sd); 
        CS.setWhiteCal(&sd);  
        break;

      case READ_VAL:  
        CS.getRGB(&rgb);
        Serial.print(F("\nRGB is ["));
        Serial.print(rgb.value[TCS230_RGB_R]);
        Serial.print(F(","));
        Serial.print(rgb.value[TCS230_RGB_G]);
        Serial.print(F(","));
        Serial.print(rgb.value[TCS230_RGB_B]);
        Serial.print(F("]"));
        break;
      }
      state++;
    }
    break;

  default:  // reset fsm
    state = 0;
    break;
  }

  return(state);
}


void loop() 
{
  static uint8_t  runState = 0;   
  static uint8_t  readState = 0;

  switch(runState)
  {
  case 0: // calibrate black
    readState = fsmReadValue(readState, BLACK_CAL, 2);
    if (readState == 0) runState++;
    break;

  case 1: // calibrate white
    readState = fsmReadValue(readState, WHITE_CAL, 2);
    if (readState == 0) runState++;
    break;

  case 2: // read color
    readState = fsmReadValue(readState, READ_VAL, 1);
    break;

  default:
    runState = 0; // start again if we get here as something is wrong
  }
}

void colorWipe(uint32_t c) {
  for(uint16_t i=0; i<strip.numPixels(); i++) {
      strip.setPixelColor(i, c);
      strip.show();
  }
}








