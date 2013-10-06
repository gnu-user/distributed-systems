import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.Timer;

public class MyEventSource {
	private List _listeners = new ArrayList();

	public MyEventSource(int delay) {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fireEvent();
			}
		};
		new Timer(delay, taskPerformer).start();
	}

	public synchronized void addEventListener(MyEventClassListener listener) {
		_listeners.add(listener);
	}

	public synchronized void removeEventListener(MyEventClassListener listener) {
		_listeners.remove(listener);
	}

	// call this method whenever you want to notify
	// the event listeners of the particular event
	private synchronized void fireEvent() {
		MyEventClass event = new MyEventClass(this);
		Iterator i = _listeners.iterator();
		while (i.hasNext()) {
			((MyEventClassListener) i.next()).handleMyEventClassEvent(event);
		}
		//this.notifyAll();
	}
}
