package Models;
import java.util.*;
public class Student {

	private int student_id;
	private String student_name;
	private ArrayList<Course> courses;
	private HashMap<Integer,Double> marks;
	public Student(int student_id, String student_name,
			ArrayList<Course> courses, HashMap<Integer, Double> marks) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.courses = courses;
		this.marks = marks;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	public HashMap<Integer, Double> getMarks() {
		return marks;
	}
	public void setMarks(HashMap<Integer, Double> marks) {
		this.marks = marks;
	}
	
	
	

}
