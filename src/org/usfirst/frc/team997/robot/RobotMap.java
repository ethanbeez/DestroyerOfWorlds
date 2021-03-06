package org.usfirst.frc.team997.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static class Ports{
		public static final int
		rakeMotorUDPort = 0, rakeMotorLRPort = 1, driveTrainMotorLeft = 2, driveTrainMotorRight = 3, leftEncoderOne = 4, leftEncoderTwo = 5, rightEncoderOne = 6, rightEncoderTwo = 7; 
		// Making ports for our motors and encoders
		
}

public static class Values {
	
	public static final double
	driveP = 0, driveI = 0, driveD = 0;
	
}
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
