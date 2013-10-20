import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;


public class ResourseManager {

	public static final int MOTOR_A = 0;
	public static final int MOTOR_B = 1;
	public static final int MOTOR_C = 2;
	
	public static final int PORT_1 = 1;
	public static final int PORT_2 = 2;
	public static final int PORT_3 = 3;
	public static final int PORT_4 = 4;
	private static NXTComm NXTConn;
	
	private LightSensor lightSensor;
	
	public ResourseManager() throws NXTCommException
	{
		NXTConn = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
	}
	
	public void createLightSensor(int port)
	{
		switch (port) {
		case PORT_1:
			lightSensor = new LightSensor(SensorPort.S1);
			break;
		case PORT_2:
			lightSensor = new LightSensor(SensorPort.S2);
			break;
		case PORT_3:
			lightSensor = new LightSensor(SensorPort.S3);
			break;
		case PORT_4:
			lightSensor = new LightSensor(SensorPort.S4);
			break;
		}
		
	}
	
	public synchronized int getLightValue()
	{
		return lightSensor.getLightValue();
	}
	
	public synchronized void moveMotorForward(int motor)
	{
		switch (motor) {
		case MOTOR_A:
			Motor.A.forward();
			break;
		case MOTOR_B:
			Motor.B.forward();
			break;
		case MOTOR_C:
			Motor.C.forward();
			break;
		}
	}
	
	public synchronized void moveMotorBackwards(int motor)
	{
		switch (motor) {
		case MOTOR_A:
			Motor.A.backward();
			break;
		case MOTOR_B:
			Motor.B.backward();
			break;
		case MOTOR_C:
			Motor.C.backward();
			break;
		}
	}
	
	public synchronized void moveMotorStop(int motor)
	{
		switch (motor) {
		case MOTOR_A:
			Motor.A.stop();
			break;
		case MOTOR_B:
			Motor.B.stop();
			break;
		case MOTOR_C:
			Motor.C.stop();
			break;
		}
	}	
	
}
