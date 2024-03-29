import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
/*
 * This class periodically queries the robot's NXT light sensor and generates an
 * event when the value is less than MIN_TRIGGER.
 */

public class LightSensingEventSource implements Runnable{
	
	private static int MIN_TRIGGER = 45;
	boolean event_triggered = false;
	int delay_ms=100;
	
	private ArrayList<LightSensingEventListenerInt> _listeners = new ArrayList<LightSensingEventListenerInt>();
	//private LightSensor lightSensor;
	
	LightSensingEventSource(int delay) {
		delay_ms = delay;
		/* Create light sensor object */
		//lightSensor = new LightSensor(SensorPort.S1);
		try {
			RadioControlRMIClient.remote.createLightSensor(ResourseManager.PORT_1);
		} catch (RemoteException e) {
			// Catch remote exception
			e.printStackTrace();
		}
	}
	
	public LightSensingEventSource(){
	}
	public synchronized void addEventListener(LightSensingEventListenerInt listener)	{
		_listeners.add(listener);
	}
	public synchronized void removeEventListener(LightSensingEventListenerInt listener)	{

		_listeners.remove(listener);
	}
	
	public void run() {
	
		int dist=0;
		while(true) {
			
		
			//dist = lightSensor.getLightValue();
			try {
				dist = RadioControlRMIClient.remote.getLightValue();
				System.out.println("Light Sensor Distance: " + dist);
			} catch (RemoteException e1) {
				// Catch remote exception
				e1.printStackTrace();
			}
						
			/* if dist > MIN_TRIGGER and event_trigger == true then
			 * reset the trigger.
			 */
			
			if(event_triggered && dist >= MIN_TRIGGER)
				event_triggered = false;
			
			/* if dist is less than MIN_TRIGGER send event */
			else if(!event_triggered && dist < MIN_TRIGGER) {
				event_triggered = true;
				fireEvent();
			}
			try {
				Thread.sleep(delay_ms);
			} catch (Exception e) {
				System.out.println(e);
				System.exit(1);
			}
		}
	}

	// call this method whenever you want to notify
	//the event listeners of the particular event
	private synchronized void fireEvent()	{
		LightSensingEvent event = new LightSensingEvent(this);
		Iterator<LightSensingEventListenerInt> i = _listeners.iterator();
		while(i.hasNext())	{
			i.next().handleLightSensingEvent(event);
		}
	}
}