// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

/** Add your docs here. */
public class Climb extends Subsystem {
  public DoubleSolenoid climbFrontPistonL = new DoubleSolenoid(RobotMap.climbPort1, RobotMap.climbPort2);
  public DoubleSolenoid climbFrontPistonR = new DoubleSolenoid(RobotMap.climbPort3, RobotMap.climbPort4);
  public DoubleSolenoid climbBackPistonL = new DoubleSolenoid(RobotMap.climbPort5, RobotMap.climbPort6);
  public DoubleSolenoid climbBackPistonR = new DoubleSolenoid(RobotMap.climbPort7, RobotMap.climbPort8);

  public Ultrasonic distSensor = new Ultrasonic(RobotMap.climbSensorChannel1,RobotMap.climbSensorChannel2);

  public double platformHeight = 12.0;


  public void extendFront(){
    climbFrontPistonL.set(DoubleSolenoid.Value.kForward);
    climbFrontPistonR.set(DoubleSolenoid.Value.kForward);
  }

  public void retractFront(){
    climbFrontPistonL.set(DoubleSolenoid.Value.kReverse);
    climbFrontPistonR.set(DoubleSolenoid.Value.kReverse);
  }

  public void extendBack(){
    climbBackPistonL.set(DoubleSolenoid.Value.kForward);
    climbBackPistonR.set(DoubleSolenoid.Value.kForward);
  }

  public void retractBack(){
    climbBackPistonL.set(DoubleSolenoid.Value.kReverse);
    climbBackPistonR.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
