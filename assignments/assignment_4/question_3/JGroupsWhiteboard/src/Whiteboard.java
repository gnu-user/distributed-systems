/**
 * JGroups Whiteboard Example
 *
 * Jonathan Gillett, Joseph Heron, Daniel Smullen
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class Whiteboard extends ReceiverAdapter
{
    private JChannel channel;
    private static JFrame window; 
    private static ArrayList<String> validShapes = new ArrayList<String>();
    
    
    private void start() throws Exception
    {
        // Connect to the channel using the default UDP configuration
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("WhiteboardCluster");
        eventLoop();
        channel.close();
    }

    
    private void eventLoop()
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        while (true)
        {
            try
            {
                System.out.flush();
                System.out.print("> ");
                String line = in.readLine().toLowerCase();
                
                if (line.startsWith("quit") || line.startsWith("exit"))
                {
                    break;
                }
                
                /* Process user input and create the shape on the whiteboard */
                String[] parameters = line.split("\\s+");
                if (validInput(parameters))
                {
                    Shape shape = new Shape(parameters[0], new Integer(parameters[1]), new Integer(parameters[2]), 
                            new Integer(parameters[3]), new Integer(parameters[4]));
                    Message msg = new Message(null, null, shape);
                    channel.send(msg);
                }
                else
                {
                    System.out.println("Invalid shape parameters!");
                    System.out.println("USAGE: [rectangle|circle|square|triangle] x-coordinate y-coordinate width height");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void viewAccepted(View view)
    {
        System.out.println("** view: " + view);
    }
    
    public void receive(Message msg)
    {
        try
        {
            window.getContentPane().add((Shape)msg.getObject());
            window.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private boolean validInput(String[] parameters)
    {
        String shape = parameters[0];
        boolean valid = false;
        
        for (String validShape : validShapes)
        {
            if (validShape.equals(shape))
            {
                valid = true;
            }
        }
        
        if (valid && parameters.length == 5)
        {
            return true;
        }
        
        return false;
    }
    
    public static boolean checkArrayValues(ArrayList<String> inputValues, String input)
    {
        
        for(int i = 0; i < inputValues.size(); i++)
        {
            if(inputValues.get(i).equalsIgnoreCase(input))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) throws Exception
    {
        validShapes.add("rectangle");
        validShapes.add("circle");
        validShapes.add("square");
        validShapes.add("triangle");
        
        window = new JFrame();
        window.setSize(600,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
        new Whiteboard().start();
    }
}
