//-- Declaratie variabelen --//
boolean u1_maak_keuze           = false;
boolean u1_keuze_setup          = false;
boolean u1_enable_upcount       = false;
int u8_upcount                  = 1;

void LCD_Status(String message_regel_1, int aantal){
  while(!u1_LCD_Status_done){
  lcd.clear();
  lcd.home();
  lcd.print(message_regel_1);
  lcd.setCursor(5,0);
  lcd.print(aantal);
  u1_LCD_Status_done = true;
  }
}

void LCD_Done_Update(int done){
  while(!u1_LCD_Passed_done){
  lcd.setCursor(0,1);
  lcd.print("Passed:");
  lcd.setCursor(8,1);
  lcd.print(done);
  u1_LCD_Passed_done = true;
  }
}

void LCD_Menu_Set(){
  lcd.clear();
  lcd.home();
  lcd.print("Setup amount?");
  lcd.setCursor(0,1);
  lcd.print("up= nxt/dwn= bck");
  u1_maak_keuze = false;
  u1_keuze_setup = false;
  u1_setup_done = false;
  while(u1_menu_done == false){
    u1_state_SW_UP = digitalRead(SW_UP);
    u1_state_SW_DOWN = digitalRead(SW_DOWN);
    if(timer_menu()){
      u1_maak_keuze = true;
    }
    if(u1_state_SW_UP != u1_prev_SW_UP){
      if(!u1_state_SW_UP && u1_maak_keuze){
      Serial.println("Hoevaak kom ik hier?");                       // VERWIJDEREN
      u1_keuze_setup = true;                                                                          // Laten weten dat je in het setup menu zit.
      lcd.clear();
      lcd.home();    
      lcd.print("Setup amount");
      lcd.setCursor(0,1);
      lcd.print("to sort:");
      lcd.setCursor(9,1);
      lcd.print(u8_aantal);
      while(!u1_setup_done){                                                                          // Als de setup niet klaar is het volgende uitvoeren.
        u8_prv_aantal = u8_aantal;
        lcd.setCursor(9,1);
        lcd.print(u8_aantal);
        Set_Amount();                                                                                 // Functie voor het instellen van het aantal te sorteren objecten.

        if((u8_prv_aantal == 10 && u8_aantal < 10) || (u8_prv_aantal == 100 && u8_aantal < 100)){     // Is voor het resetten van het scherm bij de getallen 5 en 100 anders blijven de laatste digits staan.
          lcd.clear();
          lcd.home();    
          lcd.print("Setup amount");
          lcd.setCursor(0,1);
          lcd.print("to sort:");
        }
        if(u1_state_SW_DOWN && u1_state_SW_UP){
          u1_setup_done = true;
          u1_menu_done = true;
          u1_enable_upcount = false;
          u8_upcount = 0;
          Serial.println("setup geslaagd");                                     // DIT VERWIJDEREN
        }
      }
    }
  }
 //-- Terug naar hoofdscherm --//
    if(u1_state_SW_DOWN != u1_prev_SW_DOWN){
      if(!u1_state_SW_DOWN && u1_maak_keuze && !u1_keuze_setup){
      u1_menu_done = true; 
      }
    }
   u1_prev_SW_DOWN = u1_state_SW_DOWN;
   u1_prev_SW_UP = u1_state_SW_UP;
  }
}

void Set_Amount(){
  u1_state_SW_UP = digitalRead(SW_UP);
  u1_state_SW_DOWN = digitalRead(SW_DOWN); 
//-- Set up detectie --// 
  if(u1_state_SW_UP != u1_prev_SW_UP && u1_keuze_setup){
    Serial.println("swup detected");                                           // DIT VERWIJDEREN
    if(!u1_state_SW_UP && u8_aantal <= 95){
      Serial.println("swup");                                                  // DIT VERWIJDEREN
      if(u8_upcount >= 2){                                                     // Hij detecteerd direct een up count. Door deze voorwaarde telt hij niet direct al 5 bij het getal op.
        u8_aantal = u8_aantal + 5;                                             // Het optellen van 5 objecten bij het totaal.
      }
      u8_upcount ++;
    }
    u1_prev_SW_UP = u1_state_SW_UP;
  }
  
//-- Set down detetie --//
  if(u1_state_SW_DOWN != u1_prev_SW_DOWN && u1_keuze_setup){
    Serial.println("sw down detected");                                        // DIT VERWIJDEREN
    if(!u1_state_SW_DOWN && u8_aantal >= 10){
      Serial.println("sw down");                                               // DIT VERWIJDEREN
      u8_aantal = u8_aantal - 5;  
    }
    u1_prev_SW_DOWN = u1_state_SW_DOWN;
  } 
}

void LCD_Error(String error){
  while(!u1_LCD_Error_done){
  lcd.clear();
  lcd.home();
  lcd.print("Error opgetreden:");
  lcd.setCursor(0,1);
  lcd.print(error);
  u1_LCD_Error_done = true;
  }
}

