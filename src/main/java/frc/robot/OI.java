package frc.robot;

import frc.robot.Commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    public static Joystick driverJoy = new Joystick(RobotMap.driverJoyPort);
    public static Joystick operJoy = new Joystick(RobotMap.operJoyPort);
    public static Button liftUp = new JoystickButton(operJoy, 1);
    public static Button liftDown = new JoystickButton(operJoy, 2);

    public OI() {

    }

    public static void bindButtons() {
        liftUp.whenPressed(new LiftUp());
        liftDown.whenPressed(new LiftDown());
    }
}
