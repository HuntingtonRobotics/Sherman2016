package org.usfirst.frc.team5016.robot.subsystems;

import org.usfirst.frc.team5016.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	public CANTalon rightTalon1, rightTalon2, leftTalon1, leftTalon2;
	
    public void initDefaultCommand() {
    	rightTalon1 = new CANTalon(2);
		rightTalon2 = new CANTalon(6);
		leftTalon1 = new CANTalon(4);
		leftTalon2 = new CANTalon(5);
		
    	setDefaultCommand(new TankDrive());
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
    	rightTalon1.set(rightSpeed);
		rightTalon2.set(rightSpeed);
		leftTalon1.set(-leftSpeed);
		leftTalon2.set(-leftSpeed);
    }
    
}

