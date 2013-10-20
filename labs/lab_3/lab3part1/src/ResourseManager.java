import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;


public class ResourseManager {

	private static NXTComm NXTConn;
	
	private LightSensor lightSensor;
	
	public ResourseManager() throws NXTCommException
	{
		NXTConn = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
	}
	
	public void createLightSensor()
	{
		lightSensor = new LightSensor(SensorPort.S1);
	}
	
	public synchronized int getLightValue()
	{
		return lightSensor.getLightValue();
	}
	
	public synchronized void moveMotorForward()
	{
		Motor.A.forward();
	}
	
	public synchronized void moveMotorBackwards()
	{
		Motor.A.backward();
	}
	
	public synchronized void moveMotorStop()
	{
		Motor.A.stop();
	}
	
	
	
}
