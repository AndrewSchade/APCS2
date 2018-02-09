//© A+ Computer Science  -  www.apluscompsci.com
//Name - Andy Schade
//Date - 2/6/18
//Class - per 2
//Lab  - 02e
import static java.lang.System.*;
import java.lang.Math;

public class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad)
	{
		radius = rad;
	}

	public void calculateArea( )
	{
		area = radius * radius * Math.PI; 
	}

	public void print( )
	{
		out.println("The area is: " + area);
	}
}