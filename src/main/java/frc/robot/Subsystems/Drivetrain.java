// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.OI;
import frc.robot.Commands.DriveTeleop;

import edu.wpi.first.wpilibj.AnalogGyro;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

/** Add your docs here. */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);
  public CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);
  public CANSparkMax middleRight = new CANSparkMax(RobotMap.middleRightPort, MotorType.kBrushless);
  public CANSparkMax middleLeft = new CANSparkMax(RobotMap.middleLeftPort, MotorType.kBrushless);
  public CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);
  public CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);

  public CANEncoder rightEncoder = frontRight.getEncoder();
  public CANEncoder leftEncoder = frontLeft.getEncoder();

  public AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveTeleop());
  }

  public void driveTeleop() {
    double leftJoy = OI.driverJoy.getRawAxis(0); // number
    double rightJoy = OI.driverJoy.getRawAxis(1);

    frontRight.set(rightJoy);
    frontLeft.set(leftJoy);
    middleRight.set(rightJoy);
    middleLeft.set(leftJoy);
    rearRight.set(rightJoy);
    rearLeft.set(leftJoy);

  }

  public void auton(double speed) {
    frontRight.set(speed);
    frontLeft.set(speed);
    middleRight.set(speed);
    middleLeft.set(speed);
    rearRight.set(speed);
    rearLeft.set(speed);
  }

  public void driveStraight() {
    if (frontRight.get() > frontLeft.get()) { 
      frontRight.set(0.8);
      frontLeft.set(0.5);
      middleRight.set(0.8);
      middleLeft.set(0.5);
      rearRight.set(0.8);
      rearLeft.set(0.5);
    } else if (frontRight.get() < frontLeft.get()) {
      frontRight.set(0.5);
      frontLeft.set(0.8);
      middleRight.set(0.5);
      middleLeft.set(0.8);
      rearRight.set(0.5);
      rearLeft.set(0.8);
    } else {
      frontRight.set(0.8);
      frontLeft.set(0.8);
      middleRight.set(0.8);
      middleLeft.set(0.8);
      rearRight.set(0.8);
      rearLeft.set(0.8);
    }
  }

  public void turnDegrees(double angle) {
    if (angle > 180) { // setting the angle negative
      angle = -(360-angle);
    }

    while (gyro.getAngle() != angle) {
      if (gyro.getAngle() > angle) { // robot needs to turn left (right moves faster)
        frontRight.set(0.8);
        frontLeft.set(-0.8);
        middleRight.set(0.8);
        middleLeft.set(-0.8);
        rearRight.set(0.8);
        rearLeft.set(-0.8);
      } else { // robot needs to turn right (left moves faster)
        frontRight.set(-0.8);
        frontLeft.set(0.8);
        middleRight.set(-0.8);
        middleLeft.set(0.8);
        rearRight.set(-0.8);
        rearLeft.set(0.8);
      }
    }
  }

  public void stop() {
    frontRight.set(0.0);
    frontLeft.set(0.0);
    middleRight.set(0.0);
    middleLeft.set(0.0);
    rearRight.set(0.0);
    rearLeft.set(0.0);
  }
}
