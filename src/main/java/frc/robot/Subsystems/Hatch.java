// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/** Add your docs here. */
public class Hatch extends Subsystem {
  //two pistons have two buttons one button for each and just toggle each button to extend and retract this can be for operator
  public DoubleSolenoid hatchPiston1 = new DoubleSolenoid(RobotMap.pistonPort3, RobotMap.pistonPort4);
  public DoubleSolenoid hatchPiston2 = new DoubleSolenoid(RobotMap.pistonPort5, RobotMap.pistonPort6);

  public void hatchExtend(DoubleSolenoid piston){
    piston.set(DoubleSolenoid.Value.kForward);
  }

  public void hatchRetract(DoubleSolenoid piston){
    piston.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  protected void initDefaultCommand() {

  }
}
