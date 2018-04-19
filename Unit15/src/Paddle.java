//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10,10,10);
      speed =5;
   }
   public Paddle(int x, int y)
	{
		super(x,y,10,10);
		speed = 5;
		
	}
	public Paddle(int x, int y, int speed)
	{
		super(x,y,10,10);
		this.speed = speed;
		
	}
	public Paddle(int x, int y, int w, int h, int s)
	{
		super(x,y,w,h);
		speed = s;
			}
	public Paddle(int x, int y, int w, int h, Color c, int s)
	{
		super(x,y,w,h,c);
		speed = s;
		
	}
	public int getSpeed()
	{
		return speed;
	}
	
	
	   public void moveUpAndDraw(Graphics window)
	   {
	    super.draw(window, Color.WHITE);
	    super.setY(getY()-speed);
	    super.draw(window);
	
	   }
	
	   public void moveDownAndDraw(Graphics window)
	   {
		   super.draw(window, Color.WHITE);
		    super.setY(getY()+speed);
		    super.draw(window);
	
	   }
	
	   //add get methods
	   public String toString()
	   {
		   String output=super.toString() + "speed: "+speed;
		
		   return output;
	   }
	   
	   //add a toString() method
	}