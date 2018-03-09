//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;
	private Scanner file;

	public Histogram()
	{
		count = new ArrayList<Integer>();
		letters = new ArrayList<Character>();



	}

	public Histogram(char[] values, String fName)
	{
		count = new ArrayList<Integer>();
		letters = new ArrayList<Character>();
		for(int z = 0; z < values.length; z++){
			letters.add(values[z]);
		}
		fileName = fName;
		
	
		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		for(int x = 0; x < letters.size(); x++){
			
			Scanner file = new Scanner(new File(fileName));
			int y = 0;
			
			do{
				String j = file.next();
				for(int i = 0; i < j.length(); i++){
					if(j.charAt(i) == letters.get(x)){
						y++;
					}
				}
			}while(file.hasNext());
			
		count.add(y);	
		}







	}

	public char mostFrequent()
	{
		int most = count.get(0);
		int ind = 0;
		for(int i = 0; i < count.size(); i++){
			if(most < count.get(i)){
				most = count.get(i);
				ind = i;
			}
		}
		return letters.get(ind);
	}

	public char leastFrequent()
	{
		int least = count.get(0);
		int ind = 0;
		for (int i = 0; i < count.size(); i++) {
			if (least > count.get(i)) {
				least = count.get(i);
				ind = i;
			}
		}
		return letters.get(ind);
	}

	public String toString()
	{
		return fileName + "\n" + letters + "\n" + count + "\n\n\n";
	}
}