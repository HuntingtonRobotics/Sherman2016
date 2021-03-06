package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command {

	public static Joystick driverController, operatorController;
	public static Intake intake;
	
    public IntakeOut() {
    	requires(Robot.intake);
    	
    	driverController = Robot.oi.driverController;
    	operatorController = Robot.oi.operatorController;
    	intake = Robot.intake;
    }

    protected void initialize() {}

    protected void execute() {
    	intake.setIntakeMotor(-1.0);
    	
    	//Rumble
    	driverController.setRumble(RumbleType.kLeftRumble, (float) 1.0);
    	driverController.setRumble(RumbleType.kRightRumble, (float) 1.0);
    	operatorController.setRumble(RumbleType.kLeftRumble, (float) 1.0);
    	operatorController.setRumble(RumbleType.kRightRumble, (float) 1.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	intake.setIntakeMotor(0.0);
    	
    	//Stop rumbling
    	driverController.setRumble(RumbleType.kLeftRumble, (float) 0.0);
    	driverController.setRumble(RumbleType.kRightRumble, (float) 0.0);
    	operatorController.setRumble(RumbleType.kLeftRumble, (float) 0.0);
    	operatorController.setRumble(RumbleType.kRightRumble, (float) 0.0);
    }

    protected void interrupted() {
    	end();
    }
}
