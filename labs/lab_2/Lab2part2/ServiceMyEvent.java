import java.util.EventObject;

import javax.swing.JOptionPane;


public class ServiceMyEvent extends MyEventListener {

	public void addEventListener()
	{
		// Create a new MyEventClass
		MyEventSource myEvent = new MyEventSource(1000);
		myEvent.addEventListener(this);
		synchronized (this) {
			try {
				// Object will wait for an interrupt
				wait();
			} catch (InterruptedException e){
				System.out.println("My thread message has been interrupted");
				// not doing anything because handleMyEventClassEvent() is called
			}	
		}
	 
		
	}

	@Override
	public void handleMyEventClassEvent(EventObject e)	{
		JOptionPane.showMessageDialog(null,"A custom event occurred",
		 "Message Dialog",JOptionPane.PLAIN_MESSAGE);
	}
}
