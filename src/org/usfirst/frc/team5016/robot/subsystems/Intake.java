package org.usfirst.frc.team5016.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	public static CANTalon intakeTalon;
	public static DoubleSolenoid intakeSolenoid;
	
    public void initDefaultCommand() {
    	intakeTalon = new CANTalon(1);
    	intakeSolenoid = new DoubleSolenoid(1, 0);
    	
    	setDefaultCommand(null);
    }
    
    public static void setIntakeMotor(double intakeSpeed) {
    	intakeTalon.set(intakeSpeed);
    }
    
    public static void setIntakeUp() {
    	intakeSolenoid.set(Value.kForward);
    }
    
    public static void setIntakeDown() {
    	intakeSolenoid.set(Value.kReverse);
    }
    
    public static void setIntakeOff() {
    	intakeSolenoid.set(Value.kOff);
    }
    
}

