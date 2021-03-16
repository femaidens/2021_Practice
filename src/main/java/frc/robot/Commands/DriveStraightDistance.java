// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightDistance extends Command {

  private double distance;

  public DriveStraightDistance(double d) {
    requires(Robot.drivetrain);

    distance = d;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() { // resetting encoders
    Robot.drivetrain.rightEncoder.setPosition(0.0);
    Robot.drivetrain.leftEncoder.setPosition(0.0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.driveStraight();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Robot.drivetrain.rightEncoder.getPosition() >= distance && Robot.drivetrain.leftEncoder.getPosition() >= distance);
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
