//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
import java.math.*;
import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;
import java.math.*;
public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;

	public Quadratic()
	{


	}

	public Quadratic(int quadA, int quadB, int quadC)
	{

	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;

 	}

	public void calcRoots( )
	{
		rootOne = ((-b + sqrt((b^2) - 4*a*c))/ (2*a));
		rootTwo = ((-b - sqrt((b^2) - 4*a*c))/ (2*a));

	}

	public void print( )
	{
		System.out.println(String.format("%.3f",rootOne));
		System.out.println(String.format("%.3f",rootTwo));

	}
}