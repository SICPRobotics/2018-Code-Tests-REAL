package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TurnGroup extends CommandGroup 
{

    public TurnGroup(double degrees) 
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	Robot.sensors.resetGyro();
    	if (degrees < 0)
    	{
    		addSequential(new Turn(degrees, .3, true));
    		addSequential(new Turn(degrees, -.15, false));
    	}
    	else if (degrees > 0)
    	{
    		addSequential(new Turn(degrees, -.3, false));
    		addSequential(new Turn(degrees, .15, true));
    	}
    	System.out.println("Gryo: " + Robot.sensors.getGyro());
    	System.out.println("Finished Turn Group");
    		
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
