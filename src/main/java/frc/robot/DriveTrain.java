// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveTrain extends Subsystem {
	public CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
	public CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
	public CANSparkMax middleRight = new CANSparkMax(RobotMap.midRightPort, MotorType.kBrushless);
 	public CANSparkMax middleLeft = new CANSparkMax(RobotMap.midLeftPort, MotorType.kBrushless);
	public CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
	public CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);
	

  public CANEncoder rightEncoder = frontRight.getEncoder();
  public CANEncoder leftEncoder = frontLeft.getEncoder();

	public AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	
	public DriveTrain() {
	}

	public void initDefaultCommand(){
		setDefaultCommand(new DriveTeleop());
	}

	public void driveTeleop(){
		double leftJoy = OI.driveJoy.getRawAxis(1);
		double rightJoy = OI.driveJoy.getRawAxis(5);
		frontLeft.set(leftJoy);
	  	middleLeft.set(leftJoy);
    	rearLeft.set(leftJoy);
		frontRight.set(rightJoy);
  		middleRight.set(rightJoy);
   	    rearRight.set(rightJoy);
}

public void auton(double speed){
	frontRight.set(speed);
  frontLeft.set(speed);
  middleRight.set(speed);
  middleLeft.set(speed);
  rearRight.set(speed);
  rearLeft.set(speed);
}

public void driveStraight(){
	if(leftEncoder.getPosition() > rightEncoder.getPosition()){
	  frontRight.set(0.8);
	  middleRight.set(0.8);
	  rearRight.set(0.8);
	  frontLeft.set(0.5);
	  middleLeft.set(0.5);
	  rearLeft.set(0.5);
	}
else if(leftEncoder.getPosition() < rightEncoder.getPosition()) {
	  frontRight.set(0.5);
	  middleRight.set(0.5);
	  rearRight.set(0.5);
	  frontLeft.set(0.8);
	  middleLeft.set(0.8);
	  rearLeft.set(0.8);
} else {
	  frontRight.set(0.8);
	  middleRight.set(0.8);
	  rearRight.set(0.8);
  	frontLeft.set(0.8);
	  middleLeft.set(0.8);
	  rearLeft.set(0.8);
}
}

public void turnDegrees(double angle){
	if(angle > 180){
		angle = -(360-angle);
	}
  while(gyro.getAngle() != angle){
		if (gyro.getAngle() < angle) {
			frontRight.set(-0.5);
			frontLeft.set(0.5);
			middleRight.set(-0.5);
			middleLeft.set(0.5);
			rearRight.set(-0.5);
			rearLeft.set(0.5);
		} else {
			frontRight.set(0.5);
			frontLeft.set(-0.5);
			middleRight.set(0.5);
			middleLeft.set(-0.5);
			rearRight.set(0.5);
			rearLeft.set(-0.5);
    }
  }
}

public void stop(){
		frontRight.set(0.0);
	  frontLeft.set(0.0);
    middleRight.set(0.0);
    middleLeft.set(0.0);
  	rearRight.set(0.0);
	  rearLeft.set(0.0);
}
}
