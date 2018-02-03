package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Sensors extends Subsystem 
{
	
	static ADXRS450_Gyro gyro;
	static Encoder leftEncoder, rightEncoder;
	static double gyroAngle;
	Potentiometer pot;
	AnalogInput ai = new AnalogInput(1); //put channel number for analog input potentiometer
	
	public Sensors()
	{
		gyro = new ADXRS450_Gyro();
		
		leftEncoder = new Encoder(RobotMap.k_leftEncoder_A, RobotMap.k_leftEncoder_B, false, Encoder.EncodingType.k4X);
		leftEncoder.setMaxPeriod(.1);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(5);
		leftEncoder.setReverseDirection(true);
		leftEncoder.setSamplesToAverage(7);
		
		rightEncoder = new Encoder(RobotMap.k_rightEncoder_A, RobotMap.k_rightEncoder_B, false, Encoder.EncodingType.k4X);
		rightEncoder.setMaxPeriod(.1);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(.0532);
		rightEncoder.setReverseDirection(false);
		rightEncoder.setSamplesToAverage(7);
		rightEncoder.setReverseDirection(true);
		
		pot = new AnalogPotentiometer(ai, 360); 
	}
	
	public double getPot()
	{
		double potDegrees;
		potDegrees = pot.get();
		return potDegrees;
	}
	
	public static void resetEncoders()
	{
		rightEncoder.reset();
		leftEncoder.reset();
	}
	public static void resetGyro()
	{
		gyro.reset();
	}
	
	public static double getGyro()
	{
		gyroAngle = gyro.getAngle();
		return gyroAngle;
	}
	
	public static double rightEncoderDistance()
	{
		System.out.println("Right Encoder Distance: " + rightEncoder.getDistance());
		
		//Temporary measure to test the autoDrive
		return rightEncoder.getDistance();
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

