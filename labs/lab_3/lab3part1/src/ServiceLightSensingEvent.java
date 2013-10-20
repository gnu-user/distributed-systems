import java.util.EventObject;

public class ServiceLightSensingEvent extends MyEventListener {
	
	/**
	 * Constructor with delay to add the listener.
	 * @param delay
	 */
	public ServiceLightSensingEvent(int delay)
	{
		addEventListener(delay);
	}
	
	/**
	 *  Default constructor
	 */
	public ServiceLightSensingEvent()
	{
		
	}
	
	public void addEventListener(int delay) {
		// Create a new MyEventClass
		LightSensingEventSource myEvent = new LightSensingEventSource(delay);
		myEvent.addEventListener(this);
		Thread ex = new Thread(myEvent);
		ex.start();
		
		this.setShowDialog(false);
		this.start();
	}

	@Override
	public void handleLightSensingEvent(EventObject e) {
		this.setShowDialog(true);
	}
	
    @Override
    protected void executeEvent()
	{
    	if(RadioControlAndEvent.checker.getState())
    	{
    		System.out.println("Event already handled");
    	}
    	else{
    		System.out.println("Event handled");
    		RadioControlAndEvent.checker.setState(true);
    	}
    	
    	
	}
}
