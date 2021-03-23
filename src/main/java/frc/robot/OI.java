package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.AutoLiftLevel;
import frc.robot.Commands.SwitchLevelNum;


public class OI {

    public static Joystick driveJoy = new Joystick(0);
    public static Joystick operJoy = new Joystick(1);

    public static Button switchLiftLevelNum = new JoystickButton(operJoy, 1);
    public static Button activateAutoLift = new JoystickButton(operJoy, 2);


    public static void bindButtons(){
        switchLiftLevelNum.whenPressed(new SwitchLevelNum());
        activateAutoLift.whenPressed(new AutoLiftLevel());
    }
        

}
