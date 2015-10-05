package factorySQL;

import java.sql.*;

public class DAO_Factory {
	
	public static enum TXN_STATUS { COMMIT, ROLLBACK };
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/dpAssign";
	//public static final String dbName = "dpAssign";
	public static final String USER = "root";
<<<<<<< HEAD
	public static final String PASS = "123";
=======
	public static final String PASS = "test";
>>>>>>> 1a24087d3cef890b63254ac8e7c98053367a08de
	Connection dbconnection = null;
	
	StudentDAO sdao = null;
	ProfessorDAO pdao = null;
	CourseDAO cdao = null;
	boolean activeConnection = false;

	public DAO_Factory()
	{
		dbconnection = null;
		activeConnection = false;
	}

	public void activateConnection() throws Exception
	{
		if( activeConnection == true )
			throw new Exception("Connection already active");

		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbconnection = DriverManager.getConnection(DB_URL,USER,PASS);
			activeConnection = true;
			dbconnection.setAutoCommit(false);
		} catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public StudentDAO getStudentDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( sdao == null )
			sdao = new StudentDAO_JDBC(dbconnection);

		return sdao;
	}
	public ProfessorDAO getProfessorDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( pdao == null )
			pdao = new ProfessorDAO_JDBC(dbconnection);

		return pdao;
	}
	public CourseDAO getCourseDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( cdao == null )
			cdao = new CourseDAO_JDBC(dbconnection);

		return cdao;
	}
	
	public void deactivateConnection(TXN_STATUS txn_status)
	{
		// Okay to keep deactivating an already deactivated connection
		activeConnection = false;
		if( dbconnection != null ){
			try{
				if( txn_status == TXN_STATUS.COMMIT)
				{
					dbconnection.commit();
				}
				else
				{
					dbconnection.rollback();
				}
				dbconnection.close();
				dbconnection = null;
<<<<<<< HEAD
				sdao = null;
				pdao = null;
				cdao = null;
=======
<<<<<<< HEAD
				sdao = null;
				pdao = null;
				cdao = null;
=======
>>>>>>> 1a24087d3cef890b63254ac8e7c98053367a08de
>>>>>>> e21f87ec7124933c407d7c93d66b3ebe020f5e7b

			}
			catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
	
	

}
