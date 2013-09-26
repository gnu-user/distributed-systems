import java.util.Date;

public class ServerThread implements Runnable {
	static final String endMessage = ".";
	MyStreamSocket myDataSocket;

	ServerThread(MyStreamSocket myDataSocket) {
		this.myDataSocket = myDataSocket;
	}

	public void run() {
		try { // put in here the logic for each client session

			// Note: there is no need to read a request - the
			// request is implicit.
			/**/System.out.println("A client has made connection.");
			Date timestamp = new Date();
			/**/System.out.println("timestamp sent: " + timestamp.toString());
			// Now send the reply to the requestor
			myDataSocket.sendMessage(timestamp.toString());
			myDataSocket.close();
		} catch (Exception ex) {
		}
	}
}