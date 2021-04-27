// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Commands.*;

public class RightAuton extends CommandGroup {
  public double d = 25; //distance from habitat to cargo ship slot
  public double c = 5; //small distance for going in and out of slots/backing up

  public RightAuton() {
    //Drive forward and turn 90 degrees left, drive toward the ship, raise lift to level2,
    addSequential(new DriveStraight(d));
    addSequential(new TurnDegrees(-90));
    addSequential(new DriveStraight(c));
    Robot.lift.destLvl = 2;
    addSequential(new AutoLiftLevel());
    //Drop a cargo
    addSequential(new OuttakeCargo());
    //Drive backwards a certain distance
    addSequential(new TurnDegrees(180));
    addSequential(new DriveStraight(c));
    //Turn 90 degrees right, drive forward toward cargo
    addSequential(new TurnDegrees(90));
    addSequential(new DriveStraight(d));
    //lower lift to level 1 as you drive and intake cargo  
    Robot.lift.destLvl = 1;
    addSequential(new AutoLiftLevel());
    addSequential(new IntakeCargo());

  }
}
