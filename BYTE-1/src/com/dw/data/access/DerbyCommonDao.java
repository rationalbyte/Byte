package com.dw.data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyCommonDao {
	
	//conn = DriverManager.getConnection(protocol + "TESTING_001;create=true");
// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//static final String DB_URL = "jdbc:mysql://localhost/EMP";
static final String DB_URL = "jdbc:mysql://localhost:3306/MYTEST002";

//  Database credentials
static final String USER = "test002";
static final String PASS = "test002";
public static Connection conn = null;
   
public Connection getConnection(){
	//public Connection conn = null;
	String protocal = "jdbc:derby:";
	String path = "/PROJECTS/SOFTWARES/db-derby-10.12.1.1-bin/bin/TESTING_001;";
	String operation = "create=true";
    try {
    	if(null != conn){
    		return conn;
    	}else{
    		conn = DriverManager.getConnection(protocal + path + operation);
    	}
    	System.out.println("Connection to Database Established");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println("Failed to Establish Connection to Database");
		e1.printStackTrace();
	}
   
   return conn;

}


}
