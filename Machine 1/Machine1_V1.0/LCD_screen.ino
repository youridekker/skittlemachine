//-- Declaratie variabelen --//

void LCD_Status(String message_regel_1, String message_regel_2){
  while(!u1_LCD_Status_done){
  lcd.clear();
  lcd.home();
  lcd.print(message_regel_1);
  lcd.setCursor(0,1);
  lcd.print(message_regel_2);
  u1_LCD_Status_done = true;
  }
}

void LCD_Error(String message){
  
}

