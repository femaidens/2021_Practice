// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Commands.*;

public class LeftAuton extends CommandGroup {
  public double d = 25; //distance from habitat to cargo ship slot
  public double c = 5; //small distance for going in and out of slots/backing up
  public LeftAuton() {
    //drive forward distance d and turn right 90 degrees
    addSequential(new DriveStraight(d));
    addSequential(new TurnDegrees(90));
    // drive forward distance c + change lift to level 2 and put cargo in the ship
    addSequential(new DriveStraight(c));
    Robot.lift.destLvl = 2;
    addSequential(new AutoLiftLevel());
    addSequential(new OuttakeCargo());
    //turn around, drive distance 2c and turn left 90 degrees
    addSequential(new TurnDegrees(180));
    addSequential(new DriveStraight(2*c));
    addSequential(new TurnDegrees(-90));
    //drive forward distance d so bot is in position for a hatch when auton is done, set lift level back to 1
    addSequential(new DriveStraight(d));
    Robot.lift.destLvl = 1;
    addSequential(new AutoLiftLevel());

  }
}
