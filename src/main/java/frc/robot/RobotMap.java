package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

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

	//cargomotor ports
	public static int cargoInPort = 19;
	public static int cargoOutPort = 20;
	//piston ports
	//cargopiston
	public static int pistonPort1 = 21;
	public static int pistonPort2 = 22;
	//hatchpistons
	public static int pistonPort3 = 23;
	public static int pistonPort4 = 24;
	public static int pistonPort5 = 25;
	public static int pistonPort6 = 26;

	//climb pistons
	public static int climbPort1 = 27;
	public static int climbPort2 = 28;
	public static int climbPort3 = 29;
	public static int climbPort4 = 30;
	public static int climbPort5 = 31;
	public static int climbPort6 = 32;
	public static int climbPort7 = 33;
	public static int climbPort8 = 34;


	public static int climbSensorChannel1;
	public static int climbSensorChannel2;


}
