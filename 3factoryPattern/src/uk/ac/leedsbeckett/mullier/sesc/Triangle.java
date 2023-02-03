package uk.ac.leedsbeckett.mullier.sesc;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	int width, height;

    public Triangle() 
    {
   	 super();
   	 width = 100;
        height = 100;
   	
    }
    public Triangle(Color colour, int x, int y, int width, int height) 
    {
   	 super(colour, x, y);
   	 this.width = width; //the only thing that is different from shape
           this.height = height;
    }

  
    public void set( Color colour, int... list)
    {
        //list[0] is x, list[1] is y, list[2] is radius
        super.set(colour, list[0], list[1]);
        this.width = list[2];
        this.height = list[3];
        

    }



    public void draw(Graphics g)
    {
         int half = width / 2;
         g.setColor(colour);
         g.drawLine(x, y + height, x + width, y + height); // base
         g.drawLine(x, y + height, x + half, y); // left side
         g.drawLine(x + width, y + height, x + half, y); // right side
    }
	@Override
	public double calcArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double calcPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	  public String ToString() //all classes inherit from object and ToString() is abstract in object
	     {
	         return super.ToString()+ "triangle  "+this.width+","+this.width;
	     }
}
