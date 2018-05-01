
public class Bounds {
	private double x;
	private double y;
	private double radius;
	
	public Bounds(double x, double y, double size)
	{
		this.x = x;
		this.y = y;
		this.radius = size/2;
	}
	public boolean collides(Bounds c)
	{
		double xDis = this.getX() +this.getRadius() - c.getX() - c.getRadius();
		double yDis = this.getY() +this.getRadius() - c.getY() - c.getRadius();
		double radDis = this.getRadius() +c.getRadius();
		return xDis* xDis+yDis* yDis <= radDis* radDis;
	}
	
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public double getRadius(){
		return radius;
	}
	
	
}