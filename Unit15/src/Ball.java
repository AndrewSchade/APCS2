//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200,10,10);
		xSpeed = 1;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int x, int y)
	{
		super(x,y,10,10);
		xSpeed = 1;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h)
	{
		super(x,y,w,h);
		xSpeed = 1;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h, Color c)
	{
		super(x,y,w,h,c);
		xSpeed = 1;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h, Color c, int xSpd, int ySpd)
	{
		super(x,y,w,h,c);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}
   
   //add the set methods
	
	public void setSpeed(int xSpd, int ySpd)
	   {
		   xSpeed = xSpd;
		   ySpeed = ySpd;

	   }
   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   draw(window, Color.WHITE);

      setX(getX()+xSpeed);
	  setY(getY()+ySpeed);

		//draw the ball at its new location
	  draw(window);
   }
   	public boolean equals(Object obj)
	{
		Ball ball = (Ball) obj;
		return super.equals(ball)&&xSpeed==ball.getXSpeed()&&ySpeed==ball.getYSpeed();
	}   
   //add the get methods
	public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}
   //add a toString() method
	public String toString()
	{
		return super.toString()+" xSpeed:"+xSpeed+" ySpeed:"+ ySpeed;
	}
	public void setXSpeed(int i) {
		// TODO Auto-generated method stub
		xSpeed = i;
	}
	public void setYSpeed(int i)
	{
		ySpeed = i;
	}
	@Override
	public boolean didCollideLeft(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean didCollideRight(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean didCollideTop(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean didCollideBottom(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
}