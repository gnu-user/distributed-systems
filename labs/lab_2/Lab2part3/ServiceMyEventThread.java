import java.util.EventObject;

import javax.swing.JOptionPane;

public class ServiceMyEventThread extends MyEventListener {
	
	/**
	 * Constructor with delay to add the listener.
	 * @param delay
	 */
	public ServiceMyEventThread(int delay)
	{
		addEventListener(delay);
	}
	
	/**
	 *  Default constructor
	 */
	public ServiceMyEventThread()
	{
		
	}
	
	public void addEventListener(int delay) {
		// Create a new MyEventClass
		MyEventSource myEvent = new MyEventSource(delay);
		myEvent.addEventListener(this);

		this.setShowDialog(false);
		this.start();
	}

	@Override
	public void handleMyEventClassEvent(EventObject e) {
		this.setShowDialog(true);
	}
	
    @Override
    protected void executeEvent()
	{
		JOptionPane.showMessageDialog(null, "A custom event occurred",
				"Message Dialog", JOptionPane.PLAIN_MESSAGE);
	}
}
