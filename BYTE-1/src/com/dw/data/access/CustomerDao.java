package com.dw.data.access;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dw.data.CustomerData;
import com.dw.data.ItemData;
import com.dw.data.SearchCriteria;
import com.dw.utils.DateUtil;

public class CustomerDao extends CommonDao{
	
	public static final String SPACE = "            ";
	private Connection conn = null;
	private PreparedStatement preparedStmt = null;
	public CustomerDao(){
		conn = getConnection();
	}

	
	public Integer saveCustomer(CustomerData customerData){
		//Integer customerId = new Integer(0);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@The RATE PER GRAM IS--------->"+ customerData.getRatePerGram());
		
		int index = 1;
		int customerId = 0;
		//Write the code to save the customer.
		/*StringBuilder createCustomer = new StringBuilder();
		createCustomer.append("INSERT INTO ");
		createCustomer.append("CUSTOMER");
		createCustomer.append("(CUSTOMER_ID, UNIQUE_NUMBER, DATE_OF_PAYMENT, CUSTOMER_NAME, FATHER_NAME, ADDRESS1, ADDRESS2, ADDRESS3, RATE_OF_INTEREST,");
		createCustomer.append(" PRINCIPAL_AMT, OUT_STANDING_AMT, DATE_OF_RECEIPT, AMOUNT_PAID_STATUS)");
		createCustomer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");*/
		StringBuffer createCustomer = new StringBuffer();
		createCustomer.append("INSERT INTO CUSTOMER  ( UNIQUE_NUMBER, Date_Of_Payment , Customer_Name, ");
		createCustomer.append("Father_Name, Address1, Rate_Of_Interest, Principal_Amt, ");
		createCustomer.append("Out_Standing_Amt, Date_Of_Receipt,  Amount_Paid_Status, Rate_Per_Gram ) ");
		createCustomer.append("VALUES ( ?,?,?,?,?,?,?,?,?,?,?);");
		try {
			String uniqueNumber =  String.valueOf(System.currentTimeMillis());
			conn.setAutoCommit(false); // Begin Transaction
			preparedStmt = conn.prepareStatement(createCustomer.toString());
			  preparedStmt.setString (1, uniqueNumber);
			  //populate the current date i.e. system date.
			  Date dt = new Date(System.currentTimeMillis());
			  preparedStmt.setDate(2, dt);
			  preparedStmt.setString(3, customerData.getCustomerName());
			  preparedStmt.setString(4, customerData.getFatherName());
			  preparedStmt.setString(5, customerData.getAddress1());
			  preparedStmt.setDouble(6, Double.parseDouble(customerData.getRateOfInterest()));
			  preparedStmt.setDouble(7, Double.parseDouble(customerData.getPrincipalAmt()));
			  preparedStmt.setDouble(8, Double.parseDouble(customerData.getOutStandingAmt()));
			  preparedStmt.setDate(9, dt);
			  preparedStmt.setString(10, "NP");
			  preparedStmt.setDouble(11, Double.parseDouble(customerData.getRatePerGram()));
			  // execute the preparedstatement
			  preparedStmt.execute();
			  saveItemList(conn, uniqueNumber, customerData.getItemList());
			//customerId = getCustomerId(conn, uniqueNumber);
			//System.out.println("The content of customer id----------->"+ customerId);
			
			//saveItemList(conn, customerId, customerData.getItemList());
			conn.commit(); // End of Transaction
			conn.setAutoCommit(true); 
			customerId = getCustomerId(conn, uniqueNumber);
			updateItem(conn, uniqueNumber, customerId);
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally
		{
			//Close connection and statement
			try {
				preparedStmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return customerId;
		
	}
	
	private void saveItemList(Connection conn, String uniqueStr,  ArrayList<ItemData> itemList) throws SQLException{
		
		int index = 1;	
		//Write the code to save the customer.
		StringBuilder createItem = new StringBuilder();
		createItem.append("INSERT INTO ");
		createItem.append("ITEM ");
		createItem.append("(ITEM_NAME, METAL, WEIGHT, UNIQUE_NUMBER, CUSTOMER_ID) ");
		createItem.append(" VALUES(?,?,?,?,?);");
		System.out.println("The sql query generate---"+ createItem.toString());
		PreparedStatement ps = conn.prepareStatement(createItem.toString());
		
		for(ItemData itemData : itemList){
			ps.setString(index++,itemData.getItemName());
			ps.setString(index++,itemData.getMetal());
			ps.setDouble(index++,Double.parseDouble(itemData.getWeight()));
			ps.setString(index++, uniqueStr);
			ps.setInt(index++, 0);
			//ps.executeUpdate();
			ps.execute();
			index = 1;
		}
		
		
	}
	
	private int getCustomerId(Connection conn, String uniqueNumber) throws SQLException{
		int customerId = 0;
		
		StringBuilder selectCustomer = new StringBuilder();
		selectCustomer.append(" SELECT * FROM CUSTOMER WHERE UNIQUE_NUMBER = ?;");
		PreparedStatement ps = conn.prepareStatement(selectCustomer.toString());
		ps.setString(1, uniqueNumber);
		
		ResultSet resultSet = ps.executeQuery();
		if(resultSet.next()){
			customerId = resultSet.getInt("CUSTOMER_ID");
		}
		ps.close();
		return customerId;
		
	}
	
	private int updateItem(Connection conn, String uniqueNumber, int customerId) throws SQLException{
		
		StringBuilder selectCustomer = new StringBuilder();
		selectCustomer.append(" UPDATE ITEM SET CUSTOMER_ID = ?  WHERE UNIQUE_NUMBER = ?;");
		PreparedStatement ps = conn.prepareStatement(selectCustomer.toString());
		ps.setInt(1, customerId);
		ps.setString(2, uniqueNumber);
		int returnValue = ps.executeUpdate();
		
		ps.close();
		return returnValue;
		
	}
	
	//Begin: Update Customer
	
	public boolean updateCustomer(CustomerData customerData) {
		boolean updated = false;
		
		StringBuffer updateCustomer = new StringBuffer();
		updateCustomer.append("UPDATE CUSTOMER ");
		updateCustomer.append("SET Customer_Name = ?, Father_Name = ?, Address1 = ?, Rate_Of_Interest = ?, Rate_Per_Gram = ? ");
		updateCustomer.append("WHERE CUSTOMER_ID = ?;");
		//wesdgfsd
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(updateCustomer.toString());
			ps.setString(1, customerData.getCustomerName());
			ps.setString(2, customerData.getFatherName());
			ps.setString(3, customerData.getAddress1());
			ps.setDouble(4, Double.parseDouble(customerData.getRateOfInterest()));
			ps.setInt(5, Integer.parseInt(customerData.getCustomerId()));
			ps.setDouble(6, Double.parseDouble(customerData.getRatePerGram()));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			//Close connection and statement
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return updated;
		
	}
	//End of Update Customer
	
	//Begin: Search Customer
	public ArrayList<CustomerData> searchCustomer( SearchCriteria searchCriteria) {
		ArrayList<CustomerData> customersList = new ArrayList<CustomerData>();
		//ArrayList<CustomerData> customersListBasedOnName = new ArrayList<CustomerData>();
		//List totalList = new ArrayList();
		//searchCriteria.setCustomerId(null); //added this line to verify the Search based on Customer Name
		if(null != searchCriteria){
			try{
				if(!SPACE.equals(searchCriteria.getCustomerId())){
					customersList = getCustomersList(searchCriteria.getCustomerId().trim(), null, conn);
				} else if(!SPACE.equals( searchCriteria.getCustomerName())){
					customersList = getCustomersList(null, searchCriteria.getCustomerName(), conn);
				} else {
					return customersList;
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
			finally
			{
				//Close connection and statement
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return customersList;
		
	}
	
	public ArrayList<CustomerData> getCustomersList(String id, String name, Connection conn) throws SQLException{
		
		ArrayList<CustomerData> customerList = new ArrayList<CustomerData>();
		StringBuilder searchCustomer = new StringBuilder();
		PreparedStatement ps = null;
		if(null != id){
			searchCustomer.append(" SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?;");
			ps = conn.prepareStatement(searchCustomer.toString());
			ps.setInt(1, Integer.parseInt(id));
		} else if(null != name){
			searchCustomer.append(" SELECT * FROM CUSTOMER WHERE CUSTOMER_NAME LIKE ?;");
			ps = conn.prepareStatement(searchCustomer.toString());
			ps.setString(1, name+"%");			
		} else {
			return customerList;
		}
		
		ResultSet resultSet = ps.executeQuery();
		while(resultSet.next()){
			CustomerData customerData = new CustomerData();
			customerData.setCustomerId(String.valueOf(resultSet.getInt("CUSTOMER_ID")));
			
			customerData.setDateOfPayment(resultSet.getDate("DATE_OF_PAYMENT").toString());
			
			customerData.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
			/*customerData.setFatherName(resultSet.getString("FATHER_NAME"));
			customerData.setAddress1(resultSet.getString("ADDRESS1"));
			customerData.setRateOfInterest(resultSet.getString("RATE_OF_INTEREST"));
			customerData.setPrincipalAmt(resultSet.getString("PRINCIPAL_AMT"));
			customerData.setOutStandingAmt(resultSet.getString("OUT_STANDING_AMT"));
			
			customerData.setDateOfReceipt(resultSet.getString("DATE_OF_RECEIPT"));
			
			customerData.setAmountPaidStatus(resultSet.getString("AMOUNT_PAID_STATUS"));
			customerData.setItemList(getItemList(customerData.getCustomerId(), conn));*/
			
			customerList.add(customerData);
			
		}
		ps.close();
		
		return customerList;
	}
	
	private ArrayList<ItemData> getItemList(String customerId, Connection conn) throws SQLException{
		
		ArrayList<ItemData> itemList = new ArrayList<ItemData>();
		
		StringBuilder getItems = new StringBuilder();
		if(null != customerId){
			getItems.append(" SELECT * FROM ITEM WHERE CUSTOMER_ID = ?");
			PreparedStatement ps = conn.prepareStatement(getItems.toString());
			ps.setInt(1, Integer.parseInt(customerId));
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()){
				ItemData itemData = new ItemData();
				
				itemData.setItemId(String.valueOf(resultSet.getInt("ITEM_ID")));
				
				itemData.setItemName(resultSet.getString("ITEM_NAME"));
				
				itemData.setMetal(resultSet.getString("METAL"));
				itemData.setWeight(resultSet.getString("WEIGHT"));
				/*itemData.setQuantity(resultSet.getString("QUANTITY"));
				itemData.setItemPa(resultSet.getString("PRINCIPAL_AMT"));
				itemData.setCustomerId("CUSTOMER_ID");*/
				
				itemList.add(itemData);
			}
		}
		
		return itemList;
		
		
	}
	
	
	public CustomerData getCustomerDetails(String id) {
		
		CustomerData customerData = new CustomerData();
		StringBuilder searchCustomer = new StringBuilder();
		PreparedStatement ps = null;
		try{
		if(null != id){
			searchCustomer.append(" SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?;");
			ps = conn.prepareStatement(searchCustomer.toString());
			ps.setInt(1, Integer.parseInt(id));
		} else {
			return customerData;
		}
		
		ResultSet resultSet = ps.executeQuery();
		if(resultSet.next()){
			
			customerData.setCustomerId(String.valueOf(resultSet.getInt("CUSTOMER_ID")));
			
			customerData.setDateOfPayment(resultSet.getDate("DATE_OF_PAYMENT").toString());
			
			customerData.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
			customerData.setFatherName(resultSet.getString("FATHER_NAME"));
			customerData.setAddress1(resultSet.getString("ADDRESS1"));
			customerData.setRateOfInterest(resultSet.getString("RATE_OF_INTEREST"));
			customerData.setPrincipalAmt(resultSet.getString("PRINCIPAL_AMT"));
			customerData.setOutStandingAmt(resultSet.getString("OUT_STANDING_AMT"));
			
			customerData.setDateOfReceipt(resultSet.getString("DATE_OF_RECEIPT"));
			
			customerData.setAmountPaidStatus(resultSet.getString("AMOUNT_PAID_STATUS"));
			customerData.setRatePerGram(resultSet.getString("Rate_Per_Gram"));
			customerData.setItemList(getItemList(customerData.getCustomerId(), conn));
			
		}
		//ps.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			//Close connection and statement
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customerData;
	}
	
	//End: Search Customer
	
	
	


}
