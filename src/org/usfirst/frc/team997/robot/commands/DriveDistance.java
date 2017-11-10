package org.usfirst.frc.team997.robot.commands;

import org.usfirst.frc.team997.robot.Robot;
import org.usfirst.frc.team997.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command implements PIDOutput {

	private double pidRate;
	public PIDController controller;
	public double setPoint;
	
	
    public DriveDistance(double distance) {
    
    	this(distance, new PIDSource(Robot.driveTrain.leftEncoder));
    	// Wrapper constructor for the constructor below, allows us to extend capabilities. 
    	// Basically, this allows us to use the distance and the PID outputs below to simplify things.
    	//PIDSource is the actual value from the robot that PID uses as its source of info.
    	
        // Use requires() here to declare subsystem dependencies
    	// eg. requires(chassis);
    }
    public DriveDistance(double distance, PIDSource source) {
    	
    	requires(Robot.driveTrain);
    	setPoint = distance;
    	
    	controller = new PIDController(RobotMap.Values.driveP, RobotMap.Values.driveI, RobotMap.Values.driveD, source, this);
    	controller.setOutputRange(1, 2);
    	controller.setAbsoluteTolerance(0.5);
    	// How sensitive it is
    	
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	controller.setSetpoint(setPoint);
    	controller.enable();
    	//Enabling PID controller
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.driveTrain.driveVoltage(pidRate, pidRate);
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return controller.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    
    	controller.disable();
    	// Disabling PID controller
    	Robot.driveTrain.driveVoltage(0, 0);
    	//Setting voltage to 0 when we're done
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    	
    }
    
    public void pidWrite(double output) {
    	
    	pidRate = output;
    	// Output calculated from PID controller, really long scary equation thingy.
    	// Set that equal to pidRate, which is used as a parameter.
    }
    
}
