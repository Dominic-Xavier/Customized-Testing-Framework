package testSteps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.Baseclass.WebTestBase;
import com.database.DatabaseHelper;

public class A extends WebTestBase{
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		String query = dp.getQuery("sample Name");
		DatabaseHelper helper = DatabaseHelper.getDatabaseHelper();
		String readData = helper.readData(query, "EMP_NAME");
		System.out.println(readData);
		
		/*String dbName = "EMPLOYEE";
		String dbUserName = "root";
		String dbPassword = "insert_password";
		String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
		Connection connection = DriverManager.getConnection(connectionString);
		Statement createStatement = connection.createStatement();*/
		
		
	}
}
