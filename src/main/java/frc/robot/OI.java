// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.*;


/** Add your docs here. */
public class OI {
	public static Joystick driveJoy = new Joystick(0);
    public static Joystick operJoy = new Joystick(1);

    //Cargo
    public static Button operTriggerLeft = new JoystickButton(operJoy, 4); //whileHeld
    public static Button operTriggerRight = new JoystickButton(operJoy, 5);
    public static Button operY = new JoystickButton(operJoy, 3); //whenPressed
    public static Button operX = new JoystickButton(operJoy, 2);

    //Hatch
    public static Button driverY = new JoystickButton(driveJoy, 3); //whenPressed
    public static Button driverX = new JoystickButton(driveJoy, 2);
    public static Button driverA = new JoystickButton(driveJoy, 0);
    public static Button driverB = new JoystickButton(driveJoy, 1);

    // Climb
    public static Button operUp = new JoystickButton(operJoy, 12); //whenPressed
    public static Button operDown = new JoystickButton(operJoy, 15);
    public static Button operLeft = new JoystickButton(operJoy, 13);
    public static Button operRight = new JoystickButton(operJoy, 14);



    public void bindButtons(){

        operTriggerLeft.whileHeld(new cargoIntake());
        operTriggerRight.whileHeld(new cargoOuttake());

        operY.whenPressed(new cargoExtend());
        operX.whenPressed(new cargoRetract());

        driverY.whenPressed(new hatchIntake());
        driverX.whenPressed(new hatchOuttake());
    
        driverA.whenPressed(new hatchExtend());
        driverB.whenPressed(new hatchRetract());
        
        operUp.whenPressed(new climbUpFront());
        operLeft.whenPressed(new climbUpBack());

        operDown.whenPressed(new climbDownFront());
        operRight.whenPressed(new climbDownBack());

    }
    
}
