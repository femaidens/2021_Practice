// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class MiddleAuton extends CommandGroup {
  /** Add your docs here. */
  public MiddleAuton() {

    int toBay = 5; // from start position
    int hatchLength = 1;
    int toCargo = 10; // to cargo next to HAB

    addParallel(new DriveStraightDistance(toBay));
    addSequential(new AutoAlign(0.1));
    addSequential(new ExtendHatch());
    addSequential(new ExtendIntake());
    addSequential(new RetractIntake());
    addSequential(new RetractHatch());
    addSequential(new DriveStraightDistance(-hatchLength)); // backing up
    addSequential(new TurnDegrees(135));
    addSequential(new DriveStraightDistance(toCargo));
    addSequential(new TurnDegrees(45));
    addSequential(new IntakeCargo());
    
  }
}
