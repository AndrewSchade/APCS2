//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		int size = 0;
		String letter = "";
	}

	public TriangleThree(int count, String let)
	{
		setTriangle(let, count);
	}

	public void setTriangle( String let, int sz )
	{
		letter = let;
		size = sz;
	}

	public String getLetter()
	{
		return letter;
	}

	public String toString()
	{
		String output="";
		int sz = size;
		int sze = 1;
		for(int i = 0; i < size; i++)
		{
			for(int j = sz; j > 1; j--)
			{
				output = output + " ";
			}
			for(int h = 0; h < sze; h++)
			{
				output = output + getLetter();
			}
			output = output + "\n"; 
			sz = sz - 1;
			sze = sze + 1;
		}
		return output+"\n";
	}
}