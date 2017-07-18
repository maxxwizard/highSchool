/*
	Matthew Huynh			Homeroom 130
	Term #3, Assignment #1
	January 10, 2006
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;
import java.io.*;
import java.util.Random;

public class Student { 

//declarations for variables needed by methods
private String lastName;
private String firstName;
private int exam1;
private int exam2;
private int exam3;

//creates a student profile with no names or grades
public Student() {
	lastName = "";
	firstName = "";
	exam1 = -1;
	exam2 = -1;
	exam3 = -1;
}

//creates a filled student profile (needs last name, first name, and three exam scores)	
public Student(String a, String b, int c, int d, int e) {
	lastName = a;
	firstName = b;
	exam1 = c;
	exam2 = d;
	exam3 = e;
}

public String getlastName() {
	return lastName;
}

public void setlastName(String a) {
	lastName = a;
}

public String getfirstName() {
	return firstName;
}

public void setfirstName(String a) {
	firstName = a;
}

public int getexam1() {
	return exam1;
}

public void setexam1(int a) {
	exam1 = a;
}

public int getexam2() {
	return exam2;
}

public void setexam2(int a) {
	exam2 = a;
}

public int getexam3() {
	return exam3;
}

public void setexam3(int a) {
	exam3 = a;
}

//method for getting the average of a student profile
public double getAverage() {

	double average = 0;
	
	if ((exam1 >= 0) && (exam1 <= 100))
		average += exam1;
	if ((exam2 >= 0) && (exam2 <= 100))
		average += exam2;
	if ((exam3 >= 0) && (exam3 <= 100))
		average += exam3;
	
	int i = 0;
	if (exam1 != -1)
		i++;
	if (exam2 != -1)
		i++;
	if (exam3 != -1)
		i++;
	if ((exam1 == -1) && (exam2 == -1) && (exam3 == -1)) {
		average = 0;
		i = 1;
		}
	
	return (average / i);
}

//method for printing out the student profile as a string
public String toString() {

	String a = lastName + ", " + firstName + "   ";
	if (exam1 != -1)
		a += exam1 + "   ";
	else
		a += "-" + "   ";
	if (exam2 != -1)
		a += exam2 + "   ";
	else
		a += "-" + "   ";
	if (exam3 != -1)
		a += exam3 + "   ";
	else
		a += "-" + "   ";
	a += getAverage();
	
	return a;
}

//method for sorting the student profiles array by last name
public static void sortByName(Student[] a) {

	Student x;

	for (int i = 0; i < a.length - 1; i++) {
		for (int j = 0; j < a.length - 1; j++) {
			if ( a[j].lastName.compareToIgnoreCase(a[j+1].lastName) > 0 ) {
				x = a[j];
				a[j] = a[j+1];
				a[j+1] = x;
				}
		}
	}
	
}

//method for sorting the student profiles array by average
public static void sortByAverage(Student[] a) {

	Student x;

	for (int i = 0; i < a.length - 1; i++) {
		for (int j = 0; j < a.length - 1; j++) {
			if (a[j].getAverage() > a[j+1].getAverage()) {
				x = a[j];
				a[j] = a[j+1];
				a[j+1] = x;
				}
		}
	}
	
}

//loads the student profiles from StudentList.txt
public static void loadClass(Student[] s) {
		
		String ln, fn, line = "", fileName = "StudentList.txt";
		int e1, e2, e3, comma, blank, numStudents = 10;
		try {
			FileInputStream stream = new FileInputStream (fileName);
			InputStreamReader iStrReader = new InputStreamReader (stream);
			BufferedReader reader = new BufferedReader (iStrReader);
			
			try {
				for (int k = 0; k < numStudents; k++) {
					line = reader.readLine();
					comma = line.indexOf(",");
					blank = line.indexOf(" ", comma + 2);
					ln = line.substring(0, comma);
					fn = line.substring(comma + 1, blank);
					e1 = Integer.parseInt(line.substring(20, 22));
					e2 = Integer.parseInt(line.substring(23, 25));
					e3 = Integer.parseInt(line.substring(26, 28));
					Student st = new Student(ln, fn, e1, e2, e3);
					s[k] = st;
					}
				
				} catch (IOException e) {
					System.out.println("Error in file input:\n"+e.toString());
				}

			stream.close();
			} catch (IOException e) {
				System.out.println("Error in opening file input:\n"+e.toString());
				}
	}

}// end public class Student