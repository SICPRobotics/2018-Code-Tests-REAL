package org.usfirst.frc.team5822.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends PIDSubsystem 
{
	public static DifferentialDrive wheelz;
	//SpeedControllerGroup left;
	//SpeedControllerGroup right;
	TalonSRX frontLeft;
	TalonSRX frontRight;
	static double setpoint; 
	public static boolean isTurning; 
	static boolean isBackwards; 
	
	public DriveTrain()
	{
		
		super("DriveTrain", .02, 0.00,0);// The constructor passes a name for the subsystem and the P, I and D constants that are used when computing the motor output
		setAbsoluteTolerance(0.001);
		getPIDController().setContinuous(false);
		
		frontLeft = new TalonSRX(0);
		TalonSRX rearLeft = new TalonSRX(1);
		rearLeft.set(ControlMode.Follower, 0);
		//left = new SpeedControllerGroup(frontLeft, rearLeft);

		frontRight = new TalonSRX(2);
		TalonSRX rearRight = new TalonSRX(3);
		rearRight.set(ControlMode.Follower, 2);
		//right = new SpeedControllerGroup(frontRight, rearRight);
		
		//wheelz = new DifferentialDrive(left, right);
		
		setpoint = 0; 
		isTurning = false; 
		isBackwards = false; 
	}
	
	/*public static void setOuts(double left, double right)
	{
		drive.setLeftRightMotorOutputs(left, right); 
	}*/
		
	public static double pidAt(double set)
	{
		setpoint = set;  
		return setpoint; 
	}
	
	// returns the sensor value that is providing the feedback for the system
	protected double returnPIDInput() 
	{    	
		return Sensors.gyroAngle() - setpoint; 
    }

	public static void pidBackwards(boolean backwards)
	{
		isBackwards = backwards; 
	}
	
    protected void usePIDOutput(double output) 
    {
    	if(isBackwards)
    	{
    		frontLeft.set(ControlMode.PercentOutput, -.4 + output);
			frontRight.set(ControlMode.PercentOutput, -.4 - output);
    		//wheelz.tankDrive(-.4 + output, -.4 - output);
    		//drive.setLeftRightMotorOutputs(-.4 + output, -.4 - output); // this is where the computed output value fromthe PIDController is applied to the motor
    	}
    	
		else 
		{
			frontLeft.set(ControlMode.PercentOutput, -.4 - output);
			frontRight.set(ControlMode.PercentOutput, -.4 + output);
    		//wheelz.tankDrive(-.4 - output, -.4 + output);
    		//drive.setLeftRightMotorOutputs(.4 - output, .4 + output); //TODO: does this work? 
		}
    		
    }
	
    //basic driving methods for auto commands
			public static void driveForward()
			{
				wheelz.arcadeDrive(0.15 , 0.0);
			}
			
			public static void driveBackward()
			{
				wheelz.arcadeDrive(0.15, 0.0);
			}
			
			public static void turnLeftSlow()
			{
				wheelz.tankDrive(-.22, .22);
			}
			
			public static void turnLeftFast()
			{
				wheelz.arcadeDrive(0.3, -1);
			}
			
			public static void turnRightSlow()
			{
				wheelz.tankDrive(0.22, -.22);
			}
			
			public static void turnRightFast()
			{
				wheelz.arcadeDrive(0.3, 1);
			}
			
	public void changeIsTurning(boolean val)
	{
		isTurning = val; 
	}

	public void initDefaultCommand() {}

}
