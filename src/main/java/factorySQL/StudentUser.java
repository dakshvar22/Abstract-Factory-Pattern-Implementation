package factorySQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import factorySQL.DAO_Factory.TXN_STATUS;
import Models.Course;
import Models.Professor;

public class StudentUser extends User{

	public StudentUser(DAO_Factory dao) {
		this.dao = dao;
	}
	public HashMap<Course, Double> getEnrolledCourses(int student_id){
		HashMap<Integer, Double> courses_marks = new HashMap<Integer,Double>();
		HashMap<Course,Double> enrolled_courses = new HashMap<Course,Double>();
		try{
			this.dao.activateConnection();
			StudentDAO sdao = dao.getStudentDAO();
			CourseDAO cdao = dao.getCourseDAO();
			ProfessorDAO pdao = dao.getProfessorDAO();
			
			courses_marks = sdao.getEnrolledCourses(student_id);
			for (Entry<Integer, Double> entry : courses_marks.entrySet()) {
			    int course_id = entry.getKey();
			    double marks = entry.getValue();
			    Course c = cdao.getCourseById(course_id);
				c.setProf(pdao.getProfessorById(c.getProf().getProfessor_id()));
				enrolled_courses.put(c, marks);
			}
			
			this.dao.deactivateConnection(TXN_STATUS.COMMIT);
		}
		catch(Exception e)
		{
			this.dao.deactivateConnection(TXN_STATUS.ROLLBACK);
			LOG.error(e.getMessage(),e);
			
		}
		return enrolled_courses;
	}
}
