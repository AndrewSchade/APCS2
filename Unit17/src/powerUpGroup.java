import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class powerUpGroup {
private ArrayList<PowerUp>p;

public powerUpGroup()
{
	p = new ArrayList<PowerUp>();
}
public void drawEmAll(Graphics window)
{
	if(p.size()>=0)
	{
	for (PowerUp power : p) {
		power.draw(window);
	}
	}
}

public void add()
{
Random r = new Random();
Random r2 = new Random();
int posx = r.nextInt(400)+100;
int posy = r2.nextInt(650)+100;
p.add(new PowerUp(posx,posy, 20,20));
}
public boolean collided(Ship t)
{
	for (int j = 0; j < p.size(); j++) {
		try {
			if (t.isCollide(p.get(j))) {
				return true;
				
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}
	return false;
}
public void removeCollidedOnes(Ship t)
{
	for (int j = 0; j < p.size(); j++) {
		try {
			if (collided(t)) {
				p.remove(j);
				j--;
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}
}
}