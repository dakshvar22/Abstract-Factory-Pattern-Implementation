package factorySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Models.Course;
import Models.Professor;


public class ProfessorDAO_JDBC implements ProfessorDAO{
	public static final Logger LOG = LoggerFactory.getLogger(ProfessorDAO_JDBC.class);
	Connection dbConnection;

	public ProfessorDAO_JDBC(Connection dbConnection) {
		super();
		this.dbConnection = dbConnection;
	}
	
	public void addProfessor(Professor prof) {
		
		PreparedStatement preparedStatement = null;
		String sql = "insert into Professor(professor_id, professor_name) values (?,?)";
		try{
			preparedStatement = dbConnection.prepareStatement(sql);
			
			preparedStatement.setInt(1, prof.getProfessor_id());
			preparedStatement.setString(2, prof.getProfessor_name());
			
			preparedStatement.executeUpdate();
			
			LOG.info("Professor" + prof.getProfessor_name() + " has been added successfully!");
			
		}catch(SQLException e) {
			LOG.error(e.getMessage(),e);
		}
		
		try{
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}catch(SQLException e) {
				LOG.error(e.getMessage(),e);
			}
	}
	
	public Professor getProfessorById(int prof_id){
		Statement s = null;
		String sql = "select * from Professor where professor_id = "+prof_id;
		Professor p = null;
		try{
			s = dbConnection.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()){
				String prof_name = res.getString("professor_name");
				p = new Professor(prof_id, prof_name, null);
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
		return p;
	}

}
