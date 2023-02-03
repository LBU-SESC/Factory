package uk.ac.leedsbeckett.mullier.sesc;
/**
 * 
 * @author Duncan Mullier
 * Factory for instantiating objects of the Shape hierarchy that conform to the Shapes interface
 */
public class ShapeFactory 
{
	private float version = 1.1f;
	
	public String about()
	{
		return "ShapeFactory v"+version;
	}
	public Shape getShape(String shapeType)
    {
        shapeType = shapeType.toUpperCase().trim(); //you could argue that you want a specific word string to create an object but I'm allowing any case combination
        
       
        if (shapeType.equals("CIRCLE"))
        {
            return new Circle();

        }
        else if (shapeType.equals("ELLIPSE"))
        {
            return new Ellipse();

        }
        else if (shapeType.equals("RECTANGLE"))
        {
            return new Rectangle();

        }
        else if (shapeType.equals("TRIANGLE"))
        {
            return new Triangle();
        }
        else if (shapeType.equals("SQUARE"))
        {
            return new Square();
        }
        else
        {
            //if we get here then what has been passed in is unknown so throw an appropriate exception
        	RuntimeException argEx = new RuntimeException("Factory error: "+shapeType+" does not exist");
            throw argEx;
        }

       
    }
}

