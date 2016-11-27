
package org.usfirst.frc.team5016.robot;

import org.usfirst.frc.team5016.robot.commands.DisplayImage;
import org.usfirst.frc.team5016.robot.commands.StraightAuto;
import org.usfirst.frc.team5016.robot.subsystems.Camera;
import org.usfirst.frc.team5016.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5016.robot.subsystems.Intake;
import org.usfirst.frc.team5016.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static Intake intake;
	public static Shooter shooter;
	public static Camera camera;
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;

    public void robotInit() {
    	driveTrain = new DriveTrain();
    	intake = new Intake();
    	shooter = new Shooter();
    	camera = new Camera();
    	
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Straight Auto", new StraightAuto());
        chooser.addObject("No Auto", null);
        SmartDashboard.putData("Auto mode", chooser);
        
        SmartDashboard.putNumber("AutoLoops", 1100);
    }
	
    public void disabledInit(){}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	try {
	        autonomousCommand = (Command) chooser.getSelected();
	        if (autonomousCommand != null) autonomousCommand.start();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
