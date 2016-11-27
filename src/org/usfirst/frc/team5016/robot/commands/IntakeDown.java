package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeDown extends Command {

	public static Intake intake;
	
    public IntakeDown() {
    	requires(Robot.intake);
    	
    	intake = Robot.intake;
    }

    protected void initialize() {}

    protected void execute() {
    	intake.setIntakeDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	intake.setIntakeOff();
    }

    protected void interrupted() {
    	end();
    }
    
}
