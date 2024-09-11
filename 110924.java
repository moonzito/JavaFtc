package org.firstinspires.ftc.teamcode.Tutorial;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "110924", group = "Tutorial")
public class BasicTeleop extends OpMode {
    
    DcMotor leftFront, rightFront;
    DcMotor leftRear, rightRear;
    
    Servo claw;
    
    @Override
    public void init(){
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "RightRear");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        claw = hardwareMap.get(Servo.class, "claw");
    }
    
    @Override
    public void loop(){
        leftFront.setPower(Range.clip(gamepad1.left_stick_y, -1, 1));
        rightFront.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));
        leftRear.setPower(Range.clip(gamepad1.left_stick_y, -1, 1));
        rightRear.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));
        
        if(gamepad2.a){
            claw.setPosition(0.5);
        }
        else{
            claw.setPosition(1);
        }
    }
}
