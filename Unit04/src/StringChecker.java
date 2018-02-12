//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StringChecker
{
	private String word;

	public StringChecker()
	{
		word = "";
	}

	public StringChecker(String s)
	{
		setString(s);
	}

    public void setString(String s)
    {
 	   word=s;
    }

	public boolean findLetter(char c)
	{
		return word.contains("" + c);
		
	}

	public boolean findSubString(String s)
	{
		
		return word.contains(s);
	}

 	public String toString()
 	{
 		return word;
 		
	}
}