package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickUpGear extends Command {

    public PickUpGear() 
    {
        requires(Robot.gearIntake);
    }

    protected void initialize() 
    {
    }

    protected void execute() 
    {
    	Robot.gearIntake.intake();
    }

    protected boolean isFinished() 
    {
        return Robot.gearIntake.lSwitch();
    }

    protected void end() 
    {
    	Robot.gearIntake.stop();
    	Robot.gearIntake.reverse();
    }

    protected void interrupted() {
    }
}
