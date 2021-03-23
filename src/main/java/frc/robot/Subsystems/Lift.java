// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.RobotMap;
import frc.robot.OI;

public class Lift extends Subsystem {

  CANSparkMax left1 = new CANSparkMax(RobotMap.left1Port, MotorType.kBrushless);
  CANSparkMax left2 = new CANSparkMax(RobotMap.left2Port, MotorType.kBrushless);
  CANSparkMax right1 = new CANSparkMax(RobotMap.right1Port, MotorType.kBrushless);
  CANSparkMax right2 = new CANSparkMax(RobotMap.right2Port, MotorType.kBrushless);

  public CANEncoder encoder = left1.getEncoder();

  DigitalInput limitTop1 = new DigitalInput(RobotMap.limPortT1);
  DigitalInput limitTop2 = new DigitalInput(RobotMap.limPortT2);
  DigitalInput limitBottom1 = new DigitalInput(RobotMap.limPortB1);
  DigitalInput limitBottom2 = new DigitalInput(RobotMap.limPortB2);

  // encoders
  // each level = set amount of distance
  // run for that distance (each time you add distance, change value of currentLevel accordingly)
  private int currentLevel = 1;
  // number of rotations it takes to get from one level to another; 5 is a placeholder
  private static int levelDistance = 5;

  public void stop(){
    left1.set(0.0);
    left2.set(0.0);
    right1.set(0.0);
    right2.set(0.0);
  }

  public void teleopShift(){
    if(OI.Joystick.upButton.getYButtonPressed()){
      shiftLevel(1);
    } 
    else if (OI.Joystick.downButton.getAButtonPressed()){
      shiftLevel(-1);
    }
  }

  public void shiftLevel(int num){
    int d = levelDistance * num;

    if(d > 0){
      while(encoder.getPosition() != d && !upperLimits()){
        left1.set(1.0);
        left2.set(1.0);
        right1.set(-1.0);
        right2.set(-1.0);
      }
      currentLevel += num;
    }

    else if(d < 0){
      while(encoder.getPosition() != d && !lowerLimits()){
        left1.set(-1.0);
        left2.set(-1.0);
        right1.set(1.0);
        right2.set(1.0);
      }
      currentLevel += num;
    }
  }

  public int getCurrentLevel(){
    return currentLevel;
  }

  public boolean upperLimits(){
    return limitTop1.get() || limitTop2.get();
  }

  public boolean lowerLimits(){
    return limitBottom1.get() || limitBottom2.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
