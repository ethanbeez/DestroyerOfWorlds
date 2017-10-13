package org.usfirst.frc.team997.robot.subsystems;

import org.usfirst.frc.team997.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class KillerRake extends Subsystem {
	
	public double rakeSpeed = 1;
	
	public VictorSP rakeMotorUD;
	
	public VictorSP rakeMotorLR;

public KillerRake() {
	
	rakeMotorUD = new VictorSP(RobotMap.Ports.rakeMotorUDPort);
	rakeMotorLR = new VictorSP(RobotMap.Ports.rakeMotorLRPort);
	
}
public void rakeVoltage(double UDV, double LRV) {
	
	rakeMotorUD.set(UDV*rakeSpeed);
	rakeMotorLR.set(LRV*rakeSpeed);
	
}



    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

