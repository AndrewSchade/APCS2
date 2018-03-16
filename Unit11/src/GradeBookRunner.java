//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\n\n What is the name of this class");
		String className = keyboard.nextLine();
		System.out.println("\n\nHow many students are in this class");
		
		int numStudents = keyboard.nextInt();
		keyboard.nextLine();
		Class cla = new Class(className,numStudents);
		for(int i = 0; i<numStudents;i++)
		{
		System.out.print("Enter the name of student"+(i+1)+" : ");
		String stuName = keyboard.nextLine();
		System.out.println("Enter the grades for "+stuName);
		System.out.println("Use the formal (number of grades)-grade grade grade (ex) 2-100 56");
		String gradeList  = keyboard.nextLine();
		cla.addStudent(i, new Student(stuName,gradeList));
			
		}
		System.out.println("\n\n"+cla);
		cla.sort();
		System.out.println("\n\n"+cla);
		System.out.println("Failure List - "+ cla.getFailureList(70));
		System.out.println("Highest Average - "+cla.getStudentWithHighestAverage());
		System.out.println("Lowest Average - "+cla.getStudentWithLowestAverage());

	}		
}