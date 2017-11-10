package org.usfirst.frc.team997.robot.subsystems;

import org.usfirst.frc.team997.robot.RobotMap;
import org.usfirst.frc.team997.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	public VictorSP leftMotor;
	public VictorSP rightMotor;
	public Encoder leftEncoder;
	public Encoder rightEncoder;
	
	public DriveTrain() {
		
		final double gearRatio = 4/3;
		final double ticksPerRev = 2048;
		final double radius = 1.5;
		final double magic = 1/.737;
		final double calculated = (radius * 2 * Math.PI) * gearRatio * magic / ticksPerRev;
		// The values that determine the distance per pulse/tick for the encoders.
				
	
		leftMotor = new VictorSP(RobotMap.Ports.driveTrainMotorLeft);
		rightMotor = new VictorSP(RobotMap.Ports.driveTrainMotorRight);
		leftEncoder = new Encoder(RobotMap.Ports.leftEncoderOne, RobotMap.Ports.leftEncoderTwo);
		leftEncoder.setDistancePerPulse(calculated);
		leftEncoder.setPIDSourceType(PIDSourceType.kRate);
		rightEncoder = new Encoder(RobotMap.Ports.rightEncoderOne, RobotMap.Ports.rightEncoderTwo);
		rightEncoder.setDistancePerPulse(calculated);
		rightEncoder.setPIDSourceType(PIDSourceType.kRate);
		// All of this fun stuff (except for the left/right motors) is determining the 
		// distance the robot travels. 
		
		
	}
	
	public void driveVoltage (double leftVoltage, double rightVoltage) {
		
		leftMotor.set(leftVoltage);
		rightMotor.set(rightVoltage);
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	new TankDrive();
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

