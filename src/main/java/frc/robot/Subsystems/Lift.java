// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Commands.*;

/** Add your docs here. */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax frontRightLift = new CANSparkMax(RobotMap.frLift, MotorType.kBrushless);
  CANSparkMax backRightLift = new CANSparkMax(RobotMap.brLift, MotorType.kBrushless);
  CANSparkMax frontLeftLift = new CANSparkMax(RobotMap.flLift, MotorType.kBrushless);
  CANSparkMax backLeftLift = new CANSparkMax(RobotMap.blLift, MotorType.kBrushless);

  DigitalInput rightLimitTop = new DigitalInput(RobotMap.rightLimitTopPort);
  DigitalInput rightLimitBot = new DigitalInput(RobotMap.rightLimitBotPort);
  DigitalInput leftLimitTop = new DigitalInput(RobotMap.leftLimitTopPort);
  DigitalInput leftLimitBot = new DigitalInput(RobotMap.leftLimitBotPort);

  CANEncoder liftRightEnc = frontRightLift.getEncoder();
  CANEncoder liftLeftEnc = frontLeftLift.getEncoder();

  //I assume that whenever the robot is turned on, the lift is on the lowest level
  private static int currentLevel = 1;

  //I assume the bottom most level is level 1 and top most is level 3
  //variables that hold the distances (in inches) between each level.
  private double level12;
  private double level23;

  //convert ticks to inches with made up conversion factor
  //idk if these work correctly so I'll leave them commented
  //private static double ticksConversion = 1.0;
  //CANError r = liftRightEnc.setPositionConversionFactor(ticksConversion);
  //CANError l = liftLeftEnc.setPositionConversionFactor(ticksConversion);



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new OperLift());
  }

  public void operLift(){
    double leftLiftJoy = OI.operJoy.getRawAxis(1);
    double rightLiftJoy = OI.operJoy.getRawAxis(5);
    //right and left motors go in opposite directions
    frontRightLift.set(rightLiftJoy);
    backRightLift.set(rightLiftJoy);
    frontLeftLift.set(-leftLiftJoy);
    backLeftLift.set(-leftLiftJoy);
  }

  public void upLevel(){
    double currentLeftEnc = liftLeftEnc.getPosition();
    double currentRightEnc = liftRightEnc.getPosition();
    if(currentLevel == 1){
      while(liftLeftEnc.getPosition()-currentLeftEnc < level12 && liftRightEnc.getPosition()-currentRightEnc < level12){
        frontRightLift.set(0.7);
        backRightLift.set(0.7);
        frontLeftLift.set(-0.7);
        backLeftLift.set(-0.7);
      }
      stop();
      currentLevel = 2;
    }
    else if(currentLevel == 2){
      while(liftLeftEnc.getPosition()-currentLeftEnc < level23 && liftRightEnc.getPosition()-currentRightEnc < level23 && !rightLimitTop.get() && !leftLimitTop.get()){
        frontRightLift.set(0.7);
        backRightLift.set(0.7);
        frontLeftLift.set(-0.7);
        backLeftLift.set(-0.7);
      }
      stop();
      currentLevel = 3;
    }
  }

  public void downLevel(){
    double currentLeftEnc = liftLeftEnc.getPosition();
    double currentRightEnc = liftRightEnc.getPosition();
    if(currentLevel == 3){
      while(currentLeftEnc-liftLeftEnc.getPosition() < level23 && currentRightEnc-liftRightEnc.getPosition() < level23){
        frontRightLift.set(-0.7);
        backRightLift.set(-0.7);
        frontLeftLift.set(0.7);
        backLeftLift.set(0.7);
      }
      stop();
      currentLevel = 2;
    }
    else if(currentLevel == 2){
      while(currentLeftEnc-liftLeftEnc.getPosition() < level12 && currentRightEnc-liftRightEnc.getPosition() < level12 && !rightLimitBot.get() && !leftLimitBot.get()){
        frontRightLift.set(-0.7);
        backRightLift.set(-0.7);
        frontLeftLift.set(0.7);
        backLeftLift.set(0.7);
      }
      stop();
      currentLevel = 1;
    }
  }
  
  public void stop(){
    frontRightLift.set(0.0);
    backRightLift.set(0.0);
    frontLeftLift.set(0.0);
    backLeftLift.set(0.0);
  }
}
