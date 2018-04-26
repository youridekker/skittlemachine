//-- Machine 1 --//
/* Versie beheer / ToDO
 * Zie Versie_Beheer.ino
 */

//-- Setup initalisatie LCD --// 
#include <LiquidCrystal.h>
const int rs = 12, en = 11, d4 = 5, d5 = 6, d6 = 7, d7 = 8;                         // initialize the library by associating any needed LCD interface pin
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);                                          // with the arduino pin number it is connected to

//-- Declaratie Pin --//
const int NOODSTOP                = 2;
const int SW_UP                   = 3;
const int SW_DOWN                 = 4;

//-- Declaratie Variabelen --//
boolean u1_state_SW_UP            = false;
boolean u1_prev_SW_UP             = false; 
boolean u1_state_SW_DOWN          = false;
boolean u1_prev_SW_DOWN           = false; 
boolean u1_LCD_Status_done        = false;
boolean u1_LCD_Error_done         = false;
boolean u1_LCD_Passed_done        = false;
boolean u1_noodstop               = false;
boolean u1_sec_blink              = false;
boolean u1_menu_gadoor            = false;
boolean u1_menu_done              = false;
boolean u1_stop_menu_timer        = false;
boolean u1_stop_setup_timer       = false;
boolean u1_setup_done             = false;
boolean u1_menu_done_finished     = false;
boolean u1_aanroep_menu           = true;
int u8_aantal                     = 50;  
int u8_prv_aantal                 = 0;
int u8_passed                     = 48;
int u8_prv_passed                 = 0;

void setup() {
//-- Setup pins --//
  pinMode(NOODSTOP, INPUT);
  attachInterrupt(digitalPinToInterrupt(NOODSTOP), noodstop_ISR, FALLING);    // Maak van pin 2(NOODSTOP) een interupt pin. Deze heeft dus voorrang op andere zaken.
  pinMode(SW_UP, INPUT);
  pinMode(SW_DOWN, INPUT);
// set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  Serial.begin(9600);
//-- set eerste keer de gegevens op het scherm:
  LCD_Status("Set:", u8_aantal);
}

void loop() {  
  u1_state_SW_UP = digitalRead(SW_UP);
  u1_state_SW_DOWN = digitalRead(SW_DOWN);
  
//-- Detect menu setup --//


  if(u1_state_SW_DOWN && u1_state_SW_UP && u1_aanroep_menu){
    u1_stop_menu_timer= false;
    Serial.println("start setup");                                      // DIT VERWIJDEREN
    LCD_Menu_Set();
    Serial.println("Setup done");                                       // DIT VERWIJDEREN
    u1_aanroep_menu = false;
  }

  if(u1_menu_done){
    Serial.println("kom ik hier wel?");                                 // DIT VERWIJDEREN
    u1_stop_setup_timer = false;
    u1_LCD_Status_done = false;
    LCD_Status("Set:", u8_aantal);
    u1_LCD_Passed_done = false;
    LCD_Done_Update(u8_passed);
    u8_prv_aantal = u8_aantal;
    u1_setup_done = false;
    u1_menu_done = false;
    u1_menu_done_finished = true;
  }

  if(u1_menu_done_finished){
    if(timer_setup()){
      Serial.println("timer done setup");                               // DIT VERWIJDEREN
      u1_aanroep_menu = true;
      u1_menu_done_finished = false;
    }
  }

  if(u8_passed != u8_prv_passed){
    u1_LCD_Passed_done = false;
    LCD_Done_Update(u8_passed);
    u8_prv_passed = u8_passed;
  }

//  if(u1_LCD_Error_done && 
 
}

void noodstop_ISR(){                                                          // noodstop interupt, Dit stukje code word uitgevoerd op mement van interupt op pin 2.
    u1_LCD_Error_done = false;
    Serial.println("noodstop");                // DIT STUK VERWIJDEREN LATER
    u1_noodstop = !u1_noodstop;                                               // Toggel noodstop bit
    LCD_Error("NOODSTOP");
}
