package factoryMongo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClientException;

import java.sql.*;

import Models.Student;

public class StudentDAO_JDBC implements StudentDAO {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentDAO_JDBC.class);
	//Connection dbConnection;
	DB db;
	public StudentDAO_JDBC(DB db){
		// JDBC driver name and database URL
 		//  Database credentials
		//dbConnection = dbconn;
		this.db = db;
	}
	@Override
	public void addStudent(Student s)
	{
		DBCollection coll = this.db.getCollection("Student");
		DBCollection marksColl = this.db.getCollection("Student_Course");
		BasicDBObject obj= null;
		int student_id = s.getStudent_id();
		String student_name = s.getStudent_name();
		HashMap<Integer,Double> student_marks = s.getMarks();
		//PreparedStatement preparedStatement=null;
		//String sql = "insert into Student(student_id,student_name) values (?,?);";
		try {
//			preparedStatement = (PreparedStatement) this.dbConnection.prepareStatement(sql);
//			preparedStatement.setInt(1, student_id);
//			preparedStatement.setString(2, student_name);
//			preparedStatement.executeUpdate();
			obj = new BasicDBObject();
			obj.append("student_id", student_id);
			obj.append("student_name", student_name);
			coll.insert(obj);
			LOG.info("Student Successfully added");
		}
		catch(MongoClientException e)
		{
			LOG.error(e.getMessage(),e);
			//throw e;
		}
		for(Map.Entry<Integer, Double> key: student_marks.entrySet())
		{
			System.out.println(key.getKey());
			System.out.println(key.getValue());
			int course_id = key.getKey();
			//double marks = Double.parseDouble(student_marks.get(key).toString());
			double marks = key.getValue();
			//PreparedStatement ps = null;
			//String query = "insert into Student_Course(student_id,course_id,marks) values (?,?,?);";
			try{
//				ps = (PreparedStatement) this.dbConnection.prepareStatement(query);
//				ps.setInt(1, student_id);
//				ps.setInt(2, course_id);
//				ps.setDouble(3, marks);
//				ps.executeUpdate();
				obj = new BasicDBObject();
				obj.append("student_id", student_id);
				obj.append("course_id", course_id);
				obj.append("marks", marks);
				marksColl.insert(obj);
			}
			catch(MongoClientException e)
			{
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
}
