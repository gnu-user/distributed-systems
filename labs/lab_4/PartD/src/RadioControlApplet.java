import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
 * This program is a simple program that
 * will drive a motor when the user presses a
 * arrow key form in the keyboard.
 *
 */
public class RadioControlApplet extends Applet implements Runnable, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int FRAME_HEIGHT = 450;

	public static final int FRAME_WIDTH = 300;

	public static final int DELAY_MS = 100;

	public static final int COMMAND_NONE = 1;

	public static final int COMMAND_FORWARDS = 2;

	public static final int COMMAND_BACKWARDS = 3;

	private static final int DIRECTION_FORWARDS = 1;

	private static final int DIRECTION_BACKWARDS = 2;

	private int command;

	private int direction;
	
	private static final String MOTOR_A = "A";
	private static final String MOTOR_B = "B";
	private static final String MOTOR_C = "C";
	private static final int STOP = 0;
	private static final int FORWARD = 1;
	private static final int BACKWARDS = 2;
	
	String location = "http://localhost:8084/PartD/SimpleServlet";
	
	private TextArea textArea;
	
	public Frame myFrame = new Frame("None");
	public Thread t;

	/*
	 * Initialize
	 */
	@Override
	public void init() {
		super.init();
		
		myFrame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		myFrame.addKeyListener(this);
		//myFrame.setVisible(true);
		//myFrame.setSize(new Dimension(myFrame.getWidth(), 450));
		
		textArea = new TextArea();
		textArea.setFocusable(false);
		myFrame.add(textArea);
		//myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		
	
		command = COMMAND_NONE;
		direction = DIRECTION_FORWARDS;
	}
	
	public void sendMotorCommand(String motor, int direction)
	{
		String message;
		try {
			message = "Motor=" + URLEncoder.encode(motor,"UTF-8") + "&" +"Cmd=" + URLEncoder.encode(Integer.toString(direction),"UTF-8");
				
		URL rcServlet = new URL( location );
		URLConnection servletConnection = rcServlet.openConnection();
		
		servletConnection.setDoInput(true); 
		servletConnection.setDoOutput(true); 
		servletConnection.setUseCaches(false); 

		DataOutputStream dos;

		dos = new DataOutputStream (servletConnection.getOutputStream());
		dos.writeBytes(message); 
		dos.flush(); 
		dos.close();

		// the server responds 

		BufferedReader dis = new BufferedReader(new InputStreamReader(servletConnection.getInputStream()));

		String s,out=""; 

		while ((s = dis.readLine()) != null)
		{ 
			out += s+"\n";
		} 
		textArea.setText(out); 
		   dis.close();
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
		
	}
	
	public void run() {		
		while (true) { /* loop forever */
			switch (command) {
			case COMMAND_NONE:
				myFrame.setTitle("Stopped");
				//Motor.A.stop();
				sendMotorCommand(MOTOR_A, STOP);
				break;
			case COMMAND_FORWARDS:
				myFrame.setTitle("Forwards");
				direction = DIRECTION_FORWARDS;
				//Motor.A.forward();
				sendMotorCommand(MOTOR_A, FORWARD);
				break;
			case COMMAND_BACKWARDS:
				myFrame.setTitle("Backwards");
				direction = DIRECTION_BACKWARDS;
				//Motor.A.backward();
				sendMotorCommand(MOTOR_A, BACKWARDS);
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
			command = COMMAND_FORWARDS;
			break;
		case java.awt.event.KeyEvent.VK_DOWN:
			command = COMMAND_BACKWARDS;
			break;
		default:
			command = COMMAND_NONE;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		command = COMMAND_NONE;
	}

	public void keyTyped(KeyEvent e) { /* do nothing */
	}

	/*
	 * Window closing event.
	 */
	/*protected void processWindowEvent(WindowEvent e) {		
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}*/
	
	public void stop(){
		t=null;
	}

	/*
	 * Main.
	 */
	@Override
	public void start() {
		super.start();
		//RadioControlApplet s = new RadioControlApplet();
		//this.init();
		if(t == null)
		{
			t = new Thread(this);
		}
		t.start();
	}
}