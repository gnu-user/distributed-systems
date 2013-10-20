import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lejos.pc.comm.NXTComm;


public class NXTRobotService extends UnicastRemoteObject implements NXTRobotServiceInt {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static NXTComm NXTConn;
	
	public static ResourseManager rm;

	public NXTRobotService() throws RemoteException {
		super( );
		try {
			rm = new ResourseManager();
		}
		catch(Exception e) {
			System.out.println("Error - creating NXT connection");
		}
		
	}

	public void open()throws RemoteException { 
	}
	
	public void close()throws RemoteException { 
	}

	public void forward(char motorLabel)throws RemoteException {
		switch (motorLabel) {
		case 'A':
			rm.moveMotorForward(ResourseManager.MOTOR_A);
			break;
		case 'B':
			rm.moveMotorForward(ResourseManager.MOTOR_B);
			break;
		case 'C':
			rm.moveMotorForward(ResourseManager.MOTOR_C);
			break;
		default:
		}
	}
	
	public void backward(char motorLabel)throws RemoteException {
		switch (motorLabel) {
		case 'A':
			rm.moveMotorBackwards(ResourseManager.MOTOR_A);
			break;
		case 'B':
			rm.moveMotorBackwards(ResourseManager.MOTOR_B);
			break;
		case 'C':
			rm.moveMotorBackwards(ResourseManager.MOTOR_C);
			break;
		default:
		}
	}
	
	public void stop(char motorLabel)throws RemoteException {
		switch (motorLabel) {
		case 'A':
			rm.moveMotorStop(ResourseManager.MOTOR_A);
			break;
		case 'B':
			rm.moveMotorStop(ResourseManager.MOTOR_B);
			break;
		case 'C':
			rm.moveMotorStop(ResourseManager.MOTOR_C);
			break;
		default:
		}
	}

	@Override
	public void createLightSensor(int port) throws RemoteException {
		rm.createLightSensor(port);
	}

	@Override
	public int getLightValue() throws RemoteException {
		return rm.getLightValue();
	}
}
