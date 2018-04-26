//-- Machine 1 --//
/* Versie beheer / ToDO
 * Zie Versie_Beheer.ino
 */
#include <LiquidCrystal.h>

const int rs = 12, en = 11, d4 = 5, d5 = 6, d6 = 7, d7 = 8;                         // initialize the library by associating any needed LCD interface pin
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);                                          // with the arduino pin number it is connected to

//-- Declaratie Pin --//
const int NOODSTOP            = 2;
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
boolean u1_noodstop           = false;
boolean u1_sec_blink          = false;
boolean u1_menu_gadoor        = false;
boolean u1_menu_done          = false;
boolean u1_stop_menu_timer    = false;
int u8_aantal                 = 50;  
int u8_prv_aantal             = 0;
int u8_passed                 = 48;
int u8_prv_passed             = 0;



void setup() {
//-- Setup pins --//
  pinMode(NOODSTOP, INPUT);
  attachInterrupt(digitalPinToInterrupt(NOODSTOP), noodstop_ISR, FALLING);    // Maak van pin 2(NOODSTOP) een interupt pin. Deze heeft dus voorrang op andere zaken.
  pinMode(SW_UP, INPUT);
  pinMode(SW_DOWN, INPUT);
// set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  Serial.begin(9600);
}

void loop() {
//-- start timer --//
  
  u1_state_SW_UP = digitalRead(SW_UP);
  u1_state_SW_DOWN = digitalRead(SW_DOWN);
////-- Set up detectie --// 
//  if(u1_state_SW_UP != u1_prev_SW_UP){
//    if(u1_state_SW_UP && u8_aantal <= 95){
//      u8_aantal = u8_aantal + 5;
//    }
//    u1_prev_SW_UP = u1_state_SW_UP;
//  }
////-- Set down detetie --//
//  if(u1_state_SW_DOWN != u1_prev_SW_DOWN){
//    if(u1_state_SW_DOWN && u8_aantal >= 10){
//      u8_aantal = u8_aantal - 5;
//    }
//    u1_prev_SW_DOWN = u1_state_SW_DOWN;
//  }

//-- Detect menu setup --//
  if(u1_state_SW_DOWN && u1_state_SW_UP){
    u1_menu_done = false;
    u1_stop_menu_timer= false;
    Serial.println("start setup");
    LCD_Menu_Set();
    Serial.println("Setup done");
   
    // Hier setup voor nieuwe weergave weer, moet in functie gezet worden.
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

//  if(u1_LCD_Error_done && 
 
}

void noodstop_ISR(){                                                          // noodstop interupt.
    u1_LCD_Error_done = false;
    Serial.println("noodstop");                // DIT STUK VERWIJDEREN LATER
    u1_noodstop = !u1_noodstop;                                               // Toggel noodstop bit
    LCD_Error("NOODSTOP");
}
