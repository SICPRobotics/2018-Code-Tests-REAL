package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;
import org.usfirst.frc.team5822.robot.subsystems.*;
import edu.wpi.cscore.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	public static Preferences prefs; 
	SendableChooser<Command> chooseAutonomous; 
	Command autonomousCommand;
	
	//subsystems
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Sensors sensors;
	public static Climber climber;
	public static GearIntake gearIntake;
	
	//h
	//cameras
	//Compressor c;
	UsbCamera cam0; 
	UsbCamera cam1; 

	@Override
	public void robotInit() 
	{
//		c = new Compressor(0);
//		c.setClosedLoopControl(true);
		
	//	System.out.println(c.enabled());
		chooseAutonomous = new SendableChooser(); 
		driveTrain = new DriveTrain();
		climber = new Climber();
		sensors = new Sensors();
		gearIntake = new GearIntake();
		oi = new OI();		
		
		
		//adds all auto options to the sendable chooser
		chooseAutonomous.addDefault("Cross Baseline Only", new AutoCrossBaseline());
		
		chooseAutonomous.addObject("Center Gear Only", new AutoCenterGear());

		chooseAutonomous.addObject("Gear at Blue Boiler", new AutoBlueBoilerGear());
		chooseAutonomous.addObject("Gear at Blue Retrieval Zone", new AutoBlueRetrievalZoneGear());
		
		chooseAutonomous.addObject("Gear at Red Boiler", new AutoRedBoilerGear());
		chooseAutonomous.addObject("Gear at Red Retrieval Zone", new AutoRedRetrievalZoneGear());
	
		SmartDashboard.putData("Auto Mode", chooseAutonomous);
	 
		//starts cameras
		
		
		SmartDashboard.putNumber("Encoder Value", Sensors.rightEncoderDistance()); 
	}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {}

	@Override
	public void autonomousInit() 
	{
		Sensors.resetEncoders();
		
		autonomousCommand = (Command) chooseAutonomous.getSelected();  //sets auto command to the command that was selected
		
		if (autonomousCommand != null)
		{
			autonomousCommand.start(); 
		}

	}

	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run(); //runs selected autonomous command group
	}

	@Override
	public void teleopInit() 
	{
		if (autonomousCommand != null)
			autonomousCommand.cancel(); //cancels whatever command group was running
		 
		Robot.driveTrain.disable(); //disable any PIDs that were running
		Sensors.resetEncoders();
		//Robot.driveTrain.changeIsTurning(false);

		Scheduler.getInstance().removeAll(); //removes scheduled commands
	}

	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run(); //runs all button functions from the OI
		
		if (!DriveTrain.isTurning) //if no vision is running, the joystick controls the robot
			JoystickFunctions.joystickDrive(DriveTrain.wheelz);
	}

}
