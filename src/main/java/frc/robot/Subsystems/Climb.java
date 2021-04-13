// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Ultrasonic;

/** Add your docs here. */
public class Climb extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static DoubleSolenoid front1 = new DoubleSolenoid(RobotMap.front1Port1, RobotMap.front1Port2);
  public static DoubleSolenoid front2 = new DoubleSolenoid(RobotMap.front2Port1, RobotMap.front2Port2);
  public static DoubleSolenoid rear1 = new DoubleSolenoid(RobotMap.rear1Port1, RobotMap.rear1Port2);
  public static DoubleSolenoid rear2 = new DoubleSolenoid(RobotMap.rear2Port1, RobotMap.rear2Port2);

  public static Ultrasonic ultra = new Ultrasonic(RobotMap.ultrasonicPort1, RobotMap.ultrasonicPort2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void extendFront() {
    front1.set(DoubleSolenoid.Value.kForward);
    front2.set(DoubleSolenoid.Value.kForward);
  }

  public void extendBack() {
    rear1.set(DoubleSolenoid.Value.kForward);
    rear2.set(DoubleSolenoid.Value.kForward); 
  }

  public void retractFront() {
    front1.set(DoubleSolenoid.Value.kReverse);
    front2.set(DoubleSolenoid.Value.kReverse);
  }

  public void retractBack() {
    rear1.set(DoubleSolenoid.Value.kReverse);
    rear2.set(DoubleSolenoid.Value.kReverse); 
  }

  
}
