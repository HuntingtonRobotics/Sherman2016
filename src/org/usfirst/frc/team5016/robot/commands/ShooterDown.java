package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterDown extends Command {

	public static Shooter shooter;
	
    public ShooterDown() {
    	requires(Robot.shooter);
    	
    	shooter = Robot.shooter;
    }

    protected void initialize() {}

    protected void execute() {
    	shooter.setShooterDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	shooter.setShooterOff();
    }

    protected void interrupted() {
    	end();
    }
}
