// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Commands.*;

public class MiddleAuton extends CommandGroup {
  public double a = 8; // distance from middle space to front of cargo ship
  public double z = 20;// diagonal distance from front of cargo ship to cargo balls location next to habitat
  public double c = 5; //small distance for going in and out of slots/backing up
  public MiddleAuton() {
    //Drive across to cargo ship
    addSequential(new DriveStraight(a));
    //place hatch where you put your cargo (front hole)
    /*Robot.lift.destLvl = 2;
    addSequential(new AutoLiftLevel()); */
    addSequential(new ControlHatchInOutPiston());
    //Back up length of hatch mechanism (c)
    addSequential(new ControlHatchInOutPiston());// just retracting hatch piston
    addSequential(new TurnDegrees(180));
    addSequential(new DriveStraight(c));
    //Turn 45 degrees left and drive forward to cargo pile
    addSequential(new TurnDegrees(-45));
    addSequential(new DriveStraight(z));
    //Turn 45 degrees right so you are parallel to drive station walls
    addSequential(new TurnDegrees(45));
    //Intake cargo 
    /*Robot.lift.destLvl = 1;
    addSequential(new AutoLiftLevel());*/
    addSequential(new IntakeCargo());
    
  }
}
