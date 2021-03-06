//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;

	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{		{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};

	}

	public int countAts(int r, int c)
	{
		if(atMat[r][c] != '@') {
			return 0;
		}
		if(atMat[r][c] == '@') {
			atCount += 1;
			atMat[r][c] = 'x';
			if(r-1 >= 0){
				countAts(r-1, c);
			}
			if(r+1 < atMat.length){
				countAts(r+1, c);
			}
			if(c-1 >= 0){
				countAts(r, c-1);
			}
			if(c+1 < atMat[0].length - 1){
				countAts(r, c+1);
			}
			return 0;
		}
		return 0;
		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output="";
		output+=getAtCount()+" @s connected.";
		return output;
	}
}