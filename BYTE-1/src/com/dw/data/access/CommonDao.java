package com.dw.data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommonDao {
	
	/*connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/MYTEST002","test002", "test002");*/
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	//static final String DB_URL = "jdbc:mysql://localhost/EMP";
	static final String DB_URL = "jdbc:mysql://localhost:3306/MYTEST002";
	
	//  Database credentials
	static final String USER = "test002";
	static final String PASS = "test002";
		   
	public Connection getConnection(){
		   Connection conn = null;
		   try{
		      //Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
		   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
		   }
		   
		   return conn;
		
	}

}
