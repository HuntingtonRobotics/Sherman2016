package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.subsystems.Intake;
import org.usfirst.frc.team5016.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	public static Shooter shooter;
	public static Intake intake;
	static boolean runOnce;
	public static Timer timer;
	
    public Shoot() {
    	requires(Robot.shooter);
    	requires(Robot.intake);
    	
    	shooter = Robot.shooter;
    	intake = Robot.intake;
    	runOnce = false;
    	timer = new Timer();
    }

    protected void initialize() {
    	timer.start();
    	runOnce = false;
    }

    protected void execute() {
    	if (timer.get() <= 1.5) {
	    	intake.setIntakeMotor(-1.0);
	    	shooter.setShooterMotor(1.0);
    	} else if (timer.get() > 1.5 && timer.get() < 3.0) {
	    	shooter.setShooterPushForward();
	    	intake.setIntakeMotor(-1.0);
	    	shooter.setShooterMotor(1.0);
    	} else {
    		runOnce = true;
    	}
    }

    protected boolean isFinished() {
        return runOnce;
    }

    protected void end() {
    	intake.setIntakeMotor(0.0);
    	shooter.setShooterMotor(0.0);
    	shooter.setShooterPushReverse();
    }

    protected void interrupted() {
    	end();
    }
    
}
