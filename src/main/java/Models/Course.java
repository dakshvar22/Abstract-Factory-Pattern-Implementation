package Models;

import java.util.ArrayList;

public class Course {
	private int course_id;
	private String course_name;
	private ArrayList<Student> students;
	private Professor prof;
	
	public Course(int course_id, String course_name,
			ArrayList<Student> students, Professor prof) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.students = students;
		this.prof = prof;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}

}
