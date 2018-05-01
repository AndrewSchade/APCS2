
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class PowerUp extends MovingThing{
	private Image image;

	public PowerUp(int x, int y, int w, int h)
	{
		
		super(x, y, w,h);
		
		try
		{
			URL url = getClass().getResource("RapidFireIcon.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	
	
	
	@Override
	public void setSpeed(int s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void move(String direction) {
		// TODO Auto-generated method stub
		
	}
	
	// rapid fire
	// speed boost
	
	//spawn in a random time between every 10 -15 seconds
	//lasts for 3 seconds
	
}