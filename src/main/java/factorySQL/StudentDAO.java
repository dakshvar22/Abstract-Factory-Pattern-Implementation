package factorySQL;

import java.util.ArrayList;
import java.util.HashMap;

import Models.Course;
import Models.Student;
public interface StudentDAO {
	public void addStudent(Student s);
	public HashMap<Integer,Double> getEnrolledCourses(int student_id);
}
