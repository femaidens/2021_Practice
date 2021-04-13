// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Climb extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid front1Climb = new DoubleSolenoid(RobotMap.front1ForwardPort, RobotMap.front1ReversePort);
  DoubleSolenoid front2Climb = new DoubleSolenoid(RobotMap.front2ForwardPort, RobotMap.front2ReversePort);
  DoubleSolenoid back1Climb = new DoubleSolenoid(RobotMap.back1ForwardPort, RobotMap.back1ReversePort);
  DoubleSolenoid back2Climb = new DoubleSolenoid(RobotMap.back2ForwardPort, RobotMap.back2ReversePort);

  Ultrasonic ultraClimb = new Ultrasonic(RobotMap.ultra1Port, RobotMap.ultra2Port);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void frontUp(){
    front1Climb.set(DoubleSolenoid.Value.kForward);
    front2Climb.set(DoubleSolenoid.Value.kForward);
  }

  public void frontDown(){
    front1Climb.set(DoubleSolenoid.Value.kReverse);
    front2Climb.set(DoubleSolenoid.Value.kReverse);
  }

  public void backUp(){
    back1Climb.set(DoubleSolenoid.Value.kForward);
    back2Climb.set(DoubleSolenoid.Value.kForward);
  }

  public void backDown(){
    back1Climb.set(DoubleSolenoid.Value.kReverse);
    back2Climb.set(DoubleSolenoid.Value.kReverse);
  }

  public void getDistance(){

  }

}
