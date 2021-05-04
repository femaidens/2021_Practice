// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoAlign extends Command {
  private static final double KP = 0.1;
	private static final double KI = 0.0;
	private static final double KD = 0.0;

  public static double speed;

  private static double min_error = 0.1;
  private static double min_command = 0.0;
  static double current_error = 0.0; 
  static double previous_error = 0.0; 
  static double integral = 0.0;
  static double derivative = 0.0;
  static double adjust = 0.0;
  static double time = 0.1;

  public AutoAlign(double s){
    speed = s;
    requires(Robot.limelight);
  }


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.limelight.setLiveStream(0);
    Robot.limelight.setLEDMode(3);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {     
    if(Robot.limelight.objectSighted()) {
      previous_error = current_error;
      current_error = Robot.limelight.getTx();
      integral = (current_error+previous_error)/2*(time);
      derivative = (current_error-previous_error)/time;
      adjust = (KP*current_error + KI*integral + KD*derivative) * -0.1;

      if(adjust < 0) {
        Robot.drivetrain.auton(speed + adjust, speed - adjust); // driveAuton
      } else {
        Robot.drivetrain.auton(speed - adjust, speed + adjust); // driveAuton
      }
      
      //if adjust is negative, turn left
      //if adjust is positive, turn right
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
    Robot.limelight.setLEDMode(1);
    Robot.drivetrain.stop();
  }


  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drivetrain.stop();
  }
}
