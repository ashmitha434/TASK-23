package SQLProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EmployeeDataInsertion {
	 public static void main(String[] args) {
		      String url = "jdbc:mysql://localhost:3306/sakila";
		      String user = "root";
		      String password = "Dhiva@123";

	        String createTableSQL = "CREATE TABLE IF NOT EXISTS Empl (" +
	                "empno INT PRIMARY KEY, " +
	                "ename VARCHAR(50), " +
	                "job VARCHAR(50), " +
	                "mgr INT, " +
	                "hiredate DATE, " +
	                "sal DECIMAL(10, 2), " +
	                "comm DECIMAL(10, 2), " +
	                "deptno INT)";

	        String insertDataSQL = "INSERT INTO Empl (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             Statement statement = connection.createStatement()) {

	            // Create the table if it doesn't exist
	            statement.execute(createTableSQL);

	            // Insert the data
	            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
	                // Data to be inserted
	                Object[][] employees = {
	                        {101, "Jenny", "Clerk", null, "1990-12-18", 10000.00, null, 20},
	                        {102, "Jacky", "Salesman", null, "1991-02-20", 20000.00, 300.00, 30},
	                        {103, "Joe", "Salesman", null, "1991-02-22", 40000.00, 500.00, 30},
	                        {104, "John", "Manager", null, "1991-04-02", 80000.00, null, 20},
	                        {105, "Shameer", "Manager", null, "1991-09-28", 90000.00, null, 30}
	                };

	                for (Object[] employee : employees) {
	                    preparedStatement.setInt(1, (int) employee[0]);
	                    preparedStatement.setString(2, (String) employee[1]);
	                    preparedStatement.setString(3, (String) employee[2]);
	                    preparedStatement.setObject(4, employee[3]);
	                    preparedStatement.setDate(5, java.sql.Date.valueOf((String) employee[4]));
	                    preparedStatement.setDouble(6, (double) employee[5]);
	                    preparedStatement.setObject(7, employee[6]);
	                    preparedStatement.setInt(8, (int) employee[7]);
	                    preparedStatement.executeUpdate();
	                }

	                System.out.println("Data inserted successfully");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
