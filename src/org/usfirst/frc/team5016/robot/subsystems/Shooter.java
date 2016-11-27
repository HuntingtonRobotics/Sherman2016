package org.usfirst.frc.team5016.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
    
	public static CANTalon shooterTalon1, shooterTalon2;
	public static DoubleSolenoid shooterUpDownSolenoid;
	public static Solenoid shooterPushSolenoid;
	
    public void initDefaultCommand() {
        shooterTalon1 = new CANTalon(0);
        shooterTalon2 = new CANTalon(3);
        shooterUpDownSolenoid = new DoubleSolenoid(2, 3);
        shooterPushSolenoid = new Solenoid(7);
    	
    	setDefaultCommand(null);
    }
    
    public static void setShooterMotor(double speed) {
    	shooterTalon1.set(speed);
    	shooterTalon2.set(-speed);
    }
    
    public static void setShooterUp() {
    	shooterUpDownSolenoid.set(Value.kReverse);
    }
    
    public static void setShooterDown() {
    	shooterUpDownSolenoid.set(Value.kForward);
    }
    
    public static void setShooterOff() {
    	shooterUpDownSolenoid.set(Value.kOff);
    }
    
    public static void setShooterPushForward() {
    	shooterPushSolenoid.set(true);
    }
    
    public static void setShooterPushReverse() {
    	shooterPushSolenoid.set(false);
    }
    
}

