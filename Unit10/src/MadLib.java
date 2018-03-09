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
import java.util.Random;
import static java.lang.System.*;



public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	String out = "";
	
	public MadLib()
	{
		verbs = new ArrayList();
		nouns = new ArrayList();
		adjectives = new ArrayList();
		
		
	}

	public MadLib(String fileName)
	{
		//load stuff
		
		loadNouns();
		loadVerbs();
		loadAdjectives();
		
		try{
			Scanner file = new Scanner(new File(fileName));
		
			do{
				out += file.next() + " ";
			}while(file.hasNext());
		
		
		
		
		
	
		
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		nouns = new ArrayList<String>();
		try{
				Scanner nounsOne = new Scanner(new File("nouns.dat"));
				while(nounsOne.hasNext())
				{
					nouns.add(nounsOne.nextLine());
	
				}
		
		
		
		nounsOne.close();
		
		}
		catch(Exception e)
		{
		}	
		
	}
	
	public void loadVerbs()
	{
		verbs = new ArrayList<String>();
		try{
			Scanner verbsOne = new Scanner(new File("verbs.dat"));
			while(verbsOne.hasNext())
			{
				verbs.add(verbsOne.nextLine());
			
			}
	
	
			verbsOne.close();

	
		}
		catch(Exception e)
		{
		}
	}

	public void loadAdjectives()
	{
		adjectives = new ArrayList<String>();
		try{
	
			Scanner adjectivesOne = new Scanner(new File("adjectives.dat"));
			while(adjectivesOne.hasNext())
			{
				adjectives.add(adjectivesOne.nextLine());
			
			}
	
			adjectivesOne.close();
	
		}
		catch(Exception e)
		{
		}
	}

	

	public String getRandomVerb()
	{
		Random x = new Random();
		int ran = x.nextInt(verbs.size());
		
		return verbs.get(ran);
	}
	
	public String getRandomNoun()
	{
		Random x = new Random();
		int ran = x.nextInt(nouns.size());
		
		return nouns.get(ran);
	}
	
	public String getRandomAdjective()
	{
		Random x = new Random();
		int ran = x.nextInt(adjectives.size());
		
		return adjectives.get(ran);
	}		

	public String toString()
	{
		for (int i = 0; i < out.length(); i++) {
			if(Character.toString(out.charAt(i)).equals("#"))
			{
				  
				out= out.substring(0, i)+ getRandomNoun() +out.substring(i+1);
			}
			else if(Character.toString(out.charAt(i)).equals("@"))
			{
			   out= out.substring(0, i)+ getRandomVerb() +out.substring(i+1);
			}
			  
			else if(Character.toString(out.charAt(i)).equals("&"))
			{
				out= out.substring(0, i)+ getRandomAdjective() +out.substring(i+1);
			}
			  
			
		}
		return out;
	}
}