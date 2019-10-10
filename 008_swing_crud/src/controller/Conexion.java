package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
	public Connection conectar() {
		Connection DBConnection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 DBConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wbeducar_java","root","");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return DBConnection;
	}
	
	
	
	

}//cierra class
