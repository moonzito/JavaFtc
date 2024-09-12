
package org.firstinspires.ftc.teamcode.Tutorial;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "110924.2", group = "Tutorial")
public class BasicAutonomous extends LinearOpMode {
    Robot robot = new Robot():
  
    @Override
    public void runOpMode() throws InterruptedException {
        
        waitForStart();
        
        while (opModeIsActive()){
            moveFoward(0.5, 1000);
            stopMotor();
            moveFoward(0.3, 3000);
            stopMotor();
            turnRight(0.7, 2000);
            stopMotor();
        }
    }
    public void moveFoward(double power, long time){
        
        Robot.leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(-power);
        rightRear.setPower(-power);
        
        sleep(time);
    }
    public void turnRight(double power, long time){
        leftFront.setPower(-power);
        leftRear.setPower(-power);
        rightFront.setPower(power);
        rightRear.setPower(power);
        
        sleep(time);
    }
    public void turnLeft(double power, long time){
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(power);
        rightRear.setPower(power);
        
        sleep(time);
    }
    public void stopMotor(){
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }
              }
