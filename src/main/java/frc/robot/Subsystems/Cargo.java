// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Cargo extends Subsystem {

  public static Talon leftTalon = new Talon(RobotMap.cargoLeftPort);
  public static Talon rightTalon = new Talon(RobotMap.cargoRightPort);

  public static DoubleSolenoid cargoSol = new DoubleSolenoid(RobotMap.cargoPistonPort1, RobotMap.cargoPistonPort2);

  public static void retract(){
    cargoSol.set(DoubleSolenoid.Value.kReverse);
  }

  public static void extend(){
    cargoSol.set(DoubleSolenoid.Value.kReverse);
  }

  public static DoubleSolenoid.Value getPosition(){
    return cargoSol.get();
  }

  public static void intakeCargo(){
    leftTalon.set(1.0);
    rightTalon.set(-1.0);
  }

  public static void outtakeCargo(){
    leftTalon.set(-1.0);
    rightTalon.set(1.0);
  }

  public static void stopMotors(){
    leftTalon.set(0.0);
    rightTalon.set(0.0);
  }

  public static void stopPiston(){
    cargoSol.set(DoubleSolenoid.Value.kOff);
  }



  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
