package Models;

import java.util.ArrayList;
public class Professor {

	private int professor_id;
	private String professor_name;
	private ArrayList<Course> courses;
	public Professor(int professor_id, String professor_name,
			ArrayList<Course> courses) {
		super();
		this.professor_id = professor_id;
		this.professor_name = professor_name;
		this.courses = courses;
	}
	public int getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}
	public String getProfessor_name() {
		return professor_name;
	}
	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
}
