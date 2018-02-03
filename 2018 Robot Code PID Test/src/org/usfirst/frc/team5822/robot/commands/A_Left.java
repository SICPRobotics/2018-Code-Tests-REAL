package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Left extends CommandGroup
{
    public A_Left(String gameData) 
    {
    	if (gameData.charAt(0) == 'L')
    	{
    		// Left Side Switch	
    		System.out.println("Left Position/Left Switch");
    		addSequential(new DriveForward(148.875));
    		//addParallel(new MoveArm(RobotMap.k_switch));
    		addSequential(new TurnGroup(90));
    		addSequential(new DriveForward(19.435));
    		addSequential(new Intake(-.7, false));
    	} 
    	else 
    	{
    		if (gameData.charAt(1) == 'L')
    		{
    			// Left Side Scale
    			System.out.println("Left Position/Left Scale");
    			addSequential(new DriveForward(304.875));
    			//addParallel(new MoveArm(RobotMap.k_scale));
    			addSequential(new TurnGroup(90));
    			addSequential(new DriveForward(5.755)); 
    			addSequential(new Intake(-.7, false));
    		} 
    		else 
    		{
    			// Cross Baseline
    			System.out.println("Left Position/Cross Baseline");
    			addSequential(new DriveForward(148.875));
    		}
    	}
    }
}
