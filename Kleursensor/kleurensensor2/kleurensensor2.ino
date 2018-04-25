
#define S1 9
#define S2 6
#define S3 5
#define out 7
#define LED 8

int R = 0;
int G = 0;
int B = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(S1, OUTPUT);
  pinMode(S2, OUTPUT);
  pinMode(S3, OUTPUT);
  pinMode(out, INPUT);
  pinMode(LED, OUTPUT);

  //
}

void loop() {
  //Red
  R=digitalRead(out);
}
