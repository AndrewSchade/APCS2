//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		sentence = "";
		char lookFor = ' ';
	}

	public LetterRemover(String s, char rem) {
		setRemover(s, rem);
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String changed = sentence;
		int loc = sentence.indexOf(lookFor);
		while (loc > 0) {
			changed = changed.substring(0, loc) + changed.substring(loc + 1);
			loc = changed.indexOf(lookFor);

		}

		return changed;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters();
	}
}