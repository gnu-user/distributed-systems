import java.net.*;
import java.io.*;

public class TCPObjectServer {
	public static void main(String[] args) {
		ServerSocket server_socket = null;
		Socket socket = null;
		try {
			// Create the socket
			server_socket = new ServerSocket(9999);

			while (true) {
				
				// Start listening to the socket and wait for the client to connect
				System.out.println("Wait for client ....");
				socket = server_socket.accept();
				System.out.println("Accepted from " + socket.getInetAddress());

				// Create the input stream.
				ObjectInputStream oi = new ObjectInputStream(
						socket.getInputStream());

				// Wait for the client to send the object
				Couple receivedCouple = (Couple) oi.readObject();

				// Display the Couple's information
				System.out.println("Person One = "
						+ receivedCouple.getPersonOne().name + " Person Two = "
						+ receivedCouple.getPersonTwo());

				// Create the output stream
				ObjectOutputStream oo = new ObjectOutputStream(
						socket.getOutputStream());
				
				// Add "Alice" to the new Couple's object as Person two
				Couple sentCouple = new Couple(receivedCouple.getPersonOne(),
						new Person("Alice"));

				// Send the Couple object back to the client
				oo.writeObject(sentCouple);
				oo.flush();
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}