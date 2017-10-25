package org.usfirst.frc.team997.robot.subsystems;

import org.usfirst.frc.team997.robot.RobotMap;
import org.usfirst.frc.team997.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	public VictorSP leftMotor;
	public VictorSP rightMotor;
	
	public DriveTrain() {
	
		leftMotor = new VictorSP(RobotMap.Ports.driveTrainMotorLeft);
		rightMotor = new VictorSP(RobotMap.Ports.driveTrainMotorRight);
		
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

