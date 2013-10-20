/**
 * JGroups Whiteboard Example
 *
 * Jonathan Gillett, Joseph Heron, Daniel Smullen
 *
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class Shape extends JComponent
{
    private static final long serialVersionUID = 1L;
    private String shape;
    private int x, y, width, height;
    private Color color;
    
    public Shape(String shape, int x, int y, int width, int height)
    {        
        this.shape = shape;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        /* Set a random colour */
        Random rn = new Random();
        this.color = new Color(rn.nextInt(256), rn.nextInt(256), rn.nextInt(256));
    }

    public void paint(Graphics g)
    {
        g.setColor(color);
        
        if (shape.equals("rectangle") || shape.equals("square"))
        {
            g.fillRect(x, y, width, height);
        }
        else if (shape.equals("circle"))
        {
            g.fillOval(x, y, width, height);
        }
        else if (shape.equals("triangle"))
        {
            int[] xPoints = {x, x + (width / 2), x + width};
            int[] yPoints = {y, y - height, y};
            g.fillPolygon(xPoints, yPoints, 3);
        }
    }
}
