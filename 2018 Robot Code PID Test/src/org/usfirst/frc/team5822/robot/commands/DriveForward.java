package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command 
{
	
	double distance;
	
    public DriveForward(double distanceTOmove) 
    {
    	requires(Robot.driveTrain);
		requires(Robot.sensors);
		distance = -distanceTOmove;    
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Sensors.resetGyro();
    	Sensors.resetEncoders();
    	System.out.println("DriveForward Init");
    	Drivetrain.pidBackwards(true);
		Robot.driveTrain.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	System.out.print("Drive Forward");
    	//Robot.driveTrain.autoDrive(.2, .2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (distance > Sensors.rightEncoderDistance())
    	{
    		return true;
    	}
    	
    	return false;
    }
    
    // Called once after isFinished returns true
    protected void end() 
    {
    	System.out.println("End: Drive Forward");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
}
