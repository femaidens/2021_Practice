// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystems.*;

public class AlignRobot_PID extends Command {
  private static final double KP = 0.1;
	private static final double KI = 1e-3;
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

  public AlignRobot_PID(double s) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    speed = s;
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Limelight.setLEDMode(3);
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(!Limelight.objectSighted()){
      Robot.drivetrain.auton(speed, speed);
    }

    else{
      previous_error = current_error;
      current_error = Limelight.getTx();
      integral = (current_error+previous_error)/2*(time);
      derivative = (current_error-previous_error)/time;
      adjust = (KP*current_error + KI*integral + KD*derivative) * -0.1;

      if(adjust < 0){
        Robot.drivetrain.auton(speed - Math.abs(adjust), speed + Math.abs(adjust));
      }
      else{
        Robot.drivetrain.auton(speed + Math.abs(adjust), speed - Math.abs(adjust));
      }
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
    Limelight.setLEDMode(1);
    Robot.drivetrain.stop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drivetrain.stop();

  }
  

}
