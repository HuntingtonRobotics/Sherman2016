package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5016.robot.subsystems.Intake;
import org.usfirst.frc.team5016.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StraightAuto extends Command {

	public static DriveTrain driveTrain;
	public static Intake intake;
	public static Shooter shooter;
	public static boolean runOnce;
	
    public StraightAuto() {
    	requires(Robot.driveTrain);
    	requires(Robot.intake);
    	requires(Robot.shooter);
    	
    	driveTrain = Robot.driveTrain;
    	intake = Robot.intake;
    	shooter = Robot.shooter;
    	
    	runOnce = false;
    }

    protected void initialize() {
    	runOnce = false;
    }

    protected void execute() {
    	for (int i=0; i<300; i++) {
    		driveTrain.drive(0.25, 0.25);
    		intake.setIntakeUp();
    		shooter.setShooterUp();
    	}
    	for (int i=0; i<(double)SmartDashboard.getNumber("AutoLoops"); i++) {
    		driveTrain.drive(0.55, 0.55);
    		intake.setIntakeUp();
    		shooter.setShooterUp();
    	}
    	runOnce = true;
    }

    protected boolean isFinished() {
        return runOnce;
    }

    protected void end() {
    	driveTrain.drive(0.0, 0.0);
    }

    protected void interrupted() {
    	end();
    }
}
