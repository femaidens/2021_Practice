// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Commands.*;

public class ClimbPlatform extends CommandGroup {
  /** Add your docs here. */
  public ClimbPlatform() {
  //lift up front of robot
   addSequential(new ExtendClimbFront());
   //drive towards platform until touching *** this code assumes u press the buttonw when in front of platform
   addSequential(new DriveStraight(Robot.climb.distSensor.getRangeInches()));
   //bring back of robot up as well
   addSequential(new ExtendClimbBack());
   //let front edge of robot rest on platform
   addSequential(new RetractClimbFront());
   //Making the front half of the robot drive onto the platform while the back is held up by pistons, im making a guess
   //and putting 3 for the distance to travel straight
   addSequential(new DriveStraight(3));
   addSequential(new RetractClimbBack());
   //once back is retracted robot can drive the rest of the way onto platform, once again im just using 3
   addSequential(new DriveStraight(3));
  }
}
