// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTeleop extends Command {
  	public DriveTeleop(){
		requires(Robot.drivetrain); 
	}

	protected void initialize(){
	}

	protected void execute(){
		Robot.drivetrain.driveTeleop();
	}

	protected boolean isFinished(){
		return false;
	}

	protected void end() {
		Robot.drivetrain.stop();
	}
	
	protected void interrupted() {
		Robot.drivetrain.stop();
	}
}
