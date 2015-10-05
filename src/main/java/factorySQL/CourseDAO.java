package factorySQL;

import java.util.ArrayList;

import Models.Course;

public interface CourseDAO {
	public void addCourse(Course course);
	public Course getCourseById(int course_id);
	public ArrayList<Course> getCourses();
}
