//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		
	}
	
	public Block( int x, int y){
		setX(x);
		setY(y);
		
	}

	public Block( int x, int y, int w, int h){
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
	}
	
	public Block(int x, int y, int w, int h, Color c){
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setColor(c);
	}
	//add other Block constructors - x , y , width, height, color
	
	public void setX(int x){
		xPos = x;
	}
	
	public void setY(int y){
		yPos = y;
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public void setColor(Color c){
		color = c;
	}
	
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Color getColor(){
		return color;
	}
	
	
	
	
	
	
	
	
	
   //add the other set methods
   

   
   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   window.setColor(getColor());
   }
   
	public boolean equals(Object obj)
	{
		if(((Block) obj).getX() == getX() && ((Block) obj).getY() == getY() && ((Block) obj).getWidth() == getWidth() && ((Block) obj).getHeight() == getHeight() && ((Block) obj).getColor() == getColor()){
			return true;
		}



		return false;
	}   

   //add the other get methods
    

   //add a toString() method  - x , y , width, height, color
}