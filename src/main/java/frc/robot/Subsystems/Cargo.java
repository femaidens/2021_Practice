// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/** Add your docs here. */
public class Cargo extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX rightCargo = new TalonSRX(RobotMap.rightCargoPort);
  public TalonSRX leftCargo = new TalonSRX(RobotMap.leftCargoPort);

  public DoubleSolenoid cargoPiston = new DoubleSolenoid(RobotMap.cargoPistonPort1, RobotMap.cargoPistonPort2);

  public void intake() {
    leftCargo.set(ControlMode.PercentOutput, 0.8);
    rightCargo.set(ControlMode.PercentOutput, -0.8);
  }

  public void outtake() {
    leftCargo.set(ControlMode.PercentOutput, -0.8);
    rightCargo.set(ControlMode.PercentOutput, 0.8);
  }

  public void extend() {
    cargoPiston.set(DoubleSolenoid.Value.kForward);
  }

  public void retract() {
    cargoPiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void stop() {
    rightCargo.set(ControlMode.PercentOutput, 0.0); //change PercentOutput
    leftCargo.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
