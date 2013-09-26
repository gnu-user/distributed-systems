import lejos.nxt.*;
import lejos.pc.comm.*;

public class NXTServerComm extends Thread {
	public static NXTComm NXTConn;

	/**
	 * Creates a connections to the NXT BRIC
	 * @return true if the connection was created successfully
	 */
	public boolean open()
	{
		try {
			/* Create the connection the NXT BRIC */
			this.NXTConn = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
			return true;
		}
		catch(NXTCommException e) {
			System.out.println("Error - creating NXT connection");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Connection failed */
		return false;
	}
	
	/**
	 * Gets the light sensor reading the the NXT BRIC device.
	 */
	public int getLightSensor()
	{
		try {
			/* Read light sensor value */
			LightSensor lightSensor = new LightSensor(SensorPort.S1);
			return lightSensor.getLightValue();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Default value in the event of failure */
		return -1;
	}
	
	/**
	 * Starts the motor on the NXT BRIC device.
	 */
	public boolean startMotor()
	{
		try
		{
			Motor.A.forward();
			return true;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Default value if motor failed to start */
		return false;
	}

	/**
	 * Starts the motor on the NXT BRIC device.
	 */
	public boolean stopMotor()
	{
		try
		{
			Motor.A.stop();
			return true;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Default value if motor failed to start */
		return false;
	}
}
