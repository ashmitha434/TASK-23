package SQLProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQLExample {
    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    	// JDBC URL, username, and password of MySQL server
    	Connection con = null;
       String url = "jdbc:mysql://localhost:3306/sakila";
    // String driver = "com.mysql.cj.jdbc.Driver";
       String user = "root";
      String password = "Dhiva@123";
       //String password = "$> mysql --default-auth=mysql_native_password ...";
    

      try {
          Connection connection = DriverManager.getConnection(url, user, password);
          Statement statement = connection.createStatement();

          // A. Employees with salary >= 2200
          String queryA = "SELECT ename, sal FROM Empl WHERE sal >= 2200";
          ResultSet rsA = statement.executeQuery(queryA);
          System.out.println("Employees with salary >= 2200:");
          while (rsA.next()) {
              System.out.println("Name: " + rsA.getString("ename") + ", Salary: " + rsA.getDouble("sal"));
          }

          // B. Employees not getting commission
          String queryB = "SELECT * FROM Empl WHERE comm IS NULL";
          ResultSet rsB = statement.executeQuery(queryB);
          System.out.println("\nEmployees not getting commission:");
          while (rsB.next()) {
              System.out.println("Name: " + rsB.getString("ename"));
          }

          // C. Employees whose salary is not in the range of 2500 to 4000
          String queryC = "SELECT ename, sal FROM Empl WHERE sal < 2500 OR sal > 4000";
          ResultSet rsC = statement.executeQuery(queryC);
          System.out.println("\nEmployees with salary not in the range of 2500 to 4000:");
          while (rsC.next()) {
              System.out.println("Name: " + rsC.getString("ename") + ", Salary: " + rsC.getDouble("sal"));
          }

          // D. Employees without a manager
          String queryD = "SELECT ename, job, sal FROM Empl WHERE mgr IS NULL";
          ResultSet rsD = statement.executeQuery(queryD);
          System.out.println("\nEmployees without a manager:");
          while (rsD.next()) {
              System.out.println("Name: " + rsD.getString("ename") + ", Job: " + rsD.getString("job") + ", Salary: " + rsD.getDouble("sal"));
          }

          // E. Employees whose name contains 'A' as the third alphabet
          String queryE = "SELECT ename FROM Empl WHERE SUBSTRING(ename, 3, 1) = 'A'";
          ResultSet rsE = statement.executeQuery(queryE);
          System.out.println("\nEmployees whose name contains 'A' as the third alphabet:");
          while (rsE.next()) {
              System.out.println("Name: " + rsE.getString("ename"));
          }

          // F. Employees whose name contains 'T' as the last alphabet
          String queryF = "SELECT ename FROM Empl WHERE ename LIKE '%T'";
          ResultSet rsF = statement.executeQuery(queryF);
          System.out.println("\nEmployees whose name contains 'T' as the last alphabet:");
          while (rsF.next()) {
              System.out.println("Name: " + rsF.getString("ename"));
          }

          // Close the connection
          connection.close();

      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
