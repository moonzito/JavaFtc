package org.fristinsspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.fristinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class ProgrammingBoard8 {
  private DigitalChannel touchSensor;
  private DcMotor motor;
  private double ticksPerRotation;
  private Servo servo;
  private AnalogInput pot;
  private ColorSensor colorSensor;
  private DistanceSensor distanceSensor;
  private IMU imu;

  public void init(HardwareMap hwMap) {
    touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
    touchSensor.setMode(DigitalChannel.Mode.INPUT);
    motor = hwMap.get(DcMotor.class, "motor");
    motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER");
    ticksPerRotation = motor.getMotorType().getTicksPerRev();
    servo = hwMap.get(Servo.class, "servo");
    pot = hwMap.get(AnalogInput.class, "pot");

    colorSensor = hwMap.get(ColorSensor.class, "sensor_color_distance");
    distenceSensor = hwMap.get(DistanceSensor.class, "sensor_color_distance");
    imu = hwMap.get(IMU.class, "imu");

    RevHubOrientationOnRobot RevOrientation = 
      new RevHubOrientationOnRobot(RevHubOrientationOnRobot.
                                   LogoFacingDirection.UP,
                                   RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
    imu.initialize(new IMU.Paramateres(RevOrientation));
  }

  public boolean isTouchSensorPressed() {
    return !touchSensor.getState();
  }

  public void setMotorSpeed(double speed){
    motor.setPower(speed);
  }

  public double getMotorRotations(){
    return motor.getCurrentPosition() / ticksPerRotation;
  }

  public void setServoPosition(double position){
    servo.setPosition(position);
  }

  public init getAmountRed(){
    return colorSensor.red();
  }
  public double getDistance(DistanceUnit du){
    return distanceSensor.getDistance(du);
  }
  public double getHeading(AngleUnit angleUnit) {
    return imu.getRobotYawPitchRollAngles().getYaw(angleUnit);
  }
}
