package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//hi there
public class OI 
{
	
	Joystick j = new Joystick(RobotMap.k_joystick1);
	Joystick x = new Joystick(RobotMap.k_xboxCntrl);
	
	Button j3 = new JoystickButton(Robot.j, 3);
	Button j4 = new JoystickButton(Robot.j, 4);		
	Button j5 = new JoystickButton(Robot.j, 5);
	Button j6 = new JoystickButton(Robot.j, 6);
	Button j7 = new JoystickButton(Robot.j, 7);
	Button j8 = new JoystickButton(Robot.j, 8);
	
	//9 and 10 don't work on our joystick 
	Button j11 = new JoystickButton(Robot.j, 11); 
	Button j12 = new JoystickButton(Robot.j, 12);

	Button buttonA = new JoystickButton(x, 1);
	Button buttonB = new JoystickButton(x, 2);
	Button buttonX = new JoystickButton(x, 3);
	Button buttonY = new JoystickButton(x, 4);
	Button buttonLB = new JoystickButton(x, 5);
	Button buttonRB = new JoystickButton(x, 6);
	Button buttonBack = new JoystickButton(x, 7);
	Button buttonStart = new JoystickButton(x, 8);	
	
	public OI()
	{
		//RumbleType[] kleftRumble = GenericHID.RumbleType.values();
		//x.setRumble(kleftRumble[1], 1.0);
		
		buttonA.whenPressed(new Intake(-1.0, false)); // negative out B
		buttonA.whenReleased(new Intake(0, false));
		
		buttonB.whenPressed(new Intake(1.0, false)); // positive in A
		buttonB.whenReleased(new Intake(0, false));
		
		buttonY.whenPressed(new Intake(-1.0, true));
		buttonY.whenReleased(new Intake(0, true));
	}
	
	
}
