package factorySQL;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

import Models.Student;

public class StudentDAO_JDBC implements StudentDAO {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentDAO_JDBC.class);
	Connection dbConnection;
	public StudentDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}
	@Override
	public void addStudent(Student s)
	{
		int student_id = s.getStudent_id();
		String student_name = s.getStudent_name();
		HashMap<Integer,Double> student_marks = s.getMarks();
		PreparedStatement preparedStatement=null;
		String sql = "insert into Student(student_id,student_name) values (?,?);";
		try {
			preparedStatement = (PreparedStatement) this.dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, student_id);
			preparedStatement.setString(2, student_name);
			preparedStatement.executeUpdate();
			LOG.info("Student Successfully added");
		}
		catch(SQLException e)
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
			PreparedStatement ps = null;
			String query = "insert into Student_Course(student_id,course_id,marks) values (?,?,?);";
			try{
				ps = (PreparedStatement) this.dbConnection.prepareStatement(query);
				ps.setInt(1, student_id);
				ps.setInt(2, course_id);
				ps.setDouble(3, marks);
				ps.executeUpdate();
			}
			catch(SQLException e)
			{
				LOG.error(e.getMessage(),e);
			}
		}
	}
}
