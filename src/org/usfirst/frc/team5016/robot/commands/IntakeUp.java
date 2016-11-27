package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeUp extends Command {

	public static Intake intake;
	
    public IntakeUp() {
        requires(Robot.intake);
        
        intake = Robot.intake;
    }

    protected void initialize() {}

    protected void execute() {
    	intake.setIntakeUp();
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
