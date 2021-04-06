// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/*
Hatch Mechanism: One piston that allows the mechansim to extend out of frame perimeter. 
Another piston that allows you to intake and outtake a game piece.

hatch - one piston that makes it go outside frame perimeter, in and out for piston that 
makes it grab the game piece, (two total pistons - one that goes out in the beg, second 
goes in and out at driver/operators command)
*/

/** Add your docs here. */
public class Hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DoubleSolenoid hatchPiston = new DoubleSolenoid(RobotMap.hatchPistonPort1, RobotMap.hatchPistonPort2);
  public DoubleSolenoid intakePiston = new DoubleSolenoid(RobotMap.intakePistonPort1, RobotMap.intakePistonPort2);

  public void extend() {
    hatchPiston.set(DoubleSolenoid.Value.kForward);
  }

  public void retract() {
    hatchPiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void extendIntake() {
    intakePiston.set(DoubleSolenoid.Value.kForward);
  }

  public void retractIntake() {
    intakePiston.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
