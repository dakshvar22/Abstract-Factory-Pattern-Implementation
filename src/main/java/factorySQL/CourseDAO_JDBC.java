package factorySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Models.Course;
import Models.Professor;

public class CourseDAO_JDBC implements CourseDAO{
	private static final Logger LOG = LoggerFactory.getLogger(CourseDAO_JDBC.class);
	Connection dbConnection;

	public CourseDAO_JDBC(Connection dbconnection) {
		this.dbConnection = dbconnection;
	}
	
	public void addCourse(Course course){
		int course_id = course.getCourse_id();
		String course_name = course.getCourse_name();
		int prof_id = course.getProf().getProfessor_id();
		String sql = "insert into Course(course_id, professor_id, course_name) values(?,?,?)";
		PreparedStatement s = null;
		try{
			s = dbConnection.prepareStatement(sql);
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
	
	public Course getCourseById(int course_id){
		Statement s = null;
		String sql = "select * from Course where professor_id = "+course_id;
		Course c = null;
		try{
			s = dbConnection.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()){
				int professor_id = res.getInt("professor_id");
				String course_name = res.getString("course_name");
				c = new Course(course_id, course_name, null, new Professor(professor_id, null, null));
			}
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
		return c;
	}
	
	public ArrayList<Course> getCourses(){
		ArrayList<Course> courses = new ArrayList<Course>();
		Statement s = null;
		String sql = "select * from Course";
		
		try{
			s = dbConnection.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()){
				int course_id = res.getInt("course_id");
				int professor_id = res.getInt("professor_id");
				String course_name = res.getString("course_name");
				Course c = new Course(course_id, course_name, null, new Professor(professor_id, null, null));
				courses.add(c);
			}
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
		return courses;
		
	}
}

