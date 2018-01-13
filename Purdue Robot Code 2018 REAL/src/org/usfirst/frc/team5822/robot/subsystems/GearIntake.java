package org.usfirst.frc.team5822.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearIntake extends Subsystem 
{
	Compressor c;
	DoubleSolenoid hanSolo;
	TalonSRX intake;

	public GearIntake()
	{
		c = new Compressor(0);
		c.setClosedLoopControl(true);
		
		hanSolo = new DoubleSolenoid(0,1);
		hanSolo.set(DoubleSolenoid.Value.kReverse);
		
		intake = new TalonSRX(4);
		intake.overrideLimitSwitchesEnable(true);
		
	}
	
    public void initDefaultCommand() 
    {
    }//edit
    
    public void forward()
    {
    	hanSolo.set(DoubleSolenoid.Value.kForward);
    }
    
    public void reverse()
    {
    	hanSolo.set(DoubleSolenoid.Value.kReverse);
    }

    public void off()
    {
		hanSolo.set(DoubleSolenoid.Value.kOff);
    }

    public boolean lSwitch()
    {
    	return true;
    	//return intake.isFwdLimitSwitchClosed(); TODO
    }
    
    public void intake()
    {
    	intake.set(ControlMode.PercentOutput, .75);
    }

	public void stop() 
	{
		intake.set(ControlMode.PercentOutput, 0);
	}
}