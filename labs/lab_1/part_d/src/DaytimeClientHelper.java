import java.net.*;

/**
 * This class is a module which provides that application logic
 * for a Daytime Client which uses stream-mode socket for IPC.
 * @author M. L. Liu
 */

public class DaytimeClientHelper {
	
   public static String getTimestamp(String hostName,
      String portNum) throws Exception	{     


      String timestamp = "";      
      InetAddress serverHost = InetAddress.getByName(hostName);
      int serverPort = Integer.parseInt(portNum);
      // instantiates a stream mode socket and wait to make a 
      // connection to the server port
/**/  System.out.println("Connection request made");
      MyStreamSocket mySocket = 
      new MyStreamSocket(serverHost, serverPort); 
	   // now wait to receive the timestamp
      timestamp = mySocket.receiveMessage();
      mySocket.close( ); // disconnect is implied
      return timestamp;
   }
   
   public static MyStreamSocket connectToServer(String hostName, String portNum)
		   throws Exception
   {
	   	InetAddress serverHost = InetAddress.getByName(hostName);
		int serverPort = Integer.parseInt(portNum);
		// instantiates a stream mode socket and wait to make a
		// connection to the server port
		System.out.println("Connection request made");
		return new MyStreamSocket(serverHost, serverPort);
   }
   
   public static int getLightSensorValue(String hostName, String portNum)
		   throws Exception {
	   
	   MyStreamSocket socket = connectToServer(hostName, portNum);
	   
	   socket.sendMessage("Light");
	   
	   String value = socket.receiveMessage();
	   
	   return Integer.valueOf(value);
   }
   
   public static Boolean startMotor(String hostName, String portNum)
		   throws Exception {
	   MyStreamSocket socket = connectToServer(hostName, portNum);
	   
	   socket.sendMessage("Forward");
	   
	   String value = socket.receiveMessage();
	   
	   return Boolean.valueOf(value);
   }
   
   public static Boolean stopMotor(String hostName, String portNum)
		   throws Exception {
	   MyStreamSocket socket = connectToServer(hostName, portNum);
	   
	   socket.sendMessage("Stop");
	   
	   String value = socket.receiveMessage();
	   
	   return Boolean.valueOf(value);
   }
   
   
} //end class
