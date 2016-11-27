package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.OI;
import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	static Joystick driverController, operatorController;
	static DriveTrain driveTrain;
	static OI oi;
	
    public TankDrive() {
        requires(Robot.driveTrain);
        
        driverController = OI.driverController;
        operatorController = OI.operatorController;
        
        driveTrain = Robot.driveTrain;
        oi = Robot.oi;
    }

    protected void initialize() {}

    protected void execute() {
    	if (driverController.getIsXbox())
    		if (driverController.getPOV() == -1) {
    			driveTrain.drive((oi.getDriverControllerLeftStick() < 0 ? -1 : 1)*Math.pow(oi.getDriverControllerLeftStick(), 2.0), (oi.getDriverControllerRightStick() < 0 ? -1 : 1)*Math.pow(oi.getDriverControllerRightStick(), 2));
    			//driveTrain.drive((oi.getDriverControllerLeftStick() < 1 ? -1 : 1)*Math.abs(oi.getDriverControllerLeftStick()), (oi.getDriverControllerRightStick() < 1 ? -1 : 1)*Math.abs(oi.getDriverControllerRightStick()));
    		} else if (driverController.getPOV() == 0) {
    			driveTrain.drive(oi.getDriverControllerRightTrigger(), oi.getDriverControllerRightTrigger());
    		} else if (driverController.getPOV() == 180) {
    			driveTrain.drive(-oi.getDriverControllerRightTrigger(), -oi.getDriverControllerRightTrigger());
    		} else if (driverController.getPOV() == 90) {
    			driveTrain.drive(oi.getDriverControllerRightTrigger(), -oi.getDriverControllerRightTrigger());
    		} else if (driverController.getPOV() == 270) {
    			driveTrain.drive(-oi.getDriverControllerRightTrigger(), oi.getDriverControllerRightTrigger());
    		}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.drive(0.0, 0.0);
    }

    protected void interrupted() {
    	end();
    }
}
