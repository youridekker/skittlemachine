//void setup() {
//  // put your setup code here, to run once:
//pinMode(5, OUTPUT); // S3
//pinMode(6, OUTPUT); //S2
//pinMode(7, INPUT); //OUT
//pinMode(8,OUTPUT); //LED
//pinMode(9,OUTPUT); //S1
/*     Arduino Color Sensing Tutorial
 *      
 *  by Dejan Nedelkovski, www.HowToMechatronics.com
 *  
 */

#define S0 10
#define S1 9
#define S2 6
#define S3 7
#define sensorOut 5
int frequency = 0;
int R = 0;
int G = 0;
int B = 0;

void setup() {
  pinMode(8,  OUTPUT);
  pinMode(S0, OUTPUT);
  pinMode(S1, OUTPUT);
  pinMode(S2, OUTPUT);
  pinMode(S3, OUTPUT);
  pinMode(sensorOut, INPUT);
  
  // Setting frequency-scaling to 20%
  digitalWrite(S0,HIGH);
  digitalWrite(S1,LOW);
  digitalWrite(8,HIGH);
  
  Serial.begin(9600);
}
void loop() {
  // Setting red filtered photodiodes to be read
  digitalWrite(S2,LOW);
  digitalWrite(S3,LOW);
  // Reading the output frequency
  R = pulseIn(sensorOut, LOW);
  // Printing the value on the serial monitor
  
  delay(100);
  
  // Setting Green filtered photodiodes to be read
  digitalWrite(S2,HIGH);
  digitalWrite(S3,HIGH);
  // Reading the output frequency
  G = pulseIn(sensorOut, LOW);
  // Printing the value on the serial monitor
  
  delay(100);
  
  // Setting Blue filtered photodiodes to be read
  digitalWrite(S2,LOW);
  digitalWrite(S3,HIGH);
  // Reading the output frequency
  B = pulseIn(sensorOut, LOW);
  // Printing the value on the serial monitor
 
  delay(100);

  R=constrain(R,450,5649);
  G=constrain(G,430,8005);
  B=constrain(B,306, 5976);

  R  = map(R,450,5649,255,0);   // remap the values so they fit into an 8 bit scale (0..255)
  G  = map(G,430,8005,255,0);
  B  = map(B,306, 5976,255,0);

  Serial.print("R= ");//printing name
  Serial.print(R);//printing RED color frequency
  Serial.print("  ");
  
  Serial.print("G= ");//printing name
  Serial.print(G);//printing RED color frequency
  Serial.print("  ");
  
  Serial.print("B= ");//printing name
  Serial.print(B);//printing RED color frequency
  Serial.println("  ");
  delay(2000);
}
