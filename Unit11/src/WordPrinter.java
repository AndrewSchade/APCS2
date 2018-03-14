//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class WordPrinter
{
	private String myword;
	private int mytimes;
	
	public WordPrinter(){
		myword = " ";
		mytimes = 0;
	}
	//instance variables and constructors could be present, but are not necessary
	public WordPrinter(String word, int times){
		printWord(word, times); 
	}
	public static void printWord(String word, int times)
	{
		for(int i = 0; i < times; i++){
			System.out.println(word);
		}
		



	}
}