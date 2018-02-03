package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command 
{
	
	boolean executedOnce, direction;
	double angle, speedTurn;
	
    public Turn(double angleTOmove, double speed, boolean turnDirection) 
    {
    	requires(Robot.driveTrain);
    	requires(Robot.sensors);
    		
    	direction = turnDirection;
        angle = angleTOmove;
        speedTurn = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.driveTrain.autoDrive(-speedTurn, speedTurn);
    	System.out.println("turn: " + Robot.sensors.getGyro());
    	executedOnce = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        if (direction)
        {
       		if (angle > Robot.sensors.getGyro())
       		{
           		return true;
            }
        }
        if (!direction)
        {
       		if (angle < Robot.sensors.getGyro())
       		{
           		return true;
            }
        }
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
