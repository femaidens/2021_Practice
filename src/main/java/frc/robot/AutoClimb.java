// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class AutoClimb extends CommandGroup {
  /** Add your docs here. */
  public AutoClimb() {
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

    //used tentative distances
    addSequential(new FrontUp()); //the front goes up
    addSequential(new DriveStraightDistance(5.0)); //drives towards platform a bit
    addSequential(new BackUp()); //the back goes up
    addSequential(new FrontDown()); //the front goes down
    addSequential(new DriveStraightDistance(5.0)); //drives onto platform a bit
    addSequential(new BackDown()); //back goes down
    addSequential(new DriveStraightDistance(5.0)); //drives completely on platform
  }
}
