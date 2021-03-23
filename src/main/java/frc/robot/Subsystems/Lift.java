// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;


/** Add your docs here. */
public class Lift extends Subsystem {
  
  public CANSparkMax rightOne = new CANSparkMax(RobotMap.liftRightOnePort, MotorType.kBrushless);
	public CANSparkMax rightTwo = new CANSparkMax(RobotMap.liftRightTwoPort, MotorType.kBrushless);
	public CANSparkMax leftOne = new CANSparkMax(RobotMap.liftLeftOnePort, MotorType.kBrushless);
 	public CANSparkMax leftTwo = new CANSparkMax(RobotMap.liftLeftTwoPort, MotorType.kBrushless);

  public DigitalInput topRightLimit = new DigitalInput(RobotMap.topLimitSwitchRightPort);
  public DigitalInput topLeftLimit= new DigitalInput(RobotMap.topLimitSwitchLeftPort);
  public DigitalInput botRightLimit = new DigitalInput(RobotMap.botLimitSwitchRightPort);
  public DigitalInput botLeftLimit= new DigitalInput(RobotMap.botLimitSwitchLeftPort);

  public CANEncoder rOneEncoder = rightOne.getEncoder();
  public CANEncoder rTwoEncoder = rightTwo.getEncoder();
  public CANEncoder lOneEncoder = leftOne.getEncoder();
  public CANEncoder lTwoEncoder = leftTwo.getEncoder();

  public int curLvl = 1;
  public int destLvl = 1;
  //this is value for distance between a 1 level difference
  public double distBetweenLevels = 12;

  @Override
  public void initDefaultCommand() {
  }

  public Lift(){
  }

  public void changeLevelNum(){
    destLvl = curLvl;
    if(destLvl<3){
      destLvl++;
    }
    else{
      destLvl = 1;
    }
  }

  public void moveLevels(){
    //FOR MOVING UP LEVELS
    if(destLvl-curLvl > 0){
      double travelDistance = (destLvl-curLvl) * distBetweenLevels;
      //assuming to go up, right motors take pos values and left motors take neg values
      //checks that for all encoders you are less than the distance to be travelled AND that u don't hit upper limits
      while((rOneEncoder.getPosition() < travelDistance && rTwoEncoder.getPosition() < travelDistance && !topRightLimit.get()) 
      && (lOneEncoder.getPosition()< -travelDistance && lTwoEncoder.getPosition()<-travelDistance && !topLeftLimit.get())){
        rightOne.set(0.5);
        rightTwo.set(0.5);
        leftOne.set(-0.5);
        leftTwo.set(-0.5);
      }
    }
    //FOR MOVING DOWN LEVELS
    else if(destLvl-curLvl <0){
      //travel distance is negative but its fine because it is also negative for encoders of right motors which face up
      double travelDistance = (destLvl-curLvl) * distBetweenLevels;
      //assuming to go up, right motors take pos values and left motors take neg values
      //checks that for all encoders you are less than the distance to be travelled AND that u don't hit upper limits
      while((rOneEncoder.getPosition() < travelDistance && rTwoEncoder.getPosition() < travelDistance && !botRightLimit.get()) 
      && (lOneEncoder.getPosition()< -travelDistance && lTwoEncoder.getPosition()<-travelDistance && !botLeftLimit.get())){
        rightOne.set(-0.5);
        rightTwo.set(-0.5);
        leftOne.set(0.5);
        leftTwo.set(0.5);
      }
    }

    //IF YOU ARE ALREADY AT UR DESIRED LEVEL (destLvl-curLvl = 0) THIS METHOD DOES NOTHING ^^^
  }

  public void stop(){
    rightOne.set(0.0);
    rightTwo.set(0.0);
    leftOne.set(0.0);
    leftTwo.set(0.0);
  }

  public void manualMove(){
    double liftSpeed = OI.driveJoy.getRawAxis(1);
    //while no limit switch is pressed and you are within range, the motors are controlled by driver joy's joystick rotation rawaxis thingy
    while(!topRightLimit.get() && !topLeftLimit.get() && !botRightLimit.get() && !botLeftLimit.get()){
      rightOne.set(liftSpeed);
      rightTwo.set(liftSpeed);
      leftOne.set(-liftSpeed);
      leftTwo.set(-liftSpeed);
    }
  }

}
