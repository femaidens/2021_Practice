// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class midAuton extends CommandGroup {
  /** Add your docs here. */
  public midAuton() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
    
    addSequential(new driveStraightDistance(10));
    addSequential(new hatchExtend());
    addSequential(new driveStraightDistance(-10));
    addSequential(new turnDegrees(-45));
    addSequential(new driveStraightDistance(10));
    addSequential(new turnDegrees(10));
    addSequential(new cargoIntake());

    
  }
}
