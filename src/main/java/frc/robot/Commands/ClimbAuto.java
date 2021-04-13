// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbAuto extends Command {
  public ClimbAuto() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.climb);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climb.extendFront();
    while(Robot.climb.ultra.getRangeInches() >= 0.5) { //limit switch?
      Robot.drivetrain.rearRight.set(0.8);
      Robot.drivetrain.rearLeft.set(0.8);
    }
    Robot.climb.extendBack();

    while(Robot.climb.ultra.getRangeInches() >= 0.5) {
      Robot.drivetrain.frontRight.set(0.8);
      Robot.drivetrain.frontLeft.set(0.8);
    }

    Robot.climb.retractFront();

    while(Robot.climb.ultra.getRangeInches() >= 0.5) {
      Robot.drivetrain.frontRight.set(0.8);
      Robot.drivetrain.frontLeft.set(0.8);
    }

    Robot.climb.retractBack();
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drivetrain.stop();
  }
}
