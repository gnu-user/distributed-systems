import java.net.*;
import java.io.*;

public class TCPObjectClient {
	public static void main(String[] args) {
		Socket socket = null;
		try {

			// Connect to the server at the given address and socket
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);

			// Create the output stream to the server to send the Couple object
			ObjectOutputStream oo = new ObjectOutputStream(
					socket.getOutputStream());

			// Create the Couple object with person one as "Bob"
			Couple c = new Couple(new Person("Bob"), null);

			// Send the object to the server through the socket connection
			oo.writeObject(c);
			oo.flush();

			// Create the input stream for a response from the server
			ObjectInputStream oi = new ObjectInputStream(
					socket.getInputStream());

			// Wait until the server sends back the object and read it in
			Couple receivedCouple = (Couple) oi.readObject();

			// Print out the values of the Couple object
			System.out.println("Person One "
					+ receivedCouple.getPersonOne().name + " Person Two = "
					+ receivedCouple.getPersonTwo().name);

		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}