import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(100,100);
		xSpeed = 4;
		ySpeed = 1;
	}
	public Ball(int x, int y)
	{
		super(x,y);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h)
	{
		super(x,y,w,h);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h, Color col)
	{
		super(x,y,w,h,col);
		xSpeed = 3;
		ySpeed = 1;
	}
	//add the other Ball constructors
	public Ball(int x, int y, int w, int h, Color col, int xspeed, int yspeed)
	{
		super(x,y,w,h);
		xSpeed = xspeed;
		ySpeed = yspeed;
	}
   //add the set methods
   public void setXSpeed(int x)
   {
	   xSpeed=x;
   }
   public void setYSpeed(int y)
   {
	   ySpeed=y;
   }

   public void moveAndDraw(Graphics window)
   {
	 
   	//draw a white ball at old ball location
	draw(window,Color.WHITE);
      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      draw(window);
   }

	public boolean equals(Object obj)
	{
		Ball bbb = (Ball) obj;
		if(super.equals(bbb))
		{
			if(getXSpeed()==bbb.getXSpeed() && getYSpeed()==bbb.getYSpeed())
			{
				return true;
			}
		}
		return false;
	}   

   //add the get methods
	public int getXSpeed()
	{
		return xSpeed;
	}
	public int getYSpeed()
	{
		return ySpeed;
	}
   //add a toString() method
	public String toString()
	{
		String output = "";
		output+=super.toString()+ " " + getXSpeed() + " "+getYSpeed();
		return output;
	}
	public boolean didCollideLeft(Object obj){
		Block ob = (Block) obj;
		if (getX() > ob.getX() && getX() <= ob.getX() + ob.getWidth() && (getY() >= ob.getY() && getY() + getHeight() <= ob.getY() + ob.getHeight())){
			return true;
		}
		return false;
	}
	public boolean didCollideRight(Object obj){
		Block ob = (Block)obj;
		if (getX() < ob.getX() && getX() + getWidth() >= ob.getX() && (getY() >= ob.getY() && getY() + getHeight() <= ob.getY()+ob.getHeight())){
			return true;
		}
		return false;
	}
	public boolean didCollideTop(Object obj){
		Block ob = (Block)obj;
		if (getY()+getHeight() >= ob.getY() && getY() < ob.getY()+ob.getHeight() && (getX()>=ob.getX() && getX()+getWidth()<=ob.getX()+ob.getWidth())){
			return true;
		}
		return false;
	}
	public boolean didCollideBottom(Object obj){
		Block ob = (Block)obj;
		if (getY() <= ob.getY()+ob.getHeight() && getY()+getHeight() > ob.getY() && (getX()>=ob.getX() && getX()+getWidth()<=ob.getX()+ob.getWidth())){
			return true;
		}
		return false;
	}
}