/*
	Trivial application that displays a string
*/
import TerminalIO.KeyboardReader;
import java.io.*;
import java.util.Random;

public class StudentDriver {

	public static void main(String args[]) {
	
		KeyboardReader reader = new KeyboardReader();
		Student[] classList = new Student[10];
		Student t = new Student();
		String ln, fn;
		int e1, e2, e3;
		
		/*for (int i = 0; i < 5; i++) {
			ln = reader.readLine("Last name? ");
			fn = reader.readLine("First name? ");
			e1 = reader.readInt("Exam 1> ");
			e2 = reader.readInt("Exam 2> ");
			e3 = reader.readInt("Exam 3> ");
			Student s = new Student(ln, fn, e1, e2, e3);
			classList[i] = s;
		} */
		loadClass(classList);
		
		for (int j = 0; j < 10; j++)
			System.out.println(classList[j]);
		System.out.println();

		t.sortByName(classList);
		for (int j = 0; j < 10; j++)
			System.out.println(classList[j]);
		System.out.println();
		
		t.sortByAverage(classList);
		for (int j = 0; j < 10; j++)
			System.out.println(classList[j]);

	}
	
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

}
