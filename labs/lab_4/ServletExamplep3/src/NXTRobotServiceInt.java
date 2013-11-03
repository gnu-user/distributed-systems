import java.rmi.Remote;

public interface NXTRobotServiceInt extends Remote {
	public void open()throws java.rmi.RemoteException;
	public void close()throws java.rmi.RemoteException;
	public void forward(String motorLabel)throws java.rmi.RemoteException;
	public void backward(String motorLabel)throws java.rmi.RemoteException;
	public void stop(String motorLabel)throws java.rmi.RemoteException;
	
	public void createLightSensor(int port) throws java.rmi.RemoteException;
	public int getLightValue() throws java.rmi.RemoteException;

}
