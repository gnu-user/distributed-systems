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
		String host = "localhost";
		String portNum = "13";
		
		System.out.println("Welcome to the Daytime client.\n"
				+ "What is the your command");
		boolean valid = true;
		try {

			while (valid) {
				
				String hostName = br.readLine();

				if (hostName.equalsIgnoreCase("d")) {
					System.out.println("Here is the timestamp received " +
							"from the server" + DaytimeClientHelper.getTimestamp(
							host, portNum) + "\n");
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
