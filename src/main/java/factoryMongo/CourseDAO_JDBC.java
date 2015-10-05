package factoryMongo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClientException;

import Models.Course;

public class CourseDAO_JDBC implements CourseDAO{
	private static final Logger LOG = LoggerFactory.getLogger(CourseDAO_JDBC.class);
	//Connection dbconnection;
	DB db;
	public CourseDAO_JDBC(DB db) {
		//this.dbconnection = dbconnection;
		this.db = db;
	}
	public void addCourse(Course course){
		DBCollection coll = this.db.getCollection("Course");
		BasicDBObject obj= null;
		int course_id = course.getCourse_id();
		String course_name = course.getCourse_name();
		int prof_id = course.getProf().getProfessor_id();
		//String sql = "insert into Course(course_id, professor_id, course_name) values(?,?,?)";
		//PreparedStatement s = null;
		try{
//			s = dbconnection.prepareStatement(sql);
//			s.setInt(1, course_id);
//			s.setInt(2, prof_id);
//			s.setString(3, course_name);
//			s.executeUpdate();
			
			obj = new BasicDBObject();
			obj.append("course_id", course_id);
			obj.append("professor_id", prof_id);
			obj.append("course_name", course_name);
			coll.insert(obj);
			LOG.info("Course "+course_name+" has been added");
		}
		catch(MongoClientException e) {
			LOG.error(e.getMessage(),e);
		}
		
		try{
			if (obj != null) {
				obj.clear();
			}
		}catch(MongoClientException e) {
			LOG.error(e.getMessage(),e);
		}
	}
}
