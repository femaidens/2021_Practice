// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;
import frc.robot.Robot;

import frc.robot.Subsystems.*;
import frc.robot.Commands.*;

import edu.wpi.first.wpilibj.command.Command;

public class switchAuton extends Command {

  private double levels;

  public switchAuton(int x) {
    requires(Robot.Lift);
    levels = x;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.Lift.shiftLevel(Robot.Lift.getCurrentLevel() - levels);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.Lift.getCurrentLevel() == levels){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.Lift.stop();
  }
}
