// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Ultrasonic;

/** Add your docs here. */
public class Climb extends Subsystem {

  public static DoubleSolenoid leftFront = new DoubleSolenoid(RobotMap.leftFrontPort1, RobotMap.leftFrontPort2);
  public static DoubleSolenoid leftBack = new DoubleSolenoid(RobotMap.leftBackPort1, RobotMap.leftBackPort2);
  public static DoubleSolenoid rightFront = new DoubleSolenoid(RobotMap.rightFrontPort1, RobotMap.rightFrontPort2);
  public static DoubleSolenoid rightBack = new DoubleSolenoid(RobotMap.rightBackPort1, RobotMap.rightBackPort2);

  public static Ultrasonic sensor = new Ultrasonic(RobotMap.pingChannel, RobotMap.echoChannel);

  public static double distanceFromPlatform;

  public static void raiseBack(){
    leftBack.set(DoubleSolenoid.Value.kForward);
    rightBack.set(DoubleSolenoid.Value.kForward);
  }

  public static void lowerBack(){
    leftBack.set(DoubleSolenoid.Value.kReverse);
    rightBack.set(DoubleSolenoid.Value.kReverse);
  }


  public static void raiseFront(){
    leftFront.set(DoubleSolenoid.Value.kForward);
    rightFront.set(DoubleSolenoid.Value.kForward);
  }

  public static void lowerFront(){
    leftFront.set(DoubleSolenoid.Value.kReverse);
    rightFront.set(DoubleSolenoid.Value.kReverse);
  }

  public static boolean sensorVal(){
    if(sensor.getRangeInches() == distanceFromPlatform){
      return true;
    }
    return false;
  }

  public static void stop(){
    leftFront.set(DoubleSolenoid.Value.kOff);
    rightFront.set(DoubleSolenoid.Value.kOff);
    leftBack.set(DoubleSolenoid.Value.kOff);
    rightBack.set(DoubleSolenoid.Value.kOff);
  }
  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
