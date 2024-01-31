import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

import uk.ac.leedsbeckett.mullier.sesc.*;


public class TheApplication extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int XSIZE = 640, YSIZE = 480;
	int headX = 10, headY = 50, headXsize = 150, headYsize = 130;
	int eyeX = headX+(headXsize/4), eyeY = headY+(headYsize/5), eyeSize = headXsize /10, eyeGap = headXsize/3; 
	int mouthX = eyeX,  mouthY = eyeY + headY, mouthXsize = eyeSize*3, mouthYsize = eyeSize;
	ArrayList<Shape> Shapes = new ArrayList<Shape>();
		
	public TheApplication()
	{
		ShapeFactory factory = new ShapeFactory();
		setPreferredSize(new Dimension(XSIZE, YSIZE));
		pack();
		setVisible(true);
			
		Shape s;
		Color col = new Color(255, 0, 0);
        	//head
		try
		{
			s = factory.getShape("rectangle");
			col = new Color(255, 0, 0);
			s.set(col, headX, headY, headXsize, headYsize);
			Shapes.add(s);
		}catch( java.lang.RuntimeException e)
		{
			System.out.println("missing shape");
		}
   		
        	//left eye white
       		try
        	{
        		s = factory.getShape("circle");
       			col = new Color(255, 255, 255);
            		s.set(col, eyeX, eyeY, eyeSize);
            		Shapes.add(s);
    		}catch( java.lang.RuntimeException e)
    		{
    			System.out.println("missing shape");
    		}
           
        	//right eye white
        	try
    		{
        		s = factory.getShape("circle");
       			s.set(col, eyeX+eyeGap, eyeY, eyeSize);
            		Shapes.add(s);
    		}catch( java.lang.RuntimeException e)
    		{
    			System.out.println("missing shape");
    		}
           
        	//mouth
        	try
    		{
        		s = factory.getShape("ellipse");
       			col = new Color(0,0,0);
            		s.set(col, mouthX, mouthY, mouthXsize, mouthYsize);
            		Shapes.add(s);   
    		}catch( java.lang.RuntimeException e)
    		{
    			System.out.println("missing shape");
    		}
           
	}
	
	public void paint(Graphics g)
	{
		for (int i = 0; i<Shapes.size(); i++)
        {
            Shape s;
            s = (Shape) Shapes.get(i);
            if (s != null)
            {
                s.draw(g);
                System.out.println(s.ToString());
            }
            else
            	System.out.println("invalid shape in array"); //shouldn't happen as factory does not produce rubbish
        }
		g.setColor(Color.BLACK);
		g.drawString("Shape Example with factory", 100, 100);
	}

}
