// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class Hatch extends Subsystem {

  public static DoubleSolenoid sol1 = new DoubleSolenoid(RobotMap.hatchPerimeterPort1, RobotMap.hatchPerimeterPort2);
  public static DoubleSolenoid sol2 = new DoubleSolenoid(RobotMap.hatchInOutPort1, RobotMap.hatchInOutPort2);

  public static void extendFramePerimeter(){
    sol1.set(DoubleSolenoid.Value.kForward);
  }

  public static void retractFramePerimeter(){
    sol1.set(DoubleSolenoid.Value.kReverse);
  }


  public static void intakeGamePiece(){
    sol2.set(DoubleSolenoid.Value.kReverse);
  }

  public static void outtakeGamePiece(){
    sol2.set(DoubleSolenoid.Value.kForward);
  }

  public static void stop(){
    sol1.set(DoubleSolenoid.Value.kOff);
    sol2.set(DoubleSolenoid.Value.kOff);
  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
