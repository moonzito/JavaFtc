package org.firstinspires.ftc.teamcode.Tutorial;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot{

  public HardwareMap hardwareMap;
  
  public DcMotor leftFront;
  public DcMotor rightFront;
  public DcMotor leftBack;
  public DcMotor rightBack:

  public Servo claw;

  public Robot(){
      leftFront = hardwareMap.get(DcMotor.class, "leftFront");
      RightFront = hardwareMap.get(DcMotor.class, "RightFront");
      leftBack = hardwareMap.get(DcMotor.class, "leftBack");
      RightBack = hardwareMap.get(DcMotor.class, "RightBack");
      
      LeftFront.setMode(DcMotor.ZeroPowerBehavior.BRAKE);
      RightFront.setMode(DcMotor.ZeroPowerBehavior.BRAKE);
      LeftBack.setMode(DcMotor.ZeroPowerBehavior.BRAKE);
      RightBack.setMode(DcMotor.ZeroPowerBehavior.BRAKE);
  }
  
}
