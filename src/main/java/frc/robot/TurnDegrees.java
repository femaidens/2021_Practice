// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnDegrees extends Command {
  public TurnDegrees() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  private double angle;

	public TurnDegrees(double a) {
		requires(Robot.drivetrain);
		angle = a;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.drivetrain.turnDegrees(angle);
	}

	protected boolean isFinished(){
		return true;
}

protected void end(){
Robot.drivetrain.stop();
}

protected void interrupted() {
	Robot.drivetrain.stop();
}
}
