package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class RobotMap {

    public static int joyPort = 0;

    //drivetrain motors
	public static int frontRightPort=1;
    public static int frontLeftPort=2;
    public static int midRightPort=3;
	public static int midLeftPort=4;
	public static int rearRightPort=5;
	public static int rearLeftPort=6;

    public static int gyroPort = 10;

    //lift motors
	public static int liftRightOnePort=11;
	public static int liftRightTwoPort=12;
	public static int liftLeftOnePort=13;
    public static int liftLeftTwoPort=14;
    
    //lift limit switches
	public static int topLimitSwitchRightPort=15;
	public static int topLimitSwitchLeftPort=16;
	public static int botLimitSwitchRightPort=17;
	public static int botLimitSwitchLeftPort=18;
}
