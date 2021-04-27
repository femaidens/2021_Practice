// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;
import frc.robot.Subsystems.*;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class autoClimb extends Command {

  public static double distance;
  // when true, up
  // when false, down
  public static boolean direction;

  public autoClimb(int x, boolean d) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    distance = x;
    direction = d;
    requires(Robot.climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.climb.raiseFront();
    while(Robot.climb.sensorVal()) {
      Robot.driveTrain.backR.set(0.8);
      Robot.driveTrain.backL.set(0.8);
    }
    Robot.climb.raiseBack();
    Robot.climb.lowerFront();

    while(Robot.climb.sensorVal()) {
      Robot.driveTrain.frontR.set(0.8);
      Robot.driveTrain.frontL.set(0.8);
    }

    Robot.climb.lowerBack();

    while(Robot.climb.sensorVal()) {
      Robot.driveTrain.frontR.set(0.8);
      Robot.driveTrain.frontL.set(0.8);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.climb.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.climb.stop();
  }
}
