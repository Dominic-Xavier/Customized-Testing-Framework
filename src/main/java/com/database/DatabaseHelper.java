package com.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseHelper {
	
	private Properties properties;
	private FileReader fileReader;
	private Connection con;
	private Statement createStatement;
	private DatabaseHelper helper;
	
	private DatabaseHelper() {
	}
	
	public synchronized DatabaseHelper getDatabaseHelper() {
		if(helper==null) 
			helper = new DatabaseHelper();
		return helper;
	}
	
	private Properties readProperties() throws IOException {
		fileReader = new FileReader("./src/main/resources/database.properties");
		properties = new Properties();
		properties.load(fileReader);
		return properties;
	}
	
	private void connectToDatabase() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Properties readProperties = readProperties();
		String host = readProperties.getProperty("host");
		String user = readProperties.getProperty("user");
		String password = readProperties.getProperty("password");
		String dbname = readProperties.getProperty("dbname");
		String portnumber = readProperties.getProperty("portnumber");
		
		con = DriverManager.getConnection("jdbc:mysql://"+host+":"+portnumber+"/"+dbname+","+user+","+password);
		createStatement = con.createStatement();
	}
}
