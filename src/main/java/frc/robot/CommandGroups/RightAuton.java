// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class RightAuton extends CommandGroup {
  /** Add your docs here. */
  public RightAuton() {

    int toBay = 15; // from start position
    int closerToBay = 1;

    addParallel(new DriveStraightDistance(toBay));
    addSequential(new LiftUp());
    addParallel(new TurnDegrees(-90));
    addSequential(new ExtendCargo());
    addSequential(new DriveStraightDistance(closerToBay));
    addSequential(new OuttakeCargo());
    addSequential(new DriveStraightDistance(-closerToBay - 2)); // move backwards a little
    addSequential(new TurnDegrees(-90));
    addParallel(new DriveStraightDistance(toBay));
    addSequential(new LiftDown());
    addSequential(new IntakeCargo());

  }
}
