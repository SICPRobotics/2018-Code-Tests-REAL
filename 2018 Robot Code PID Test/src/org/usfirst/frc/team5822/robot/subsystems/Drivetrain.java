package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Drivetrain extends PIDSubsystem 
{
	WPI_TalonSRX frontL, frontR, rearL, rearR;
	DifferentialDrive robotBase;
	SpeedControllerGroup left, right, autoDrive; 
	
	
	static double setpoint; 
	public static boolean isTurning; 
	static boolean isBackwards; 
	
	
	public Drivetrain()
	{
		super("driveTrain", .02, 0.00, 0); 
		setAbsoluteTolerance(0.001);
		getPIDController().setContinuous(false);
		setpoint = 0; 
		isTurning = false; 
		isBackwards = false; 
		
		
		frontL = new WPI_TalonSRX(RobotMap.k_frontLeft);
		rearL = new WPI_TalonSRX(RobotMap.k_rearLeft); // 2
		frontR = new WPI_TalonSRX(RobotMap.k_frontRight); //3
		rearR = new WPI_TalonSRX(RobotMap.k_rearRight); //4
	
		left = new SpeedControllerGroup(frontL, rearL);
		right = new SpeedControllerGroup(frontR, rearR);
		autoDrive = new SpeedControllerGroup(left, right);

		robotBase = new DifferentialDrive(left, right);
		
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
		return Sensors.getGyro() - setpoint; 
    }

	public static void pidBackwards(boolean backwards)
	{
		isBackwards = backwards; 
	}
	
    protected void usePIDOutput(double output) 
    {
    	if(isBackwards)
    		robotBase.tankDrive(-.4 + output, -.4 - output);
    	else 
    		robotBase.tankDrive(.4 - output, .4 + output);
    }
	
	public void changeIsTurning(boolean val)
	{
		isTurning = val; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public void initDefaultCommand() {}
 
    public void autoDrive(double speedLeft, double speedRight)
    {
    	left.set(speedLeft);
    	// Right side was set negative if it starts spinning
    	right.set(-speedRight);
    	//robotBase.tankDrive(speedLeft, speedRight);
    }
    
    public void cheesyDrive(Joystick j)
    {
    	double scale = j.getRawAxis(3) * -1;
    	scale = ((scale + 1) / 5) + 0.6; 
		
    	double moveValue = j.getRawAxis(1);
    	double rotateValue = j.getRawAxis(0); 

    	//Dead zone on y axis value
    	if (Math.abs(moveValue) < 0.005)
    	{
    		moveValue = 0; 
    	}

    	//creates a dead zone on x axis value only if the y axis value is small 
    	if (Math.abs(rotateValue) < 0.005 && Math.abs(moveValue) < 0.1)
    	{
    		rotateValue = 0;
    	}

    	//scale down the values 
    	moveValue = moveValue * scale * -1; 
    	rotateValue = rotateValue * 0.6; //rotation scale factor used last year (2016), can change 
		
    	robotBase.arcadeDrive(moveValue, rotateValue, true);
    }
}

