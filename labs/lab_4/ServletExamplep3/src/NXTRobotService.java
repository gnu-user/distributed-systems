import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lejos.nxt.Motor;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;


public class NXTRobotService extends UnicastRemoteObject implements NXTRobotServiceInt {

	
	public static final String MOTOR_A = "A";
	public static final String MOTOR_B = "B";
	public static final String MOTOR_C = "C";
	public static final int STOP = 0;
	public static final int FORWARD = 1;
	public static final int BACKWARDS = 2;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static NXTComm NXTConn;

	public NXTRobotService() throws RemoteException {
		super( );
		try {
			NXTConn = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
		}
		catch(NXTCommException e) {
			System.out.println("Error - creating NXT connection");
		}
	}

	public void open()throws RemoteException { 
	}
	
	public void close()throws RemoteException { 
	}

	public void forward(String motorLabel)throws RemoteException {
		switch (motorLabel) {
		case MOTOR_A:
			Motor.A.forward();
			break;
		case MOTOR_B:
			Motor.B.forward();
			break;
		case MOTOR_C:
			Motor.C.forward();
			break;
		default:
		}
	}
	
	public void backward(String motorLabel)throws RemoteException {
		switch (motorLabel) {
		case MOTOR_A:
			Motor.A.backward();
			break;
		case MOTOR_B:
			Motor.B.backward();
			break;
		case MOTOR_C:
			Motor.C.backward();
			break;
		default:
		}
	}
	
	public void stop(String motorLabel)throws RemoteException {
		switch (motorLabel) {
		case MOTOR_A:
			 Motor.A.stop();
		case MOTOR_B:
			 Motor.B.stop();
		case MOTOR_C:
			 Motor.C.stop();
		default:
		}
	}

	@Override
	public void createLightSensor(int port) throws RemoteException {
		new UnsupportedOperationException("Not implemented yet");
		
	}

	@Override
	public int getLightValue() throws RemoteException {
		new UnsupportedOperationException("Not implemented yet");
		return 0;
	}
}
