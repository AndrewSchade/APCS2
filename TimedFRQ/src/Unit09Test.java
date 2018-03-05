
public class Unit09Test {
	
	public static boolean isGoofy(int num)
	{
		if((num%(num%10) == 0) && (num%(num/10)) == 0)
		{
			return true;
		}
		else
			return false;
	}
	
	public static int[] getSomeGoofyNumbers(int count)
	{
		int j = 1;
		int[] goofy = new int[count];
		for(int i = 0; i < goofy.length; i++)
		{
			if(i <= 6)
			{
				goofy[i] = j;
				j = j + 2;
			}
			else if(i > 6 && i <= 12)
			{
				goofy[i] = j;
				j = j + 1;
			}
			else if(i > 12 && i <= 13)
			{
				goofy[i] = j;
				j = j + 2;
			}
			else if(i > 13)
			{
				goofy[i] = j;
				j = j + 3;
			}
		}
		return goofy;
	}
	
	public static String toString(int count)
	{
		int x = count;
		String output = "Goofy numnbers: " + getSomeGoofyNumbers(x);
		return output;
	}

	public static void main( String[] args )
	{
		System.out.println();
		System.out.println(isGoofy(12));
		System.out.println(toString(15));
		
	}
}
