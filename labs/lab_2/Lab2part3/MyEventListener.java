import java.util.EventObject;


public abstract class MyEventListener extends Thread implements MyEventClassListener {

	private boolean showDialog;
	private boolean loopRunner = true;
	
	@Override
	public void handleMyEventClassEvent(EventObject e) {
		//System.out.println("This is an event being handled!");		
	}
	
	public synchronized boolean getShowDialog()
	{
		return this.showDialog;
	}
	
	public synchronized void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
		notifyAll();
	}
	
    /**
     * The semaphore for keeping the thread running. Set this to false to
     * properly terminate the Thread
     * @param runner Whether the thread should be kept running
     */
    public synchronized void setRunner(boolean runner) {
		this.loopRunner = runner;
		notifyAll();
	}
    
    protected abstract void executeEvent();
	
	@Override
	public void run()
	{
		while(loopRunner)
		{
			while(!this.showDialog)
			{
				synchronized (this) {
					try {
						// Object will wait for an interrupt
						wait();
					} catch (InterruptedException e) {
						System.out.println("My thread message has been interrupted");
					}
				}

				executeEvent();
				this.setShowDialog(false);
			}
				
		}
	}
}
