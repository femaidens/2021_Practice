// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {

	private double dist;

	public DriveStraight(double d) {
		requires(Robot.drivetrain);
		dist = d;
	}
	protected void initialize() {
  }

	protected void execute() {
		Robot.drivetrain.driveStraight();
	}

	protected boolean isFinished(){
		return(Robot.drivetrain.rightEncoder.getPosition() >= dist && Robot.drivetrain.leftEncoder.getPosition() >=  dist);
  }

  protected void end(){
  Robot.drivetrain.stop();
  }

protected void interrupted() {
	Robot.drivetrain.stop();
}
} 
