package factorySQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
<<<<<<< HEAD
import java.util.Scanner;
import java.util.Map.Entry;
=======
import java.util.Map;
import java.util.Scanner;
>>>>>>> 1a24087d3cef890b63254ac8e7c98053367a08de

import Models.Course;
import Models.Professor;
import Models.Student;

public class Main {

	public static Scanner sc;
	public static DAO_Factory dao;
<<<<<<< HEAD
	public static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String args[]) throws NumberFormatException,
			IOException {
		sc = new Scanner(System.in);
		dao = new DAO_Factory();

		while (true) {
			System.out
					.println("Welcome \n Choose a user: \n 1.Admin \n 2.Student \n 3.Exit");
			int user;
			user = Integer.parseInt(in.readLine());
			if (user == 3)
				break;
			switch (user){
				case 1:
					AdminUser();
					break;
				case 2:
					StudentUser();
					break;
			}
		}
	}

	public static void AdminUser() throws NumberFormatException, IOException {
		
		int option;
		
		AdminUser admin = null;
		while (true) {
			System.out
			.println("Choose an option \n 1.View Courses \n 2.Add Student \n 3.Add Professor \n 4.Add Course \n 5.Exit");
			option = Integer.parseInt(in.readLine());
			if (option == 5)
				break;
			
			admin = new AdminUser(dao);
			switch (option) {
			case 1:
				//admin = new AdminUser(dao);
				ArrayList<Course> courseList = admin.getCourses();
				for (Course c : courseList) {
					System.out.println("Course ID: " + c.getCourse_id()
							+ "\t Course_name: " + c.getCourse_name()
							+ "\t Professor Name: "
							+ c.getProf().getProfessor_name());
				}
			
				break;
			case 2:
=======
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		sc = new Scanner(System.in);
		dao = new DAO_Factory();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// Add student
		System.out
				.println("Welcome \n Choose an option \n 1.Add Student \n 2.Add Professor \n 3.Add Course");
		int option;
		option = Integer.parseInt(in.readLine());
		Admin admin = null;
		while (true) {
			
			switch (option) {
			case 1:
<<<<<<< HEAD
				admin = new Admin(dao);
=======
>>>>>>> 1a24087d3cef890b63254ac8e7c98053367a08de
>>>>>>> e21f87ec7124933c407d7c93d66b3ebe020f5e7b
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
				admin = null;
				break;

<<<<<<< HEAD
			case 3:
=======
			case 2:
<<<<<<< HEAD
				admin = new Admin(dao);
=======
>>>>>>> 1a24087d3cef890b63254ac8e7c98053367a08de
>>>>>>> e21f87ec7124933c407d7c93d66b3ebe020f5e7b
				System.out.println("Enter ID");
				int pid = Integer.parseInt(in.readLine());
				System.out.println("Enter name");
				String pname = in.readLine();

				Professor p = new Professor(pid, pname, new ArrayList<Course>());
				admin.addProfessor(p);
				admin=null;
				break;

<<<<<<< HEAD
			case 4:
=======
			case 3:
<<<<<<< HEAD
				admin = new Admin(dao);
=======
>>>>>>> 1a24087d3cef890b63254ac8e7c98053367a08de
>>>>>>> e21f87ec7124933c407d7c93d66b3ebe020f5e7b
				System.out.println("Enter ID");
				int cid = Integer.parseInt(in.readLine());
				System.out.println("Enter name");
				String cname = in.readLine();
				System.out.println("Enter Professor ID");
				int profId = Integer.parseInt(in.readLine());
				Course c = new Course(cid, cname, new ArrayList<Student>(),
						new Professor(profId, null, new ArrayList<Course>()));
				admin.addCourse(c);
				admin = null;
				break;
<<<<<<< HEAD
			}
			admin = null;
			//option = Integer.parseInt(in.readLine());
		}
	}

	public static void StudentUser() throws NumberFormatException, IOException {
		
		int option;
		
		StudentUser student = new StudentUser(dao);
		while (true) {
			System.out
			.println("Choose an option \n 1.View Courses \n 2.View Enrolled Courses \n 3.Exit");
			option = Integer.parseInt(in.readLine());
			switch (option) {
			case 1:
				ArrayList<Course> courseList = student.getCourses();
				for (Course c : courseList) {
					System.out.println("Course ID: " + c.getCourse_id()
							+ "\t Course_name: " + c.getCourse_name()
							+ "\t Professor Name: "
							+ c.getProf().getProfessor_name());
				}
				break;
			case 2:
				System.out.println("Enter Student ID");
				int sid = Integer.parseInt(in.readLine());
				HashMap<Course, Double> courses_marks = student.getEnrolledCourses(sid);
				System.out.println("Course Details for Student Id: " + sid + " are: ");
				for (Entry<Course, Double> entry : courses_marks.entrySet()) {
				    Course c = entry.getKey();
				    double marks = entry.getValue();
				    System.out.println("Course Name: "+c.getCourse_name()+"\t Marks: "+marks);
				}
				break;
			case 3:
				break;
			}
		}
	}
=======
			
			case 4:
				break;
			}
			option = Integer.parseInt(in.readLine());
		}

	}

>>>>>>> 1a24087d3cef890b63254ac8e7c98053367a08de
}
