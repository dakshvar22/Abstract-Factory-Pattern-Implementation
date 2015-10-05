package factorySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Models.Course;

public class CourseDAO_JDBC implements CourseDAO{
	private static final Logger LOG = LoggerFactory.getLogger(CourseDAO_JDBC.class);
	Connection dbconnection;

	public CourseDAO_JDBC(Connection dbconnection) {
		this.dbconnection = dbconnection;
	}
	public void addCourse(Course course){
		int course_id = course.getCourse_id();
		String course_name = course.getCourse_name();
		int prof_id = course.getProf().getProfessor_id();
		String sql = "insert into Course(course_id, professor_id, course_name) values(?,?,?)";
		PreparedStatement s = null;
		try{
			s = dbconnection.prepareStatement(sql);
			s.setInt(1, course_id);
			s.setInt(2, prof_id);
			s.setString(3, course_name);
			s.executeUpdate();
			LOG.info("Course "+course_name+" has been added");
		}
		catch(SQLException e){
			LOG.error(e.getMessage(),e);
		}
		
		try{
			if (s != null)
				s.close();
		}
		catch(SQLException e){
			LOG.error(e.getMessage(),e);
		}
	}
}
