package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command 
{
	double armHeight;
	static Sensors sensors;

    public MoveArm(double height) 
    {
   		requires(Robot.intakeArm);
        armHeight = height;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    // IMPORTANT: Check that the motors are moving the right way.
    protected void execute() 
    {
    		
    	if(sensors.getPot() < armHeight)
    	{
    		while (sensors.getPot() != armHeight)
    		{
    			Robot.intakeArm.armMotors(true);
    		}
    	} 
    	else if (sensors.getPot() > armHeight)
    	{
    		while (sensors.getPot() != armHeight)
    		{
    			Robot.intakeArm.armMotors(false);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
}
