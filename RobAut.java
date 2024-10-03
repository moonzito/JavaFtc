package org.firstinspires.ftc.teamcode.Tutorial;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "110924.2", group = "Tutorial")
public class BasicAutonomous extends LinearOpMode {
    DcMotor leftFront, rightFront;
    DcMotor leftRear, rightRear;
    
    Servo claw;
    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "RightRear");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        claw = hardwareMap.get(Servo.class, "claw");
        
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
    
    public void moveFoward(double power, double thisdistance){

        while(!(thisdistance == distancia()){
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(-power);
        rightRear.setPower(-power);
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
        }
    public void turnRight(double power, distancia){
        leftFront.setPower(-power);
        leftRear.setPower(-power);
        rightFront.setPower(power);
        rightRear.setPower(power);
        
        sleep(time);
    }
    public void turnLeft(double power, distancia){
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

    public void distancia(){
        double CPR;
        CPR = 560;
        double raio = 37,5 ;
        double circ = 2* Math.PI() * raio;
        double revolutionsLF = (leftFront.getPosition()/ CPR) ;
        double revolutionsLR = (leftRear.getPosition()/ CPR) ;
        double revolutionsRF = (rightFront.getPosition()/ CPR) ;
        double revolutionsRR = (rightRear.getPosition()/ CPR) ;
        double distancia = ((revolutionsLF * circ) + (revolutionsLR * circ) + (revolutionsRF * circ) + (revolutionsRR * circ)) / 4;
        return distancia;
    }
              }
