package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A_Center extends CommandGroup 
{
	public static int newint;
    public A_Center(String gameData) 
    {
    	if (gameData.charAt(0) == 'L')
    	{
    		//Left Side Switch
    		System.out.println("Center Position/Left Switch");
    		addSequential(new DriveForward(40.875));
    		addSequential(new TurnGroup(-90));
    		addSequential(new DriveForward(61));
    		//addParallel(new RaiseArm(RobotMap.k_switch));
    		addSequential(new TurnGroup(90));
    		addSequential(new DriveForward(60.785));
    		addSequential(new Intake(-.7, false));
    	} 
    	else 
    	{
    		// Right Side Switch
    		System.out.println("Center Position/Right Switch");
    		addSequential(new DriveForward(40.875));
    		addSequential(new TurnGroup(90));
    		addSequential(new DriveForward(46.2));
    		//addParallel(new MoveArm(RobotMap.k_switch));
    		addSequential(new TurnGroup(-90));
    		addSequential(new DriveForward(60.785));
    		addSequential(new Intake(-.7, false));
    	}
    	
    }
}
