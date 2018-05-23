import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(40,40);
      speed =5;
   }
   public Paddle(int s, int t)
   {
	   super(s,t);
	   speed = 5;
   }
   public Paddle(int s, int t, int z)
   {
	   super(s,t);
	   speed = z;
   }
   public Paddle(int s, int t, int z, int w)
   {
	   super(s,t,z,w);
	   speed = 5;
   }
   public Paddle(int s, int t, int z, int w, int g)
   {
	   super(s,t,z,w);
	   speed = g;
   }
   public Paddle(int s, int t, int z, int w, Color co,int g)
   {
	   super(s,t,z,w,co);
	   speed = g;
   }
   //add the other Paddle constructors










   public void moveUpAndDraw(Graphics window)
   {
	  draw(window,Color.WHITE);
	  setY(getY()-speed);
	  draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window,Color.WHITE);
		  setY(getY()+speed);
		  draw(window);
   }
   public void moveLeftAndDraw(Graphics window)
   {
	   draw(window,Color.WHITE);
		  setX(getX()-speed);
		  draw(window);
   }
   public void moveRightAndDraw(Graphics window)
   {
	   draw(window,Color.WHITE);
		  setX(getX()+speed);
		  draw(window);
   }
   //add get methods
   public int getSpeed()
   {
	return speed;   
   }
   public String toString()
   {
	   String output ="";
	   output+= super.toString() + " " + getSpeed();
	   return output;
   }
   //add a toString() method
}