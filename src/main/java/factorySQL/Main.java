package factorySQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Models.Course;
import Models.Professor;
import Models.Student;

public class Main {

	public static Scanner sc;
	public static DAO_Factory dao;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		sc = new Scanner(System.in);
		dao = new DAO_Factory();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// Add student
		System.out
				.println("Welcome \n Choose an option \n 1.Add Student \n 2.Add Professor \n 3.Add Course");
		int option;
		option = Integer.parseInt(in.readLine());
		Admin admin = new Admin(dao);
		while (true) {
			
			switch (option) {
			case 1:
				System.out.println("Enter ID");
				int id = Integer.parseInt(in.readLine());
				System.out.println("Enter name");
				String name = in.readLine();
				System.out.println("Enter number of courses");
				int numCourses = Integer.parseInt(in.readLine());
				// Student s = new Student(id,name,null,null);
				HashMap<Integer, Double> m = new HashMap<Integer, Double>();
				ArrayList<Course> courses = new ArrayList<Course>();
				while (numCourses > 0) {
					System.out.println("Enter course ID");
					int course = Integer.parseInt(in.readLine());
					System.out.println("Enter marks for above course");
					double marks = Double.parseDouble(in.readLine());
					m.put(course, marks);
					Course c = new Course(course, null, null, null);
					courses.add(c);
					numCourses--;
					// courses.add(e)
				}
				Student s = new Student(id, name, courses, m);
				admin.addStudent(s);
				break;

			case 2:
				System.out.println("Enter ID");
				int pid = Integer.parseInt(in.readLine());
				System.out.println("Enter name");
				String pname = in.readLine();

				Professor p = new Professor(pid, pname, new ArrayList<Course>());
				admin.addProfessor(p);
				break;

			case 3:
				System.out.println("Enter ID");
				int cid = Integer.parseInt(in.readLine());
				System.out.println("Enter name");
				String cname = in.readLine();
				System.out.println("Enter Professor ID");
				int profId = Integer.parseInt(in.readLine());
				Course c = new Course(cid, cname, new ArrayList<Student>(),
						new Professor(profId, null, new ArrayList<Course>()));
				admin.addCourse(c);
				break;
			
			case 4:
				break;
			}
			option = Integer.parseInt(in.readLine());
		}

	}

}
