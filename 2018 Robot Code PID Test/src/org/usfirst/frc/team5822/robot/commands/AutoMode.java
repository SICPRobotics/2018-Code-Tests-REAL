package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMode extends CommandGroup 
{
    public AutoMode(String gameData, int fieldPosition) 
    {
    	System.out.println("Auto Mode Start");
    	
    	final int leftSide = 0;
    	final int centerSide = 1;
    	final int rightSide = 2;
    	
    	switch (fieldPosition)
    	{
    		case leftSide:
    			System.out.println("AutoMode Left");
    			addSequential(new A_Left(gameData));
    		case centerSide:
    			System.out.println("AutoMode Center");
    			addSequential(new A_Center(gameData));
    		case rightSide:
    			System.out.println("AutoMode Right");
    			addSequential(new A_Right(gameData));
    	}
    }
}
