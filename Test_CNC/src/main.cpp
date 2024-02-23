#include <Arduino.h>
#include <WiFi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <AccelStepper.h>
#include <MultiStepper.h>
#include <math.h>

#define motorInterfaceType_1 1

#define stepPin_y 13
#define dirPin_y 27

#define dirPin_x 33
#define stepPin_x 32

AccelStepper stepperY = AccelStepper(motorInterfaceType_1, stepPin_y, dirPin_y);
AccelStepper stepperX = AccelStepper(motorInterfaceType_1, stepPin_x, dirPin_x);

MultiStepper steppers;

long positions[2];

void setup()
{

  Serial.begin(115200);

  // Connect to Wi-Fi network with SSID and password

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
}

void loop()
{
  stepperX.setCurrentPosition(0);
  stepperY.setCurrentPosition(0);

  positions[0] = -6000;
  positions[1] = 0;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  delay(500);
  positions[0] = -6000;
  positions[1] = -6000;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  delay(500);
  positions[0] = 0;
  positions[1] = -6000;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  delay(500);
  positions[0] = 0;
  positions[1] = 0;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  delay(500);

  positions[0] = -5000;
  positions[1] = 0;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  delay(500);
  positions[0] = -2500;
  positions[1] = -4330;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  delay(500);
  positions[0] = 0;
  positions[1] = 0;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  delay(500);

  positions[0] = -2000;
  positions[1] = 0;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  stepperX.setCurrentPosition(0);
  stepperY.setCurrentPosition(0);
  delay(500);
  positions[0] = -1000;
  positions[1] = -1732;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  stepperX.setCurrentPosition(0);
  stepperY.setCurrentPosition(0);
  delay(500);
  positions[0] = 1000;
  positions[1] = -1732;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  stepperX.setCurrentPosition(0);
  stepperY.setCurrentPosition(0);
  delay(500);
  positions[0] = 2000;
  positions[1] = 0;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  stepperX.setCurrentPosition(0);
  stepperY.setCurrentPosition(0);
  delay(500);
  positions[0] = 1000;
  positions[1] = 1732;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  stepperX.setCurrentPosition(0);
  stepperY.setCurrentPosition(0);
  delay(500);
  positions[0] = -1000;
  positions[1] = 1732;
  steppers.moveTo(positions);
  steppers.runSpeedToPosition();
  stepperX.setCurrentPosition(0);
  stepperY.setCurrentPosition(0);
  delay(500);
}