
public class NXTServerThread implements Runnable {
	static final String endMessage = ".";
	String response = "";
	MyStreamSocket myDataSocket;
	NXTServerComm myNXTServerComm;
	
	NXTServerThread(MyStreamSocket myDataSocket, NXTServerComm myNXTServerComm) {
		this.myDataSocket = myDataSocket;
		this.myNXTServerComm = myNXTServerComm;
	}

	public void run() {
		try { // put in here the logic for each client session

			// Note: there is no need to read a request - the
			// request is implicit.
			System.out.println("A client has made connection.");
			
			/* Read the command sent by the user */
			String command = myDataSocket.receiveMessage();
			System.out.println(command);
			
			if (command.equals("Light"))
			{
				System.out.println("Reading Light Sensor");
				response = Integer.toString(myNXTServerComm.getLightSensor());
			}
			else if (command.equals("Forward"))
			{
				System.out.println("Activating Motor");
				response = Boolean.toString(myNXTServerComm.startMotor());
			}
			else if (command.equals("Stop"))
			{
				System.out.println("Stopping Motor");
				response = Boolean.toString(myNXTServerComm.stopMotor());
			}
			else if (command.equals(endMessage))
			{
				System.out.println("Disconnecting");
				myDataSocket.close();
				return;
			}
			else
			{
				System.out.println("Invalid Command!");
				response = Integer.toString(0);
			}
			
			// Now send the reply to the requestor
			myDataSocket.sendMessage(response);

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}