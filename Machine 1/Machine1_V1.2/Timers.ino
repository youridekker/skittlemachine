int u8_teller_menu            = 0;
unsigned long time_1          = 0;
unsigned long time_2          = 0;
unsigned long time_3          = 0;
unsigned long time_4          = 0;

bool timer_menu(){
  if(millis() > time_1 + 100 && !u1_stop_menu_timer){
    time_1 = millis();
    u8_teller_menu ++;
    Serial.println(u8_teller_menu);                 // DIT VERWIJDEREN
    if(u8_teller_menu >= 10){
      u1_stop_menu_timer = true;
      u8_teller_menu = 0;
      return true;
    }else{
      return false;
    }  
  }
}


