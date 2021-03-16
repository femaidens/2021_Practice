// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;


/** Add your docs here. */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
  CANSparkMax middleLeft = new CANSparkMax(RobotMap.middleLeftPort, MotorType.kBrushless);
  CANSparkMax backLeft = new CANSparkMax(RobotMap.backLeftPort, MotorType.kBrushless);
  CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
  CANSparkMax middleRight = new CANSparkMax(RobotMap.middleRightPort, MotorType.kBrushless);
  CANSparkMax backRight = new CANSparkMax(RobotMap.backRightPort, MotorType.kBrushless);

  public AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public CANEncoder leftEncoder = frontLeft.getEncoder();
  public CANEncoder rightEncoder = frontRight.getEncoder();

  public Joystick joy = new Joystick(RobotMap.joyPort);


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveTeleop());
  }

  public void driveTeleop(){
    double leftJoy = joy.getRawAxis(1);
    double rightJoy = joy.getRawAxis(2);
    frontLeft.set(leftJoy);
    middleLeft.set(leftJoy);
    backLeft.set(leftJoy);
    frontRight.set(rightJoy);
    middleRight.set(rightJoy);
    backRight.set(rightJoy);
  }

  public void driveStraight(){
    if(leftEncoder.getPosition() > rightEncoder.getPosition()){
      frontLeft.set(0.5);
      middleLeft.set(0.5);
      backLeft.set(0.5);
      frontRight.set(0.7);
      middleRight.set(0.7);
      backRight.set(0.7);
    }
    else if(leftEncoder.getPosition() < rightEncoder.getPosition()){
      frontLeft.set(0.7);
      middleLeft.set(0.7);
      backLeft.set(0.7);
      frontRight.set(0.5);
      middleRight.set(0.5);
      backRight.set(0.5);
    }
    else{
      frontLeft.set(0.7);
      middleLeft.set(0.7);
      backLeft.set(0.7);
      frontRight.set(0.7);
      middleRight.set(0.7);
      backRight.set(0.7);
    }
  }

  public void turnDegrees(double angle){
    if(angle > 180){
      angle = -(360-angle);
    }
    while (gyro.getAngle() != angle){
      if(gyro.getAngle() > angle){
        frontLeft.set(-0.2);
        middleLeft.set(-0.2);
        backLeft.set(-0.2);
        frontRight.set(0.6);
        middleRight.set(0.6);
        backRight.set(0.6);
      }
      if(gyro.getAngle() > angle){
        frontLeft.set(0.6);
        middleLeft.set(-0.6);
        backLeft.set(0.6);
        frontRight.set(-0.2);
        middleRight.set(-0.2);
        backRight.set(-0.2);
      }
    }
  }

  public void stop(){
    frontLeft.set(0.0);
    middleLeft.set(0.0);
    backLeft.set(0.0);
    frontRight.set(0.0);
    middleRight.set(0.0);
    backRight.set(0.0);
  }

}
