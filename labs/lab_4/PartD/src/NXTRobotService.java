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
	public static NXTComm NXTConn;

	public NXTRobotService() throws RemoteException {
		super( );
		try {
			NXTConn = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
			System.out.println("Created NXT Connection");
		}
		catch(NXTCommException e) {
			System.out.println("Error - creating NXT connection");
			e.printStackTrace();
		}
	}

	public void open()throws RemoteException { 
	}
	
	public void close()throws RemoteException { 
	}

	public void forward(String motorLabel)throws RemoteException {
		if (motorLabel.equals(MOTOR_A)) {
			Motor.A.forward();
		}
		else if (motorLabel.equals(MOTOR_B)) {
			Motor.B.forward();
		}
		else if (motorLabel.equals(MOTOR_C)) {
			Motor.C.forward();
		}
	}
	
	public void backward(String motorLabel)throws RemoteException {
		if (motorLabel.equals(MOTOR_A)) {
			Motor.A.backward();
		}
		else if (motorLabel.equals(MOTOR_B)) {
			Motor.B.backward();
		}
		else if (motorLabel.equals(MOTOR_C)) {
			Motor.C.backward();
		}
	}
	
	public void stop(String motorLabel)throws RemoteException {
		if (motorLabel.equals(MOTOR_A)) {
			Motor.A.stop();
		}
		else if (motorLabel.equals(MOTOR_B)) {
			Motor.B.stop();
		}
		else if (motorLabel.equals(MOTOR_C)) {
			Motor.C.stop();
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
