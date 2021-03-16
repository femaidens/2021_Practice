// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.AnalogGyro;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  public CANSparkMax frontL = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
  public CANSparkMax backL = new CANSparkMax(RobotMap.backLeftPort, MotorType.kBrushless);
  public CANSparkMax midL = new CANSparkMax(RobotMap.midLeftPort, MotorType.kBrushless);

  public CANSparkMax frontR = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless)
  public CANSparkMax backR = new CANSparkMax(RobotMap.backRightPort, MotorType.kBrushless);
  public CANSparkMax midR = new CANSparkMax(RobotMap.midRightPort, MotorType.kBrushless);
  
  public AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public DriveTrain() {}

  public void driveTeleop(){
    double leftSpeed = OI.joytick.getRawAxis(1);
    double rightSpeed = OI.joystick.getRawAxis(5);
    
    frontL.set(leftSpeed);
    backL.set(leftSpeed);
    midL.set(leftSpeed);
    frontR.set(rightSpeed);
    backR.set(rightSpeed);
    midR.set(rightSpeed);

  }
  
  public void driveStraight(double speed){
    frontL.set(speed);
    backL.set(speed);
    midL.set(speed);
    frontR.set(speed);
    backR.set(speed);
    midR.set(speed);
  }

  public void turnDegrees(double angle){
    if(angle > 180){
      angle = -(360-angle);
    }

    while(gyro.getAngle() = angle){
      if (angle < 0) {
        frontL.set(-1.0);
        backL.set(-1.0);
        midL.set(-1.0);
        frontR.set(1.0);
        backR.set(1.0);
        midR.set(1.0);
      } else {
        frontL.set(1.0);
        backL.set(1.0);
        midL.set(1.0);
        frontR.set(-1.0);
        backR.set(-1.0);
        midR.set(-1.0);
      }
    }
  }

  public void stop(){
    frontL.set(0.0);
    backL.set(0.0);
    midL.set(0.0);
    frontR.set(0.0);
    backR.set(0.0);
    midR.set(0.0);
  }

  public void auton(double leftSpeed, double rightSpeed){
    frontL.set(leftSpeed);
    backL.set(leftSpeed);
    midL.set(leftSpeed);
    frontR.set(rightSpeed);
    backR.set(rightSpeed);
    midR.set(rightSpeed);

  }

  @Override
  public void periodic() {
    //setDefaultCommand();
  }


}