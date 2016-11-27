package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.RobotMap;
import org.usfirst.frc.team5016.robot.subsystems.Camera;
import org.usfirst.frc.team5016.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoAlign extends Command {

	public static DriveTrain driveTrain;
	public static Camera camera;
	
    public AutoAlign() {
    	requires(Robot.driveTrain);
    	requires(Robot.camera);
    	
    	driveTrain = Robot.driveTrain;
    	camera = Robot.camera;
    }

    protected void initialize() {}

    protected void execute() {
    	if (camera.robotX > RobotMap.xCalibrate) {
    		driveTrain.drive(0.2, -0.2);
    	} else if (camera.robotX < RobotMap.xCalibrate) {
    		driveTrain.drive(-0.2, 0.2);
    	}
    }

    protected boolean isFinished() {
    	return camera.robotX <= 0 || Math.abs(RobotMap.xCalibrate - camera.robotX) < 2;
    }

    protected void end() {
    	driveTrain.drive(0.0, 0.0);
    }

    protected void interrupted() {
    	end();
    }
}
