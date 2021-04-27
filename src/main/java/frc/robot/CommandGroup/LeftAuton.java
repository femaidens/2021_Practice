// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class LeftAuton extends CommandGroup {
  /** Add your docs here. */
  public LeftAuton() {
    double distHorBay = 50.0;
    double distVertBay = 10.0;
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
    addSequential(new DriveStraightDistance(distHorBay)); //random distance to the bay
    addSequential(new TurnDegrees(90.0));
    addParallel(new UpLift());
    addSequential(new DriveStraightDistance(distVertBay)); //random distance to get closer to the bay
    addSequential(new MoveCargo());
    addSequential(new MoveCargo());
    addParallel(new DownLift());
    addSequential(new TurnDegrees(180.0));
    addSequential(new DriveStraightDistance(2*distVertBay));
    addSequential(new TurnDegrees(-90.0));
    addSequential(new DriveStraightDistance(distHorBay));
  }
}
