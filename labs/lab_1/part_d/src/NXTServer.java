import java.io.*;
import java.net.*;
import java.util.Date; // for obtaining a timestamp

/**
 * This module contains the application logic of a Daytime server which uses
 * connection-oriented datagram socket for IPC. A command-line argument is
 * required to specify the server port.
 * 
 * @author M. L. Liu
 */
public class NXTServer {
	public static void main(String[] args) {
		int serverPort = 8792; // default port
		
		if (args.length == 1)
			serverPort = Integer.parseInt(args[0]);
		
		/* Connect to the NXT BRIC service */
		NXTServerComm myNXTComm = new NXTServerComm();
		if (myNXTComm.open()) {
			System.out.println("Connection established with NXT.");
		}
		else
		{
			System.out.println("Fatal Error: Failed to establish connection with NXT.");
			System.exit(1);
		}
				
		
		try {
			// instantiates a stream socket for accepting
			// connections
			ServerSocket myConnectionSocket = new ServerSocket(serverPort);
			System.out.println("NXT server ready.");
			while (true) { // forever loop
				// wait to accept a connection
				/**/System.out.println("Waiting for a connection.");
				MyStreamSocket myDataSocket = new MyStreamSocket(
						myConnectionSocket.accept());

				Thread theThread = new Thread(new NXTServerThread(myDataSocket, myNXTComm));
				theThread.start();

			} // end while
		} // end try
		catch (Exception ex) {
			ex.printStackTrace();
		} // end catch
	} // end main
} // end class
