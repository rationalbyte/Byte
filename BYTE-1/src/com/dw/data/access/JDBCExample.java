package com.dw.data.access;

import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;

 
public class JDBCExample {
 
  public static void main(String[] argv) {
	  
	  Statement statement = null;
	  PreparedStatement preparedStatement = null;
	  ResultSet resultSet = null;
 
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}
 
	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;
 
	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/MYTEST002","test002", "test002");
 
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
		// Statements allow to issue SQL queries to the database
		try{
	      statement = connection.createStatement();
	      // Result set get the result of the SQL query
	      resultSet = statement
	          .executeQuery("select * from pet");
	      while (resultSet.next()) {
	          // It is possible to get the columns via name
	          // also possible to get the columns via the column number
	          // which starts at 1
	          // e.g. resultSet.getSTring(2);
	          String name = resultSet.getString("name");
	          String owner = resultSet.getString("owner");
	          String species = resultSet.getString("species");
	          String sex = resultSet.getString("sex");
	          //Date date = resultSet.getDate("birth");
	          String birth = resultSet.getString("birth");
	          String death = resultSet.getString("death");
	          System.out.println("Name: 		" + name);
	          System.out.println("Owner:		" + owner);
	          System.out.println("Species:		" + species);
	          System.out.println("Sex: 			" + sex);
	          System.out.println("Birth Date: 	" + birth);
	          System.out.println("Death: 		" + death);
	     }
	      
	      /////////// Customer Test
	      String uniqueNumber =  String.valueOf(System.currentTimeMillis());
	      System.out.println("The content of unique number: "+ uniqueNumber);
	      String address = "1/473, 7th Corss Street, Sri Sai Nagar, Thoraipakkam, Chennai-97";
	      StringBuffer query = new StringBuffer();
	      query.append("INSERT INTO CUSTOMER  ( UNIQUE_NUMBER, Date_Of_Payment , Customer_Name, ");
	      query.append("Father_Name, Address1, Rate_Of_Interest, Principal_Amt, ");
	      query.append("Out_Standing_Amt, Date_Of_Receipt,  Amount_Paid_Status)");
	      query.append("VALUES ( ?,?,?,?,?,?,?,?,?,?);");
	      
	    	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = connection.prepareStatement(query.toString());
	      preparedStmt.setString (1, uniqueNumber);
	      preparedStmt.setDate(2, new Date(2015, 05, 10));
	      preparedStmt.setString(3, "Balaji001");
	      preparedStmt.setString(4, "Venkateswara Rao001");
	      preparedStmt.setString(5, address);
	      preparedStmt.setDouble(6, 7.8);
	      preparedStmt.setDouble(7, 5478.36);
	      preparedStmt.setDouble(8, 8278.51);
	      preparedStmt.setDate(9, new Date(2015, 05, 10));
	      preparedStmt.setString(10, "NP");
	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      ////////////Customer Test
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}
