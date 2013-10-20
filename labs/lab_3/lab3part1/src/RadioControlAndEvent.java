import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import lejos.pc.comm.NXTCommException;

/*
 * This program is a simple program that
 * will drive a motor when the user presses a
 * arrow key form in the keyboard.
 *
 */
public class RadioControlAndEvent extends Frame implements Runnable, KeyListener {

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

	public static ResourseManager rm;
	
	public static Checkbox checker;
	

	/*
	 * Constructor.
	 */
	public RadioControlAndEvent() {
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
			switch (getCommand()) {
			case COMMAND_NONE:
				setTitle("None");
				rm.moveMotorStop();
				break;
			case COMMAND_FORWARDS:
				setTitle("Forwards");
				direction = DIRECTION_FORWARDS;
				rm.moveMotorForward();
				break;
			case COMMAND_BACKWARDS:
				setTitle("Backwards");
				direction = DIRECTION_BACKWARDS;
				rm.moveMotorBackwards();
				break;
			default:
				System.out.println("unknown command " + command);
				System.exit(1);
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
		
		try {
			rm = new ResourseManager();
		}
		catch(NXTCommException e) {
			System.out.println("Error - creating NXT connection");
		}
				
		RadioControlAndEvent s = new RadioControlAndEvent();
		Thread t = new Thread(s);
		t.start();
	}
}