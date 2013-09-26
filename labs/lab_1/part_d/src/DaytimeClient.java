import java.io.*;

/**
 * This module contains the presentaton logic of a DaytimeClient.
 * 
 * @author M. L. Liu
 */

public class DaytimeClient {
	public static void main(String[] args) {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String host = "192.168.4.127";
		String portNum = "8792";
		
		System.out.println("Welcome to the Daytime client.\n"
				+ "What is the your command");
		boolean valid = true;
		try {

			while (valid) {
				
				String hostName = br.readLine();

				if (hostName.equalsIgnoreCase("l")) {
					// get light sensor value
					System.out.println("The light sensor value is " +
							DaytimeClientHelper.getLightSensorValue(host, portNum));
				} else if (hostName.equalsIgnoreCase("f")) {
					// get light sensor value
					if (DaytimeClientHelper.startMotor(host, portNum))
					{
						System.out.println("The motor has started");
					}
					else
					{
						System.out.println("The motor has failed to start");
					}
				} else if (hostName.equalsIgnoreCase("s")) {
					// get light sensor value
					if (DaytimeClientHelper.stopMotor(host, portNum))
					{
						System.out.println("The motor has stopped");
					}
					else
					{
						System.out.println("The motor has failed to stop");
					}
					
				} else if (hostName.equalsIgnoreCase(".")) {
					valid = false;
				} else {
					System.out.println("Invalid command please enter \"d\" to get "
							+ "the time stamp or \".\" to end the session");
				}
			}

		} // end try
		catch (Exception ex) {
			ex.printStackTrace();
		} // end catch
	} // end main
} // end class
