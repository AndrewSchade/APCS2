//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;

	public CharacterAnalyzer()
	{
		theChar = ' ';

	}

	public CharacterAnalyzer(char c)
	{
		setChar(c);

	}

	public void setChar(char c)
	{
		theChar = c;

	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		int i = theChar;
		if(65 < i && i < 90)
			return true;
		else
			return false;
	}

	public boolean isLower( )
	{
		int i = theChar;
		if(96 < i && i < 122)
			return true;
		else
			return false;
	}
	
	public boolean isNumber( )
	{
		int i = theChar;
		if(0 < i && i < 9)
			return true;
		else
			return false;
	}	

	public int getASCII( )
	{
		int i = theChar;
		return i;
	}

	public String toString()
	{
		if(isUpper() == true)
			return ""+getChar() + " is an uppercase character. ASCII == " + getASCII() + "\n";
		if(isLower() == true)
			return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
		if(isNumber() == true)
			return ""+getChar() + " is a number. ASCII == " + getASCII() + "\n";
		else
			return ""+getChar() + " is a random character. ASCII == " + getASCII() + "\n"; 
	}
}