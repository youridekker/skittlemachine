//-- Declaratie variabelen --//

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

