// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/** Add your docs here. */
public class Hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid hatch1Solenoid = new DoubleSolenoid(RobotMap.hatch1ForwardPort, RobotMap.hatch1ReversePort);
  DoubleSolenoid hatch2Solenoid = new DoubleSolenoid(RobotMap.hatch2ForwardPort, RobotMap.hatch2ReversePort);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void moveHatch(){
    if(hatch1Solenoid.get() == DoubleSolenoid.Value.kOff || hatch1Solenoid.get() == DoubleSolenoid.Value.kReverse){
      hatch1Solenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
      hatch1Solenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public void movePiece(){
    if(hatch2Solenoid.get() == DoubleSolenoid.Value.kOff || hatch2Solenoid.get() == DoubleSolenoid.Value.kReverse){
      hatch2Solenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
      hatch2Solenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }
}
