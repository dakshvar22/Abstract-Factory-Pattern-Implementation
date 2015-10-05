package factorySQL;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import factorySQL.DAO_Factory.TXN_STATUS;
import Models.Course;

public abstract class User {

	protected static final Logger LOG = LoggerFactory.getLogger(AdminUser.class);
	protected static DAO_Factory dao;
	
	public ArrayList<Course> getCourses(){
		ArrayList<Course> courses = new ArrayList<Course>();
		try{
			this.dao.activateConnection();
					
			CourseDAO cdao = this.dao.getCourseDAO();
			ProfessorDAO pdao = this.dao.getProfessorDAO();
			courses = cdao.getCourses();
			
			for (int i=0;i<courses.size();i++){
				courses.get(i).setProf(pdao.getProfessorById(courses.get(i).getProf().getProfessor_id()));
			}
			//for (Course c: courses){
			//	c.setProf(pdao.getProfessorById(c.getProf().getProfessor_id()));
			//}
			this.dao.deactivateConnection(TXN_STATUS.COMMIT);
			//System.out.println("connection status after deactivate " + this.dao.dbconnection.isClosed());
		}
		catch(Exception e)
		{
			this.dao.deactivateConnection(TXN_STATUS.ROLLBACK);
			LOG.error(e.getMessage(),e);
			
		}
		return courses;
	}
}