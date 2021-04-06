// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Cargo extends Subsystem {
//2 motors facing opposite directions ahnd 1 piston
public TalonSRX inMotor = new TalonSRX(RobotMap.cargoInPort);
public TalonSRX outMotor = new TalonSRX(RobotMap.cargoOutPort);
public DoubleSolenoid cargoPiston = new DoubleSolenoid(RobotMap.pistonPort1, RobotMap.pistonPort2);


public void cargoExtend(){
  cargoPiston.set(DoubleSolenoid.Value.kForward);
}

public void cargoRetract(){
  cargoPiston.set(DoubleSolenoid.Value.kReverse);
}

public void cargoIntake(){
  inMotor.set(ControlMode.PercentOutput, 0.8);
  outMotor.set(ControlMode.PercentOutput, -0.8);
}

public void cargoOuttake(){
  inMotor.set(ControlMode.PercentOutput, -0.8);
  outMotor.set(ControlMode.PercentOutput, 0.8);
}
public void stop(){
  inMotor.set(ControlMode.PercentOutput, 0);
  outMotor.set(ControlMode.PercentOutput, 0);
}

@Override
protected void initDefaultCommand() {
  // TODO Auto-generated method stub

}

}
