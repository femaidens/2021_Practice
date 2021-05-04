// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.*;

public class LeftAuton extends CommandGroup {
  /** Add your docs here. */
  public LeftAuton() {

    int toBay = 15; // from start position
    int closerToBay = 1;

    addParallel(new DriveStraightDistance(toBay));
    addSequential(new LiftUp());
    addParallel(new TurnDegrees(90));
    addSequential(new ExtendCargo());
    addSequential(new DriveStraightDistance(closerToBay));
    addSequential(new AutoAlign(0.1));
    addSequential(new OuttakeCargo());
    addSequential(new DriveStraightDistance(-closerToBay - 2)); 
    addSequential(new TurnDegrees(90));
    addParallel(new DriveStraightDistance(toBay));
    addSequential(new LiftDown());
    addSequential(new IntakeCargo());
    
  }
}
