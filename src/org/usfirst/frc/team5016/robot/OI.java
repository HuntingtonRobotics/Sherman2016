package org.usfirst.frc.team5016.robot;

import org.usfirst.frc.team5016.robot.commands.AutoAlign;
import org.usfirst.frc.team5016.robot.commands.IntakeDown;
import org.usfirst.frc.team5016.robot.commands.IntakeIn;
import org.usfirst.frc.team5016.robot.commands.IntakeOut;
import org.usfirst.frc.team5016.robot.commands.IntakeUp;
import org.usfirst.frc.team5016.robot.commands.Shoot;
import org.usfirst.frc.team5016.robot.commands.ShooterDown;
import org.usfirst.frc.team5016.robot.commands.ShooterUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class OI {
	
	public static Joystick driverController, operatorController;
	//Driver buttons
	public static Button driverA, driverB, driverX, driverY, driverRB, driverLB, driverBack, driverStart;
	public static Trigger driverRT, driverLT;
	//Operator buttons
	public static Button operatorA, operatorB, operatorX, operatorY, operatorRB, operatorLB, operatorBack, operatorStart;
	public static Trigger operatorRT, operatorLT;
	
	public OI() {
		driverController = new Joystick(0);
		operatorController = new Joystick(1);
		
		driverA = new JoystickButton(driverController, 1);
		driverB = new JoystickButton(driverController, 2);
		driverX = new JoystickButton(driverController, 3);
		driverY = new JoystickButton(driverController, 4);
		driverLB = new JoystickButton(driverController, 5);
		driverRB = new JoystickButton(driverController, 6);
		driverBack = new JoystickButton(driverController, 7);
		driverStart = new JoystickButton(driverController, 8);
		driverRT = new Trigger() {
			@Override
			public boolean get() {
				if (driverController.getRawAxis(3) > 0.2)
					return true;
				return false;
			}
		};
		driverLT = new Trigger() {
			@Override
			public boolean get() {
				if (driverController.getRawAxis(2) > 0.2)
					return true;
				return false;
			}
		};
		
		operatorA = new JoystickButton(operatorController, 1);
		operatorB = new JoystickButton(operatorController, 2);
		operatorX = new JoystickButton(operatorController, 3);
		operatorY = new JoystickButton(operatorController, 4);
		operatorLB = new JoystickButton(operatorController, 5);
		operatorRB = new JoystickButton(operatorController, 6);
		operatorBack = new JoystickButton(operatorController, 7);
		operatorStart = new JoystickButton(operatorController, 8);
		operatorRT = new Trigger() {
			@Override
			public boolean get() {
				if (operatorController.getRawAxis(3) > 0.2)
					return true;
				return false;
			}
		};
		operatorLT = new Trigger() {
			@Override
			public boolean get() {
				if (operatorController.getRawAxis(2) > 0.2)
					return true;
				return false;
			}
		};
		
		operatorA.toggleWhenPressed(new IntakeUp());
		operatorX.toggleWhenPressed(new IntakeDown());
		operatorRB.toggleWhenPressed(new IntakeIn());
		operatorLB.toggleWhenPressed(new IntakeOut());
		
		operatorB.toggleWhenPressed(new ShooterUp());
		operatorY.toggleWhenPressed(new ShooterDown());
		
		operatorRT.whileActive(new Shoot());
		
		driverLT.whileActive(new AutoAlign());
	}
	
	public double getDriverControllerRightStick() {
		return -1*driverController.getRawAxis(5);
	}
	
	public double getDriverControllerLeftStick() {
		return -1*driverController.getRawAxis(1);
	}
	
	public double getDriverControllerRightTrigger() {
		return driverController.getRawAxis(3);
	}
	
	public double getDriverControllerLeftTrigger() {
		return driverController.getRawAxis(2);
	}
	
	public double getOperatorControllerRightStick() {
		return -1*operatorController.getRawAxis(5);
	}
	
	public double getOperatorControllerLeftStick() {
		return -1*operatorController.getRawAxis(1);
	}
	
	public double getOperatorControllerRightTrigger() {
		return -1*operatorController.getRawAxis(3);
	}
	
	public double getOperatorControllerLeftTrigger() {
		return -1*operatorController.getRawAxis(2);
	}
	
}

