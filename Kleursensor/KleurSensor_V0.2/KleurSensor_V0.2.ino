//V0.1
// eerste opzet
/*
   V0.1
   kleur herkenning onderaan

   V0.2
   kleur herkenning d.m.v. booleans
*/

#define S0 8
#define S1 9
#define S2 12
#define S3 11
#define sensorOut 10

int red   = 0;
int green = 0;
int blue  = 0;

boolean R_Yellow  = false;
boolean R_Orange  = false;
boolean R_Red     = false;
boolean R_Purple  = false;
boolean R_Green   = false;

boolean G_Yellow  = false;
boolean G_Orange  = false;
boolean G_Red     = false;
boolean G_Purple  = false;
boolean G_Green   = false;

boolean B_Yellow  = false;
boolean B_Orange  = false;
boolean B_Red     = false;
boolean B_Purple  = false;
boolean B_Green   = false;

void setup() {
  pinMode(S0, OUTPUT);
  pinMode(S1, OUTPUT);
  pinMode(S2, OUTPUT);
  pinMode(S3, OUTPUT);
  pinMode(sensorOut, INPUT);

  // Setting frequency-scaling to 100%
  digitalWrite(S0, HIGH);
  digitalWrite(S1, HIGH);


  Serial.begin(9600);
}

void loop() {
  //set color booleans false
  R_Yellow = false;
  R_Orange = false;
  R_Red    = false;
  R_Purple = false;
  R_Green  = false;

  G_Yellow = false;
  G_Orange = false;
  G_Red    = false;
  G_Purple = false;
  G_Green  = false;

  B_Yellow = false;
  B_Orange = false;
  B_Red    = false;
  B_Purple = false;
  B_Green  = false;

  // Setting red filtered photodiodes to be read
  digitalWrite(S2, LOW);
  digitalWrite(S3, LOW);

  // Reading the output frequency
  red = pulseIn(sensorOut, LOW);
  red = constrain(red, 13, 71);
  red = map(red, 13, 71, 255, 0);

  //Yellow
  if (red > 127 && red < 221) {
    R_Yellow = true;

    //Orange
  } else if (red > 131 && red < 208) {
    R_Orange = true;

    //Red
  } else if (red > 127 && red < 173) {
    R_Red = true;

    //Purple
  } else if (red > 13 && red < 63) {
    R_Purple = true;

    //Green
  } else if (red > 83 && red < 142) {
    R_Green = true;
  }

  // Setting Green filtered photodiodes to be read
  digitalWrite(S2, HIGH);
  digitalWrite(S3, HIGH);

  // Reading the output frequency
  green = pulseIn(sensorOut, LOW);
  green = constrain(green, 12, 67);
  green = map(green, 12, 67, 255, 0);

  //Yellow
  if (green > 139 && green < 187) {
    G_Yellow = true;

    //Orange
  } else if (green > 41 && green < 69) {
    G_Orange = true;

    //Red
  } else if (green > 4 && green < 52) {
    G_Red = true;

    //Purple
  } else if (green >= 0 && green < 6) {
    G_Purple = true;

    //Green
  } else if (green > 97 && green < 141) {
    G_Green = true;
  }

  // Setting Blue filtered photodiodes to be read
  digitalWrite(S2, LOW);
  digitalWrite(S3, HIGH);

  // Reading the output frequency
  blue = pulseIn(sensorOut, LOW);
  blue = constrain(blue, 3, 48);
  blue = map(blue, 3, 48, 255, 0);

  //Yellow
  if (blue > 50 && blue < 103) {
    B_Yellow = true;

    //Orange
  } else if (blue > 5 && blue < 18) {
    B_Orange = true;

    //Red
  } else if (blue >= 0 && blue < 41) {
    B_Red = true;

    //Purple
  } else if (blue >= 0 && blue < 13) {
    B_Purple = true;

    //Green
  } else if (blue > 16 && blue < 81) {
    B_Green = true;
  }

  //color output
  if (R_Yellow && G_Yellow && B_Yellow) {
    Serial.println("geel");
  } else if (R_Orange && G_Orange && B_Orange) {
    Serial.println("Oranje");
  }

}




