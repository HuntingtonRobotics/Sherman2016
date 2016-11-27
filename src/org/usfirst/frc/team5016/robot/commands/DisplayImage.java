package org.usfirst.frc.team5016.robot.commands;

import org.usfirst.frc.team5016.robot.Robot;
import org.usfirst.frc.team5016.robot.subsystems.Camera;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class DisplayImage extends Command {

	public static Camera camera;
	public static NetworkTable table;
	
    public DisplayImage() {
        requires(Robot.camera);
        
        camera = Robot.camera;
        table = NetworkTable.getTable("SmartDashboard");
    }

    protected void initialize() {}

    protected void execute() {
    	try {
    		camera.robotX = table.getNumber("X", -1);
        	camera.robotY = table.getNumber("Y", -1);
        	
    		NIVision.IMAQdxStartAcquisition(camera.session);
    		NIVision.IMAQdxGrab(camera.session, camera.frame, 1);
    		NIVision.imaqDrawShapeOnImage(camera.frame, camera.frame, camera.rect, DrawMode.DRAW_INVERT, ShapeMode.SHAPE_RECT, 0.0f);
    		NIVision.imaqScale(camera.frame, camera.frame, 2, 2, NIVision.ScalingMode.SCALE_SMALLER, new NIVision.Rect(0, 0, 480, 640));
    		CameraServer.getInstance().setImage(camera.frame);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {
    	end();
    }
    
}
