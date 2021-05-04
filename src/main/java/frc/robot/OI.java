// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.CommandGroup.AutoClimb;
import frc.robot.Commands.*;

/** Add your docs here. */
public class OI {
    public static Joystick driveJoy = new Joystick(RobotMap.drivePort);
    public static Joystick operJoy = new Joystick(RobotMap.operPort);
    public static Button upLiftButton = new JoystickButton(operJoy, 3);
    public static Button downLiftButton = new JoystickButton(operJoy, 0);
    public static Button intakeButton = new JoystickButton(operJoy, 1);
    public static Button outtakeButton = new JoystickButton(operJoy, 2);
    public static Button moveCargoButton = new JoystickButton(driveJoy, 0);
    public static Button moveHatchButton = new JoystickButton(driveJoy, 2);
    public static Button getPieceButton = new JoystickButton(driveJoy, 3);
    public static Button climbButton = new JoystickButton(driveJoy, 1);
    public static Button alignButton = new JoystickButton(driveJoy, 5);
    
    public void bindButtons(){
        upLiftButton.whenPressed(new UpLift());
        downLiftButton.whenPressed(new DownLift());
        intakeButton.whileHeld(new Intake());
        outtakeButton.whileHeld(new Outtake());
        moveCargoButton.whenPressed(new MoveCargo());
        moveHatchButton.whenPressed(new MoveHatch());
        getPieceButton.whenPressed(new GetPiece());
        climbButton.whenPressed(new AutoClimb());
        alignButton.whenPressed(new AlignRobot_PID(0.5)); //random speed

    }
}
