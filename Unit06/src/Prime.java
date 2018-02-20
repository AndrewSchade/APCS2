//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{

		number = 0;

	}

	public Prime(int num)
	{

		setPrime(num);

	}

	public void setPrime(int num)
	{

		number = num;

	}

	public boolean isPrime()
	{

		if(number%2 == 1)
		{
			return true;
		}

		return false;
	
	}

	public String toString()
	{
		String output = "";
		if(isPrime() == true)
		{
			output= number + " is prime.";
		}


		if(isPrime() == false)
		{
			output= number + " is not prime.";
		}

		return output;
	}
}