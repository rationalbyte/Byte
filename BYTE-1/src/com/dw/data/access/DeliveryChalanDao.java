package com.dw.data.access;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dw.data.CustomerData;
import com.dw.data.ItemData;
import com.pb.common.DataUtil;
import com.pb.common.utils.DateUtils;
import com.pb.data.model.DeliveryChalanTO;
import com.pb.data.model.DeliveryItem;
import com.pb.data.model.Invoice1;

public class DeliveryChalanDao extends DerbyCommonDao{
	
	public Integer saveDeliveryChallan(DeliveryChalanTO deliveryChalanTO){
		
		Connection conn = getConnection();
		PreparedStatement dcInsert = null;
        Statement s = null;
        ResultSet rs = null;
        
		Integer ourDcNumber = null;
		
    	try {
    		conn.setAutoCommit(false);
    		ourDcNumber = getDCNextSequenceNumber(conn, s, rs);
    		dcInsert = conn.prepareStatement(
                    "INSERT INTO DELIVERY_CHALLAN VALUES (?, ?, ?, ?, ?, ?, ?)");
			dcInsert.setInt(1, ourDcNumber);
			dcInsert.setDate(2, DateUtils.stringToSqlDate(deliveryChalanTO.getDate()));
			dcInsert.setInt(3, Integer.parseInt(deliveryChalanTO.getOrderNo()));
			dcInsert.setDate(4, DateUtils.stringToSqlDate(deliveryChalanTO.getOrderDate()));
			dcInsert.setString(5, deliveryChalanTO.getCompanyName());
			dcInsert.setString(6, deliveryChalanTO.getMs());
			dcInsert.setString(7, deliveryChalanTO.getDcStatus());
			dcInsert.executeUpdate();
			System.out.println("DATA INSERTED INTO DELIVERY_CHALLAN TABLE");
			saveDeliveryItemList(conn, ourDcNumber, deliveryChalanTO.getDeliveryItemsList());
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		finally
		{
			//Close connection and statement
			try {
				dcInsert.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ourDcNumber;
		
	}
	
	private void saveDeliveryItemList(Connection conn, Integer ourDcNumber,  List<DeliveryItem> deliveryItemsList) throws SQLException{

		int index = 1;	
		//Create DeliveryItems List.
		StringBuilder createDeliveryItem = new StringBuilder();
		createDeliveryItem.append("INSERT INTO ");
		createDeliveryItem.append("DELIVERY_ITEM ");
		createDeliveryItem.append("(SERIAL_NO, DESCRIPTION, QUANTITY, PER, RATE, REMARKS, OUR_DC_NO) ");
		createDeliveryItem.append("VALUES(?,?,?,?,?,?,?)");
		System.out.println("The sql query generate---"+ createDeliveryItem.toString());
		PreparedStatement ps = conn.prepareStatement(createDeliveryItem.toString());
		
		for(DeliveryItem deliveryItemData : deliveryItemsList){
			ps.setString(index++,deliveryItemData.getSerialNo());
			ps.setString(index++,deliveryItemData.getDescription());
			ps.setInt(index++,Integer.parseInt(deliveryItemData.getQuantity()));
			ps.setString(index++, deliveryItemData.getPer());
			ps.setDouble(index++, Double.parseDouble(deliveryItemData.getRate()));
			ps.setString(index++, deliveryItemData.getRemarks());
			ps.setInt(index++, ourDcNumber);
			ps.executeUpdate();
			//ps.execute();
			index = 1;
		}
		
		ps.close();
	}
	
	private Integer getDCNextSequenceNumber (Connection connection, Statement statement, ResultSet rs)throws SQLException  {
		Integer nextSequenceNumber = null;
		//Execute the Query to get the Next_Seq_Number from DELIVERY_CHALLAN_SEQUENCE
		statement = connection.createStatement();
	    rs = statement.executeQuery(
            "VALUES (NEXT VALUE FOR SEQ_OUR_DC_NO)");
        if(rs.next()) {
            // do something with the result set
        	System.out.println("THE NEXT SEQUENCE OF OUR_DC_NO IS==>"+ rs.getInt(1));
        	nextSequenceNumber = rs.getInt(1);
       	
        }
		return nextSequenceNumber;
	}
	
	public List<DeliveryChalanTO> getDeliveryChallans(String companyName){
		Connection conn = getConnection();
		List<DeliveryChalanTO> deliveryChallanList = new ArrayList<DeliveryChalanTO>();
		StringBuffer searchQuery = new StringBuffer();
		searchQuery.append("SELECT * FROM DELIVERY_CHALLAN WHERE DC_STATUS = 'A'");// = "SELECT * FROM DELIVERY_CHALLAN WHERE COMPANY_NAME" = ?";
		if(null != companyName && !companyName.isEmpty()){
			searchQuery.append("AND COMPANY_NAME = ?");
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(searchQuery.toString());
			if(null != companyName && !companyName.isEmpty()){
				preparedStatement.setString(1, companyName);
			}
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeliveryChalanTO dc = new DeliveryChalanTO();
				dc.setNo(rs.getString("OUR_DC_NO"));
				dc.setDate(DateUtils.sqlDateString(rs.getDate("OUR_DC_DATE")));
				dc.setOrderNo(rs.getString("YOUR_ORDER_NUMBER"));
				dc.setOrderDate(DateUtils.sqlDateString(rs.getDate("YOUR_ORDER_DATE")));
				dc.setCompanyName(rs.getString("COMPANY_NAME"));
				System.out.println("DCNumber= "+dc.getNo()+" DCDate= "+dc.getDate()+" OrderNumber="+dc.getOrderNo());
				
				
				deliveryChallanList.add(dc);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//Close connection and statement
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return deliveryChallanList;
	}
	
	public List<DeliveryChalanTO> getDeliveryChallansByDcIds(String dcIds){
		Connection conn = getConnection();
		List<DeliveryChalanTO> deliveryChallanList = new ArrayList<DeliveryChalanTO>();
		StringBuffer searchQuery = new StringBuffer();
		searchQuery.append("SELECT * FROM DELIVERY_CHALLAN WHERE OUR_DC_NO IN (?) ORDER BY OUR_DC_NO ");
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(searchQuery.toString());
			preparedStatement.setString(1, dcIds);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeliveryChalanTO dc = new DeliveryChalanTO();
				dc.setNo(rs.getString("OUR_DC_NO"));
				dc.setDate(DateUtils.sqlDateString(rs.getDate("OUR_DC_DATE")));
				dc.setOrderNo(rs.getString("YOUR_ORDER_NUMBER"));
				dc.setOrderDate(DateUtils.sqlDateString(rs.getDate("YOUR_ORDER_DATE")));
				dc.setCompanyName(rs.getString("COMPANY_NAME"));
				System.out.println("DCNumber= "+dc.getNo()+" DCDate= "+dc.getDate()+" OrderNumber="+dc.getOrderNo());
				
				deliveryChallanList.add(dc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deliveryChallanList;
	}
	
	public List<DeliveryItem> getDeliveryItemsByDcIds(Invoice1 invoice, String dcIds) {
		Connection conn = getConnection();
		Double total = 0d;
		List<DeliveryItem> deliveryItemList = new ArrayList<DeliveryItem>();
		StringBuffer searchQuery = new StringBuffer();
		searchQuery.append("SELECT * FROM DELIVERY_ITEM WHERE OUR_DC_NO IN (?) ORDER BY OUR_DC_NO ");
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(searchQuery.toString());
			preparedStatement.setString(1, dcIds);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DeliveryItem di = new DeliveryItem();
				di.setSerialNo(String.valueOf(rs.getInt("SERIAL_NO")));
				di.setOurDcNo(String.valueOf(rs.getInt("OUR_DC_NO")));
				di.setDescription(rs.getString("DESCRIPTION"));
				Integer quantity = rs.getInt("SERIAL_NO");
				di.setQuantity(String.valueOf(quantity));
				di.setPer(rs.getString("PER"));
				Double rate = rs.getDouble("RATE");
				di.setRate(String.valueOf(rate));
				Double amount = rate * quantity;
				di.setAmountInRupees(String.valueOf(amount));
				total = total + amount;
				deliveryItemList.add(di);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		populateTaxAndTotal(invoice, total);
		return deliveryItemList;		
	}
	
	private void populateTaxAndTotal(Invoice1 invoice, Double total){
		String taxPercentage = invoice.getServiceTaxPercentage();
		Double tax = (Double.parseDouble(taxPercentage) * total)/100;
		invoice.setTax(String.valueOf(tax));
		Double totalAfterTax = total + tax;
		invoice.setTotal(String.valueOf(totalAfterTax));
	}
	
	public static void main(String args[]){
		DeliveryChalanTO deliveryChalanTO = new DeliveryChalanTO();
		List<DeliveryItem> deliveryItemsList = new ArrayList<>();
		deliveryChalanTO.setDate("8-10-2016");
		deliveryChalanTO.setOrderNo("74123");
		deliveryChalanTO.setOrderDate("2-10-2016");
		deliveryChalanTO.setMs("Ashok Industries, Chennai - 600097");
		deliveryChalanTO.setCompanyName("ABCXYZ Company");
		deliveryChalanTO.setDcStatus("A");
		
		DeliveryItem deliveryItemData = new DeliveryItem();
		deliveryItemData.setSerialNo("1");
		deliveryItemData.setDescription("Description_1");
		deliveryItemData.setQuantity("4");
		deliveryItemData.setPer("Set");
		deliveryItemData.setRate("14.5");
		deliveryItemData.setRemarks("Remarks_1");
		
		DeliveryItem deliveryItemData1 = new DeliveryItem();
		deliveryItemData1.setSerialNo("2");
		deliveryItemData1.setDescription("Description_2");
		deliveryItemData1.setQuantity("4");
		deliveryItemData1.setPer("Set");
		deliveryItemData1.setRate("14.5");
		deliveryItemData1.setRemarks("Remarks_2");
		deliveryItemsList.add(deliveryItemData);
		deliveryItemsList.add(deliveryItemData1);
		
		deliveryChalanTO.setDeliveryItemsList(deliveryItemsList);
		
		
		DeliveryChalanDao dc = new DeliveryChalanDao();
		//dc.saveDeliveryChallan(deliveryChalanTO);
		System.out.println("Data Saved into Delivery_Challan table");
		dc.getDeliveryChallans("ABCXYZ Company");
		dc.getDeliveryChallans(null);
		
	}

}
