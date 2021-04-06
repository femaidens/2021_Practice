// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/** Add your docs here. */
public class Cargo extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  TalonSRX cargoRight = new TalonSRX(RobotMap.cargoRightPort);
  TalonSRX cargoLeft = new TalonSRX(RobotMap.cargoLeftPort);

  DoubleSolenoid cargoSolenoid = new DoubleSolenoid(RobotMap.cargoForwardPort, RobotMap.cargoReversePort);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void intake(){
    cargoRight.set(ControlMode.PercentOutput, 0.8);
    cargoLeft.set(ControlMode.PercentOutput, -0.8);
  }

  public void outtake(){
    cargoRight.set(ControlMode.PercentOutput, -0.8);
    cargoLeft.set(ControlMode.PercentOutput, 0.8);
  }

  public void stop(){
    cargoRight.set(ControlMode.PercentOutput, 0.0);
    cargoLeft.set(ControlMode.PercentOutput, 0.0);
  }

  public void moveCargo(){
    if(cargoSolenoid.get() == DoubleSolenoid.Value.kOff || cargoSolenoid.get() == DoubleSolenoid.Value.kReverse){
      cargoSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
      cargoSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  /*public void extend(){
    cargoSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retract(){
    cargoSolenoid.set(DoubleSolenoid.Value.kReverse);
  }*/
}
