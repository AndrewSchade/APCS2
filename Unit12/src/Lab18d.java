//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.*;


public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("lab18d.dat"));
		ArrayList<Word> words = new ArrayList<Word>();
		int size = file.nextInt();
		while(file.hasNextLine()){
			words.add(new Word(file.nextLine()));
		}
			for (int i = 0; i <words.size(); i++) {
				System.out.println(words.get(i));
			}
			for (int i = 0; i < words.size()-1; i++) {
				for (int j = 0; j < words.size()-1; j++) {
					if(words.get(j).compareTo(words.get(j+1))>0)
					{
						Word temp  = words.get(j);
						words.set(j, words.get(j+1));
						words.set(j+1, temp);
					}
				}
			}
			System.out.println("");
			for (int i = 0; i <words.size(); i++) {
				System.out.println(words.get(i));
			}
	}
}