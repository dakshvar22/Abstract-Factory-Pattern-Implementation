package factoryMongo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClientException;

import Models.Professor;


public class ProfessorDAO_JDBC implements ProfessorDAO{
	public static final Logger LOG = LoggerFactory.getLogger(ProfessorDAO_JDBC.class);
	//Connection dbConnection;
	DB db;
	public ProfessorDAO_JDBC(DB db) {
		super();
		this.db = db;
	}
	
	public void addProfessor(Professor prof) {
		
		DBCollection coll = this.db.getCollection("Professor");
		//PreparedStatement preparedStatement = null;
		BasicDBObject obj= null;
		//String sql = "insert into Professor(professor_id, professor_name) values (?,?)";
		try{
			obj = new BasicDBObject();
			obj.append("professor_id",prof.getProfessor_id());
			obj.append("professor_name", prof.getProfessor_name());
			/*preparedStatement = dbConnection.prepareStatement(sql);
			
			preparedStatement.setInt(1, prof.getProfessor_id());
			preparedStatement.setString(2, prof.getProfessor_name());
			
			preparedStatement.executeUpdate();
			*/
			coll.insert(obj);
			LOG.info("Professor" + prof.getProfessor_name() + " has been added successfully!");
			
		}catch(MongoClientException e) {
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
