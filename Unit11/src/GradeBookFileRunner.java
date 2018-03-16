//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!");
		ArrayList<Class> cla = new ArrayList<Class>();
		Scanner file = new Scanner(new File("gradebook.dat"));
		Class test = new Class(file.nextLine(), file.nextInt());
		cla.add(test);
		file.nextLine();
		int i = 0;
		while(file.hasNextLine())
		{
		cla.get(0).addStudent(i, new Student(file.nextLine(),file.nextLine()));	
		i++;
		}
		
		
		cla.get(0).sort();
		out.println(cla.get(0));	
		

		out.println("Failure List = " + cla.get(0).getFailureList(70));	
		out.println("Highest Average = " + cla.get(0).getStudentWithHighestAverage());
		out.println("Lowest Average = " + cla.get(0).getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",cla.get(0).getClassAverage()));									













	}		
}