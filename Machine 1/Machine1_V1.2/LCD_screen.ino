//-- Declaratie variabelen --//
boolean u1_maak_keuze             = false;

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
  lcd.print("Set up amount");
  lcd.setCursor(0,1);
  lcd.print("up= nxt/dwn= bck");
  u1_maak_keuze = false;
  while(u1_menu_done == false){
    u1_state_SW_UP = digitalRead(SW_UP);
    u1_state_SW_DOWN = digitalRead(SW_DOWN);
    if(timer_menu()){
      u1_maak_keuze = true;
    }
    
    if(u1_state_SW_UP != u1_prev_SW_UP){
      if(!u1_state_SW_UP && u1_maak_keuze){
        u1_menu_done = true; 
      lcd.clear();
      lcd.home();    
      lcd.print("Setup ect");
      }
    }
  
    if(u1_state_SW_DOWN != u1_prev_SW_DOWN){
      if(!u1_state_SW_DOWN && u1_maak_keuze){
      u1_menu_done = true; 
      Serial.println("M done");
      lcd.clear();
      lcd.home();
      lcd.print("Terg gekeerd");
      }
    }
   u1_prev_SW_DOWN = u1_state_SW_DOWN;
   u1_prev_SW_UP = u1_state_SW_UP;
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

