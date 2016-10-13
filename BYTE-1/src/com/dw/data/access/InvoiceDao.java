/**
 * 
 */
package com.dw.data.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pb.common.utils.DateUtils;
import com.pb.data.model.DeliveryChalanTO;
import com.pb.data.model.DeliveryItem;
import com.pb.data.model.Invoice1;

/**
 * @author user
 *
 */
public class InvoiceDao extends DerbyCommonDao {
	
	public Invoice1 saveInvoice(Invoice1 invoice){
		
		Connection conn = getConnection();
		PreparedStatement invoiceInsert = null;
        Statement s = null;
        ResultSet rs = null;
        
		Integer billNumber = null;
		
    	try {
    		conn.setAutoCommit(false);
    		billNumber = getInvoiceNextSequenceNumber(conn, s, rs);
    		invoiceInsert = conn.prepareStatement(
                    "INSERT INTO INVOICE VALUES (?, ?, ?, ?, ?)");
			invoiceInsert.setInt(1, billNumber);
			invoiceInsert.setDate(2, DateUtils.stringToSqlDate(invoice.getBillDate()));
			invoiceInsert.setString(3, invoice.getServiceTaxLabel());
			invoiceInsert.setFloat(4, Float.parseFloat(invoice.getServiceTaxPercentage()));
			invoiceInsert.setString(5, invoice.getPartyTinNo());
			invoiceInsert.executeUpdate();
			System.out.println("DATA INSERTED INTO INVOICE TABLE");
			String dcIds = saveInvoiceAndDc(conn, billNumber, invoice.getDeliveryChallansList());
			conn.commit();
			invoice.setBillNumber(String.valueOf(billNumber));
			invoice.setDcIds(dcIds);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally
		{
			//Close connection and statement
			try {
				invoiceInsert.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return invoice;
		
	}
	
	private String saveInvoiceAndDc(Connection conn, Integer billNumber,  List<DeliveryChalanTO> deliveryChallanList ) throws SQLException{
	//private void saveDeliveryItemList(Connection conn, Integer ourDcNumber,  List<DeliveryItem> deliveryItemsList, PreparedStatement ps) throws SQLException{
		StringBuffer dcIds = new StringBuffer();
		int index = 1;	
		//Create DeliveryItems List.
		StringBuilder createInvoiceAndDc = new StringBuilder();
		createInvoiceAndDc.append("INSERT INTO ");
		createInvoiceAndDc.append("INVOICE_AND_DC ");
		createInvoiceAndDc.append("(BILL_NUMBER, OUR_DC_NO) ");
		createInvoiceAndDc.append("VALUES(?,?)");
		System.out.println("The sql query generate---"+ createInvoiceAndDc.toString());
		PreparedStatement ps = conn.prepareStatement(createInvoiceAndDc.toString());
		
		for(DeliveryChalanTO deliveryChalanTO : deliveryChallanList){
			ps.setInt(index++, billNumber);
			ps.setInt(index++, Integer.parseInt(deliveryChalanTO.getNo()));
			dcIds.append(deliveryChalanTO.getNo()).append(", ");
			ps.executeUpdate();
			//ps.execute();
			index = 1;
		}
		
		ps.close();
		
		return dcIds.toString();
		
		
	}
	
	private Integer getInvoiceNextSequenceNumber (Connection connection, Statement statement, ResultSet rs)throws SQLException  {
		Integer nextSequenceNumber = null;
		//Execute the Query to get the Next_Seq_Number from DELIVERY_CHALLAN_SEQUENCE
		statement = connection.createStatement();
	    rs = statement.executeQuery(
            "VALUES (NEXT VALUE FOR SEQ_INVOICE)");
        if(rs.next()) {
            // do something with the result set
        	System.out.println("THE NEXT SEQUENCE OF SEQ_INVOICE IS==>"+ rs.getInt(1));
        	nextSequenceNumber = rs.getInt(1);
       	
        }
		return nextSequenceNumber;
	}
	
	public static void main(String args[]){
		Invoice1 invoice = new Invoice1();
		List<DeliveryChalanTO> deliveryChallanList = new ArrayList<>();
		invoice.setBillDate("5-10-2016");
		invoice.setServiceTaxLabel("VAT");
		invoice.setServiceTaxPercentage("5");
		invoice.setPartyTinNo("12345678910");
		
		DeliveryChalanTO deliveryChalanTO = new DeliveryChalanTO();
		deliveryChalanTO.setNo("1000000001");
		DeliveryChalanTO deliveryChalanTO1 = new DeliveryChalanTO();
		deliveryChalanTO1.setNo("1000000002");
		
		deliveryChallanList.add(deliveryChalanTO);
		deliveryChallanList.add(deliveryChalanTO1);
		
		invoice.setDeliveryChallansList(deliveryChallanList);
		
		InvoiceDao invoiceDao = new InvoiceDao();
		invoiceDao.saveInvoice(invoice);
		System.out.println("Data Saved into INVOICE table");
	}

	
	

}
