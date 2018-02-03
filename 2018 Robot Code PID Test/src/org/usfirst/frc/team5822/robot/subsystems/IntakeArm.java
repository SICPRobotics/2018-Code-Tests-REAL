package org.usfirst.frc.team5822.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArm extends Subsystem 
{
	VictorSP intakeRight, intakeLeft, armRight, armLeft;
	
	public IntakeArm()
	{
		//intakeRight = new VictorSP(RobotMap.k_intakeRight);
		//intakeLeft = new VictorSP(RobotMap.k_intakeLeft);
		//intakeLeft.setInverted(true);
		
		//armLeft = new VictorSP(RobotMap.k_armLeft);
		//armRight = new VictorSP(RobotMap.k_armRight);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void armMotors(boolean reverse)
    {
    	if (!reverse)
    	{
    		armLeft.set(0.7);
       		armRight.set(0.7);
    	}
    	else
    	{
    		armLeft.set(-0.7);
       		armRight.set(-0.7);
    	}
    }
    public void intakeMotors(double speed, boolean oneSide)
    {
    	System.out.println("running intake motors in IntakeArm system");
    	if (!oneSide)
    	{
    		intakeRight.set(speed);
    		intakeLeft.set(speed);
    	} 
    	else if (oneSide)
    	{
    		intakeLeft.set(speed);
    		intakeRight.set(-speed - 0.8);
    	}
    }
}

