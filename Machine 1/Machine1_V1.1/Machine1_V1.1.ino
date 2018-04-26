//-- Machine 1 --//
/* Versie beheer / ToDO
 * Zie Versie_Beheer.ino
 */
#include <LiquidCrystal.h>

const int rs = 12, en = 11, d4 = 5, d5 = 6, d6 = 7, d7 = 8;                         // initialize the library by associating any needed LCD interface pin
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);                                          // with the arduino pin number it is connected to

//-- Declaratie Pin --//
const int SW_UP               = 3;
const int SW_DOWN             = 4;

//-- Declaratie Variabelen --//
boolean u1_state_SW_UP        = false;
boolean u1_prev_SW_UP         = false; 
boolean u1_state_SW_DOWN      = false;
boolean u1_prev_SW_DOWN       = false; 
boolean u1_LCD_Status_done    = false;
boolean u1_LCD_Error_done     = false;
boolean u1_LCD_Passed_done    = false;
int u8_aantal                 = 50;  
int u8_prv_aantal             = 0;
int u8_passed                 = 48;
int u8_prv_passed             = 0;


void setup() {
//-- Setup pins --//
  pinMode(SW_UP, INPUT);
  pinMode(SW_DOWN, INPUT);
// set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
}

void loop() {
  u1_state_SW_UP = digitalRead(SW_UP);
  while(u1_state_SW_UP == !u1_prev_SW_UP){
    if(u1_state_SW_UP && u8_aantal <= 95){
      u8_aantal = u8_aantal + 5;
    }
    u1_prev_SW_UP = u1_state_SW_UP;
  }

  u1_state_SW_DOWN = digitalRead(SW_DOWN);
  if(u1_state_SW_DOWN != u1_prev_SW_DOWN){
    if(u1_state_SW_DOWN && u8_aantal >= 10){
      u8_aantal = u8_aantal - 5;
    }
    u1_prev_SW_DOWN = u1_state_SW_DOWN;
  }
  
  if(u8_aantal != u8_prv_aantal){
    u1_LCD_Status_done = false;
    LCD_Status("Set:", u8_aantal);
    u1_LCD_Passed_done = false;
    LCD_Done_Update(u8_passed);
    u8_prv_aantal = u8_aantal;
    }

  if(u8_passed != u8_prv_passed){
    u1_LCD_Passed_done = false;
    LCD_Done_Update(u8_passed);
    u8_prv_passed = u8_passed;
  }
  
}
