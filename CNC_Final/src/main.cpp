#include <Arduino.h>
#include <WiFi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <AccelStepper.h>
#include <MultiStepper.h>
#include <math.h>

#include <LiquidCrystal_I2C.h>

#define motorInterfaceType_1 1

#define stepPin_y 26
#define dirPin_y 25

#define dirPin_x 33
#define stepPin_x 32

AccelStepper stepperY = AccelStepper(motorInterfaceType_1, stepPin_y, dirPin_y);
AccelStepper stepperX = AccelStepper(motorInterfaceType_1, stepPin_x, dirPin_x);

MultiStepper steppers;

WiFiServer server(80);

LiquidCrystal_I2C lcd(0x27, 16, 2);

long positions[2];

const char *ssid = "NETLIFE-JOSE";
const char *password = "Josemedjay19*";

char inputBuffer[100];
char *pch;
char *startPtr, *endPtr = nullptr;

unsigned long currentTime = millis();
// Previous time
unsigned long previousTime = 0;
// Define timeout time in milliseconds (example: 2000ms = 2s)
const long timeoutTime = 2000;

long e;

int count = 0;

void setup()
{
  lcd.init();
  lcd.backlight();
  Serial.begin(115200);

  // Connect to Wi-Fi network with SSID and password
  Serial.print("Conectando a ");
  lcd.setCursor(0, 0);
  lcd.print("Conectando....");
  Serial.println(ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  lcd.clear();
  // Print local IP address and start web server
  Serial.println("");
  Serial.println("WiFi conectado.");
  lcd.setCursor(0, 0);
  lcd.print("Conectado!");

  Serial.println("Dirección IP:");
  Serial.println(WiFi.localIP());
  server.begin();

  stepperX.setMaxSpeed(1000);
  stepperX.setSpeed(300);
  stepperX.setAcceleration(300);
  stepperX.setCurrentPosition(0);

  stepperY.setMaxSpeed(1000);
  stepperY.setSpeed(300);
  stepperY.setAcceleration(300);
  stepperY.setCurrentPosition(0);

  steppers.addStepper(stepperX);
  steppers.addStepper(stepperY);
  delay(1000);
  lcd.clear();
}

void loop()
{

  lcd.setCursor(0, 0);
  lcd.print("En espera de");
  lcd.setCursor(0, 1);
  lcd.print("cliente...");

  WiFiClient client = server.available();

  if (client)
  { // If a new client connects,
    lcd.clear();
    currentTime = millis();
    previousTime = currentTime;
    Serial.println("New Client.");
     lcd.setCursor(0, 0);
     lcd.print("Cliente");
     lcd.setCursor(0, 1);
     lcd.print("Conectado!");
     // print a message out in the serial port
    String currentLine = "";       // make a String to hold incoming data from the client
    while (client.connected() && currentTime - previousTime <= timeoutTime)
    { // loop while the client's connected
      currentTime = millis();
      if (client.available())
      { // if there's bytes to read from the client,
        // char c = client.read();             // read a byte, then
        client.readBytes(inputBuffer, 100);
        delay(3000);
        Serial.print("I got this ->");
        Serial.print(inputBuffer);
        Serial.println("<-");
        printf("Splitting string \"%s\" into tokens:\n", inputBuffer);
        pch = strtok(inputBuffer, ",");

        while (pch != NULL)
        {
          e = strtoul(pch, NULL, 0);
          // Serial.println(e);
          if (count % 2 == 0)
          {
            lcd.clear();
            Serial.print("X: ");
            lcd.setCursor(0,0);
            Serial.println(e);
            lcd.print("X: ");
            positions[0] = e;
            lcd.print(e);
            Serial.print("Count: ");
            Serial.println(count);
          }
          else
          {
            Serial.print("Y: ");
            lcd.setCursor(0,1);
            Serial.println(e);
            lcd.print("Y: ");
            positions[1] = e;
            lcd.print(e);
            Serial.print("Count: ");
            Serial.println(count);
            steppers.moveTo(positions);
            steppers.runSpeedToPosition();
            stepperX.setCurrentPosition(0);
            stepperY.setCurrentPosition(0);
            delay(500);
          }

          count++;
          pch = strtok(NULL, " ,");
        }
        count = 0;
      }
    }
  }
}