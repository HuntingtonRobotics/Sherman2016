package org.usfirst.frc.team5016.robot.subsystems;

import org.usfirst.frc.team5016.robot.commands.DisplayImage;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {

	public static int session;
	public static Image frame;
	public static NIVision.Rect rect;
	public static int[] rectCoordinates;
	public static double robotX, robotY;

    public void initDefaultCommand() {
    	robotX = 0;
    	robotY = 0;
    	try {
    		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    		session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    		NIVision.IMAQdxConfigureGrab(session);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	rectCoordinates = new int[] {230, 316, 99, 83};
    	rect = new NIVision.Rect(rectCoordinates[0], rectCoordinates[1], rectCoordinates[2], rectCoordinates[3]);
    	
    	DisplayImage displayImage = new DisplayImage();
    	displayImage.setRunWhenDisabled(true);
        setDefaultCommand(displayImage);
    }
}

