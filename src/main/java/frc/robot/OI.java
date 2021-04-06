// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */
public class OI {
	public static Joystick driveJoy = new Joystick(RobotMap.driveP);
    public static Joystick operJoy = new Joystick(RobotMap.operP);

    //Cargo
    public static JoystickButton operTriggerLeft = new JoystickButton(operJoy, 4); // whileHeld
    public static JoystickButton operTriggerRight = new JoystickButton(operJoy, 5);

    operTriggerLeft.whileHeld(new Robot.Commands.cargoIntake());
    operTriggerRight.whileHeld(new Robot.Commands.cargoOuttake());

    public static JoystickButton operY = new JoystickButton(operJoy, 3); //whenPressed
    public static JoystickButton operX = new JoystickButton(operJoy, 2);

    operY.whenPressed(new Robot.Commands.cargoExtend());
    operX.whenPressed(new Robot.Commands.cargoRetract());

    //Hatch
    public static JoystickButton driverY = new JoystickButton(driveJoy, 3); //whenPressed
    public static JoystickButton driverX = new JoystickButton(driveJoy, 2);
    public static JoystickButton driverA = new JoystickButton(driveJoy, 0);
    public static JoystickButton driverB = new JoystickButton(driveJoy, 1);

    driveY.whenPressed(new Robot.Commands.hatchIntake());
    driveX.whenPressed(new Robot.Commands.hatchOuttake());

    driveY.whenPressed(new Robot.Commands.hatchExtend());
    driveX.whenPressed(new Robot.Commands.hatchRetract());
}
