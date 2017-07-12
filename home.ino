/** biswajit mohapatra and chandan dash 
 *  This project uses a arduino uno ,pir sensor ,2 switch relay ,jumper wires,breadboard,led lights,a keypad(4*4),Bulb,Servo Motor and this project uses the keypad library file which you need to download from 
 *  https://github.com/Chris--A/Keypad and then add it to the library .
 *  you can change the keypad confirguation of the pins but the should be connected in the way they are written.
 *  we have commenetd the servo motor as different servo motor has different confirguation so you need to check it adn then use the servo motor .
 *  You can also use the analog pins for digital communication(use only led) if you feel short of gpi pins.
 *  
 */
#define in1 10
#define pirpin 11
//#include <Servo.h>
#include <Keypad.h>

//Servo ServoMotor;
char* password = "789";  // change the password here, just pick any 3 numbers
int position = 0;
const byte ROWS = 4;
const byte COLS = 4;
char keys[ROWS][COLS] = {
{'1','2','3','A'},
{'4','5','6','B'},
{'7','8','9','C'},
{'*','0','#','D'}
};

byte rowPins[ROWS] = { 8, 7, 6, 9 };
byte colPins[COLS] = { 5, 4, 3, 2 };
Keypad keypad = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );
int RedpinLock = 13; //for the led 
int GreenpinUnlock = 12; //for the green led 
int sensor;
void setup()
{
  Serial.begin(9600);
  pinMode(pirpin,INPUT);
  delay(1000);
  pinMode(in1,OUTPUT);
pinMode(RedpinLock, OUTPUT);
pinMode(GreenpinUnlock, OUTPUT);
//ServoMotor.attach(11);
LockedPosition(true);
//digitalWrite(in1,LOW);
}

void loop()
{
digitalWrite(in1,HIGH);
sensor=digitalRead(pirpin);
if(sensor==1)
{
  digitalWrite(in1,LOW);
}
else
{
  digitalWrite(in1,HIGH);
}
char key = keypad.getKey();
if (key == '*' || key == '#')
{
position = 0;
LockedPosition(true);
digitalWrite(in1,HIGH);
}
if (key == password[position])
{
position ++;
}
if (position == 3)
{
LockedPosition(false);
}
delay(100);
}
void LockedPosition(int locked)
{
if (locked)
{
digitalWrite(RedpinLock, HIGH);
digitalWrite(GreenpinUnlock, LOW);
//ServoMotor.write(11);
}
else
{
Serial.println("worked");
digitalWrite(RedpinLock, LOW);
digitalWrite(GreenpinUnlock, HIGH);
//ServoMotor.write(90);
}
}