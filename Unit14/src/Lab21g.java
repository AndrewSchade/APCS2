//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab21g
{
	public static void main(String args[])
	{
		//instantiate an AtCounter
		AtCounter MyCounter = new AtCounter();
		MyCounter.countAts(9, 9);
		System.out.println(MyCounter.toString());
		MyCounter.countAts(5, 0);
		System.out.println(MyCounter.toString());
		//test the code
	}
}