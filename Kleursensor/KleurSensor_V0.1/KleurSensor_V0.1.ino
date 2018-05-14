//V0.1
// eerste opzet

#define S0 8
#define S1 9
#define S2 12
#define S3 11
#define sensorOut 10

int red = 0;
int green = 0;
int blue = 0;

void setup() {
  pinMode(S0, OUTPUT);
  pinMode(S1, OUTPUT);
  pinMode(S2, OUTPUT);
  pinMode(S3, OUTPUT);
  pinMode(sensorOut, INPUT);
  Serial.begin(9600);
}

void loop() {
  // Setting red filtered photodiodes to be read
  digitalWrite(S2, LOW);
  digitalWrite(S3, LOW);

  // Reading the output frequency
  red = pulseIn(sensorOut, LOW);
  red = constrain(red, 13, 71);
  red = map(red, 13, 71, 255, 0);
  delay(100);
  
  // Setting Green filtered photodiodes to be read
  digitalWrite(S2, HIGH);
  digitalWrite(S3, HIGH);

  // Reading the output frequency
  green = pulseIn(sensorOut, LOW);
  green = constrain(green, 12, 67);
  green = map(green, 12, 67, 255, 0);

  delay(100);
  
  // Setting Blue filtered photodiodes to be read
  digitalWrite(S2, LOW);
  digitalWrite(S3, HIGH);

  // Reading the output frequency
  blue = pulseIn(sensorOut, LOW);
  blue = constrain(blue, 3, 48);
  blue = map(blue, 3, 48, 255, 0);

  delay(100);
  
  //Geel
  if ((red >= 176 && red <= 220) && (green >= 140 && green <= 186) && (blue >= 51 && blue <= 102)) {
    Serial.println("Geel");
  
  //Rood
  } else if ((red >= 128 && red <= 172) && (green >= 98 && green <= 135) && (blue >= 17 && blue <= 46)) {
    Serial.println("Rood");
  
  //Oranje
  } else if ((red >= 132 && red <= 207) && (green >= 42 && green <= 70) && (blue >= 6 && blue <= 17)) {
    Serial.println("Oranje");
  
  //Paars
  } else if ((red >= 14 && red <= 62) && (green >= 0 && green <= 5) && (blue >= 0 && blue <= 12)) {
    Serial.println("Paars");
  
  //Groen
  } else if ((red >= 84 && red <= 124) && (green >= 98 && green <= 135) && (blue >= 17 && blue <= 46)) {
    Serial.println("Groen");

  //Zwart
  } else {
    Serial.println("Zwart");
  }

}




