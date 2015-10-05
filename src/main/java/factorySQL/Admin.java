package factorySQL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import factorySQL.DAO_Factory.TXN_STATUS;
import Models.Course;
import Models.Professor;
import Models.Student;

public class Admin {

	private static final Logger LOG = LoggerFactory.getLogger(Admin.class);
	public static DAO_Factory dao;
	public Admin(DAO_Factory dao)
	{
		this.dao = dao;
	}
	public void addStudent(Student s)
	{
		
		try{
			this.dao.activateConnection();
			StudentDAO sdao = dao.getStudentDAO();
			sdao.addStudent(s);
			this.dao.deactivateConnection(TXN_STATUS.COMMIT);
		}
		catch(Exception e)
		{
			this.dao.deactivateConnection(TXN_STATUS.ROLLBACK);
			LOG.error(e.getMessage(),e);
			
		}
	}
	public void addProfessor(Professor p)
	{
		try{
			this.dao.activateConnection();
			ProfessorDAO pdao = dao.getProfessorDAO();
			pdao.addProfessor(p);
			this.dao.deactivateConnection(TXN_STATUS.COMMIT);
		}
		catch(Exception e)
		{
			this.dao.deactivateConnection(TXN_STATUS.ROLLBACK);
			LOG.error(e.getMessage(),e);
			
		}
	}
	public void addCourse(Course c)
	{
		try{
			this.dao.activateConnection();
			CourseDAO cdao = dao.getCourseDAO();
			cdao.addCourse(c);
			this.dao.deactivateConnection(TXN_STATUS.COMMIT);
		}
		catch(Exception e)
		{
			this.dao.deactivateConnection(TXN_STATUS.ROLLBACK);
			LOG.error(e.getMessage(),e);
			
		}
		
	}
}
