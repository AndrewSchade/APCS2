import java.awt.Color;
import java.awt.Graphics;

public class Block 
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int hp=2;
	private Color color;
private Color color2;
	private Color temp;

	public Block()
	{
		setX(0);
		setY(0);
		setWidth(0);
		setHeight(0);
		setColor(Color.BLACK);
	}
	public Block(Color col1, Color col2)
	{
		setX(0);
		setY(0);
		setWidth(0);
		setHeight(0);
		setColor(col1);
		setColor2(col2);
	}
	public Block(int x, int y, int w, int h)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setColor(Color.BLACK);
	}
	public Block(int x, int y)
	{
		setX(x);
		setY(y);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);
	}
	public Block(int x, int y, int w)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setColor(Color.BLACK);
	}
	public Block(int x, int y, int w, int h, Color col)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setColor(col);
		setColor2(col);
	}
	//add other Block constructors - x , y , width, height, color
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public void setX(int x)
	{
		xPos = x;
	}
	public void setY(int y)
	{
		yPos = y;
	}
	public void setWidth(int w)
	{
		width = w;
	}
	public void setHeight(int h)
	{
		height = h;
	}
   //add the other set methods
   

   public void setColor(Color col)
   {
	   color = col;
   }
 
   public void decreaseHp(){
		hp--;
		temp = color;
		color  = color2;
		color2  = temp;
		
	}
   public void setColor2(Color col)
   {
	   color2 = col;
   }
	public int getHp()
	{
		return hp;
		
	}
   public void draw(Graphics window)
   {
      
	   window.setColor(color);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   window.setColor(color2);
	   window.fillRect(getX()+getWidth()/4, getY()+getHeight()/4, getWidth()/2, getHeight()/2);
   }
   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	  
   }
   
   public void draw(Graphics window, Color col, Color col2)
   {
	   setColor(col);
	   window.setColor(color);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   setColor2(col2);
	   window.setColor(color2);
	   window.fillRect(getX()+getWidth()/4, getY()+getHeight()/4, getWidth()/2, getHeight()/2);
   }
   
	public boolean equals(Object obj)
	{
		if((getHeight()==((Block) obj).getHeight())&&(getWidth()==((Block) obj).getWidth())&&(getX()==((Block) obj).getX())&&(getY()==((Block) obj).getY())&&(getColor()==((Block) obj).getColor()))
		{
			return true;
		}
		
		return false;
	}

   //add the other get methods
	public int getX()
	  {
	  return xPos;
	}
	public int getY()
	{
	   return yPos;
	}
	 public int getWidth()
	   {
		   return width;
	   }
	   public int getHeight()
	   {
		   return height;
	   }
	   public Color getColor()
	   {
		   return color;
	   }
   //add a toString() method  - x , y , width, height, color
	 public String toString()
	 {
		 String output = "";
		 output+= getX()+ " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
		 return output;
	 }
}