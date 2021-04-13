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
    public static Button extendCargo = new JoystickButton(operJoy, 3);
    public static Button retractCargo = new JoystickButton(operJoy, 3); 
    public static Button intake = new JoystickButton(driverJoy, 1);
    public static Button outtake = new JoystickButton(driverJoy, 2);
    public static Button extendHatch = new JoystickButton(operJoy, 4);
    public static Button retractHatch = new JoystickButton(operJoy, 4);
    public static Button extendIntake = new JoystickButton(operJoy, 5);
    public static Button retractIntake = new JoystickButton(operJoy, 5);
    public static Button climbAuto = new JoystickButton(driverJoy, 3);

    public OI() {

    }

    public static void bindButtons() {
        //lift
        liftUp.whenPressed(new LiftUp());
        liftDown.whenPressed(new LiftDown());

        //cargo
        extendCargo.toggleWhenPressed(new ExtendCargo()); //extends when pressed, retracts when pressed
        retractCargo.toggleWhenPressed(new RetractCargo());
        intake.whileHeld(new IntakeCargo());
        outtake.whileHeld(new OuttakeCargo());

        //hatch
        extendHatch.toggleWhenPressed(new ExtendHatch());
        retractHatch.toggleWhenPressed(new RetractHatch());
        extendIntake.toggleWhenPressed(new ExtendIntake());
        retractIntake.toggleWhenPressed(new RetractIntake());

        //climb
        climbAuto.whenPressed(new ClimbAuto());
    }
}
