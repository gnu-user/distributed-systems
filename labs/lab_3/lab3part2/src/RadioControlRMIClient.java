import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/*
 * This program is a simple program that
 * will drive a motor when the user presses a
 * arrow key form in the keyboard.
 *
 */
public class RadioControlRMIClient extends Frame implements Runnable, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int FRAME_HEIGHT = 50;

	public static final int FRAME_WIDTH = 300;

	public static final int DELAY_MS = 100;

	public static final int COMMAND_NONE = 1;

	public static final int COMMAND_FORWARDS = 2;

	public static final int COMMAND_BACKWARDS = 3;

	private static final int DIRECTION_FORWARDS = 1;

	private static final int DIRECTION_BACKWARDS = 2;

	private int command;

	private int direction;

	//private static ResourseManager rm;
	
	public static Checkbox checker;
	
	public static final int portNumber = 9923;
	
	public static NXTRobotServiceInt remote;

	/*
	 * Constructor.
	 */
	public RadioControlRMIClient() {
		this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		checker =new Checkbox("Light sensor clicked");
		checker.setEnabled(false);
		this.add(checker);
		this.addKeyListener(this);
		this.setVisible(true);
		setResizable(false);
		
		new ServiceLightSensingEvent(1000);
		command = COMMAND_NONE;
		direction = DIRECTION_FORWARDS;
	}

	public void run() {		
		while (true) { /* loop forever */
			
			try {
				switch (getCommand()) {
				case COMMAND_NONE:
					setTitle("None");
					
					remote.stop('A');
					
					//rm.moveMotorStop(ResourseManager.MOTOR_A);
					break;
				case COMMAND_FORWARDS:
					setTitle("Forwards");
					direction = DIRECTION_FORWARDS;

					remote.forward('A');
					
					//rm.moveMotorForward(ResourseManager.MOTOR_A);
					break;
				case COMMAND_BACKWARDS:
					setTitle("Backwards");
					direction = DIRECTION_BACKWARDS;
					
					remote.backward('A');
					
					//rm.moveMotorBackwards(ResourseManager.MOTOR_A);
					break;
				default:
					System.out.println("unknown command " + command);
					System.exit(1);
				}
			} catch (RemoteException e1) {
				// Catch remote exception
				e1.printStackTrace();
			}

			try {
				Thread.sleep(DELAY_MS);
			} catch (Exception e) {
				System.out.println(e);
				System.exit(1);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		int kc = e.getKeyCode();

		switch (kc) {
		case java.awt.event.KeyEvent.VK_UP:
			setCommand(COMMAND_FORWARDS);
			break;
		case java.awt.event.KeyEvent.VK_DOWN:
			setCommand(COMMAND_BACKWARDS);
			break;
		default:
			setCommand(COMMAND_NONE);
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		setCommand(COMMAND_NONE);
	}
	
	public void setCommand(int command)
	{
		this.command = command;
	}
	
	public int getCommand()
	{
		return command;
	}

	public void keyTyped(KeyEvent e) { /* do nothing */
	}

	/*
	 * Window closing event.
	 */
	protected void processWindowEvent(WindowEvent e) {		
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}

	/*
	 * Main.
	 */
	public static void main(String[] args) {
		
		String rmCall = "rmi://localhost:" + portNumber + "/NXTRobotService";
		
		try {
			remote = (NXTRobotServiceInt) Naming.lookup(rmCall);
		} catch (MalformedURLException e) {
			// Catch malformed URL exception
			e.printStackTrace();
		} catch (RemoteException e) {
			// Catch remote exception
			e.printStackTrace();
		} catch (NotBoundException e) {
			// Catch not bound exception
			e.printStackTrace();
		}
		
		
		RadioControlRMIClient s = new RadioControlRMIClient();
		Thread t = new Thread(s);
		t.start();
	}
}