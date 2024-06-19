package SQLProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sql {
	public static void main(String[]args) throws SQLException {
	   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:127.0.0.1:3306/employee","root", "Dhiva@123");

	   if(connection.isClosed()) {
		   System.out.println("We have not connected to the database");
		   
	   }else {
		   System.out.println("We have successfully connected to the database");
		   
	   }
	   
}
}