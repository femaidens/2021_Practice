package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.AutoLiftLevel;
import frc.robot.Commands.SwitchLevelNum;
import frc.robot.Commands.IntakeCargo;
import frc.robot.Commands.OuttakeCargo;
import frc.robot.Commands.ControlCargoPiston;
import frc.robot.Commands.ControlHatchPerimeterPiston;
import frc.robot.Commands.ControlHatchInOutPiston;

public class OI {

    public static Joystick driveJoy = new Joystick(0);
    public static Joystick operJoy = new Joystick(1);

    //lift buttons
    public static Button switchLiftLevelNum = new JoystickButton(operJoy, 1);
    public static Button activateAutoLift = new JoystickButton(operJoy, 2);
    //cargo buttons
    public static Button intakeCargo = new JoystickButton(driveJoy, 1);
    public static Button outtakeCargo = new JoystickButton(driveJoy, 2);
    public static Button toggleCargoPist = new JoystickButton(driveJoy, 3);
    //hatch buttons
    public static Button toggleHatchPerimPist = new JoystickButton(operJoy, 3);
    public static Button toggleHatchInOutPist = new JoystickButton(operJoy, 4);



    public static void bindButtons(){
        //Lift
        switchLiftLevelNum.whenPressed(new SwitchLevelNum());
        activateAutoLift.whenPressed(new AutoLiftLevel());
        //Cargo
        intakeCargo.whileHeld(new IntakeCargo());
        outtakeCargo.whileHeld(new OuttakeCargo());
        toggleCargoPist.toggleWhenPressed(new ControlCargoPiston());
        //Hatch
        toggleHatchPerimPist.toggleWhenPressed(new ControlHatchPerimeterPiston());
        toggleHatchInOutPist.toggleWhenPressed(new ControlHatchInOutPiston());

    }
        

}
