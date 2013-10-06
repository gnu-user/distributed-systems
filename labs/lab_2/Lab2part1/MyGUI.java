import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class MyGUI extends JFrame implements SwingConstants {

	private static final long serialVersionUID = 1L;
	static final int MAX_ROW = 3;
	static final int MAX_COL = 2;
	static final int MAX_HEIGHT = 150;
	static final int MAX_WIDTH = 300;
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	TextArea outputText;
	JTextField inputText;
	

	// Create a GUI Input Output interface to handle user input ad output

	public MyGUI() {
		super("Simple GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(70,70);
		setPreferredSize(new Dimension(MAX_WIDTH,MAX_HEIGHT));
		setResizable(false);

		// Set menus to be HeavyWeight to prevent the Panel from overlapping it.
		
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);

		// Add the menu to support Undo operation
		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the File menu.
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("The File menu");
		menuBar.add(menu);

		//Add the Exit option.

		menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Exits the application");
		menuItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0); }});

		menu.add(menuItem);


		// Create a GRID panel to hold the user I/O.
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(MAX_ROW,MAX_COL));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		panel.setBorder(blackBorder);
		panel.add(new Label("Enter Text:"));
		inputText = new JTextField("Type here",20);
		inputText.addActionListener(new MyTextActionListener());
		panel.add(inputText);
		panel.add(new Label("Your Value:"));
		outputText = new TextArea("No Input Yet",1,1,TextArea.SCROLLBARS_NONE);
		outputText.setEditable(false);
		panel.add(outputText);
		
		setContentPane(panel);
		setJMenuBar(menuBar);
		pack();
		setVisible(true);
	}
	
    class MyTextActionListener implements ActionListener {
        /** Handle the text field Return. */
        public void actionPerformed(ActionEvent e) {
        	outputText.setText(inputText.getText());
        	//outputText.replaceRange(inputText.getText(), 0, 30);   
        	}
    }

}
