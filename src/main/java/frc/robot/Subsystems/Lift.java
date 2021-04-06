// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.Commands.*;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;

/** Add your docs here. */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public CANSparkMax liftRight1 = new CANSparkMax(RobotMap.liftRight1Port, MotorType.kBrushless);
  public CANSparkMax liftRight2 = new CANSparkMax(RobotMap.liftRight2Port, MotorType.kBrushless);
  public CANSparkMax liftLeft1 = new CANSparkMax(RobotMap.liftLeft1Port, MotorType.kBrushless);
  public CANSparkMax liftLeft2 = new CANSparkMax(RobotMap.liftLeft2Port, MotorType.kBrushless);

  public CANEncoder liftEncoder = liftRight1.getEncoder();
  public CANEncoder liftEncoder2 = liftLeft1.getEncoder();

  public DigitalInput topRight = new DigitalInput(RobotMap.topRightPort);
  public DigitalInput bottomRight = new DigitalInput(RobotMap.bottomRightPort);
  public DigitalInput topLeft = new DigitalInput(RobotMap.topLeftPort);
  public DigitalInput bottomLeft = new DigitalInput(RobotMap.bottomLeftPort);

  private double level1;
  private double level2;

  private double distance = level2-level1; // distance between two levels

  public Lift() {
  }

  public void moveUp() { // moves until getPosition is equal to distance b/w levels
    while(liftEncoder.getPosition() < distance && liftEncoder2.getPosition() < distance) {
      liftRight1.set(0.8);
      liftRight2.set(0.8);
      liftLeft1.set(-0.8);
      liftLeft2.set(-0.8);
      stopLimit();
    }
  }

  public void moveDown() {
    while(liftEncoder.getPosition() > distance && liftEncoder2.getPosition() < distance) {
      liftRight1.set(-0.8); 
      liftRight2.set(-0.8);
      liftLeft1.set(0.8);
      liftLeft2.set(0.8);
      stopLimit();
    }
  }


  public void liftTeleop() {
    double liftJoy = OI.operJoy.getRawAxis(5);

    if(liftJoy < 0) {
      liftRight1.set(-0.8); // for going down
      liftRight2.set(-0.8);
      liftLeft1.set(0.8);
      liftLeft2.set(0.8);
    } else if (liftJoy > 0) {
      liftRight1.set(0.8); // for going up
      liftRight2.set(0.8);
      liftLeft1.set(-0.8);
      liftLeft2.set(-0.8);
    } else {
      stop();
    }

  }

  public void stopLimit() { // for stopping when limit switch is hit
    if(topRight.get() == true || topLeft.get() == true || bottomRight.get() == true || bottomLeft.get() == true) {
      liftRight1.set(0.0);
      liftRight2.set(0.0);
      liftLeft1.set(0.0);
      liftLeft2.set(0.0);
    }
  }

  public void stop() { // for stopping entirely
    liftRight1.set(0.0);
    liftRight2.set(0.0);
    liftLeft1.set(0.0);
    liftLeft2.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftTeleop());
  }
}
