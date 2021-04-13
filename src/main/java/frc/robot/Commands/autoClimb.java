// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

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
    requires(Robot.Climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.Climb.raiseFront();
    while(Robot.Climb.sensorVal()) {
      Robot.DriveTrain.backR.set(0.8);
      Robot.DriveTrain.backL.set(0.8);
    }
    Robot.Climb.raiseBack();
    Robot.Climb.lowerFront();

    while(Robot.Climb.sensorVal()) {
      Robot.DriveTrain.frontR.set(0.8);
      Robot.DriveTrain.frontL.set(0.8);
    }

    Robot.Climb.lowerBack();

    while(Robot.Climb.sensorVal()) {
      Robot.DriveTrain.frontR.set(0.8);
      Robot.DriveTrain.frontL.set(0.8);
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
    Robot.Subsystems.Climb.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.Subsystems.Climb.stop();
  }
}
