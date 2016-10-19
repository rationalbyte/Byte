package com.dw.data.access;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.dw.data.SearchCriteria;
import com.pb.data.model.DeliveryChalanTO;
import com.pb.data.model.DeliveryItem;
import com.pb.data.model.Invoice1;

public class DataManager {
	
	
	public static Invoice1 saveInvoice(Invoice1 invoice){
		InvoiceDao invoiceDao = new InvoiceDao();
		Invoice1 invoice1 = invoiceDao.saveInvoice(invoice);
		/*String dcIds = invoice1.getDcIds();
		dcIds = dcIds.substring(0, dcIds.length()-2);
		loadDeliveryChallans(invoice, dcIds);
		loadDeleveryItems(invoice, dcIds);*/
		return invoice1;
	}
	
	/*private static void loadDeliveryChallans(Invoice1 invoice, String dcIds){
		DeliveryChalanDao deliveryChalanDao = new DeliveryChalanDao();
		List<DeliveryChalanTO> dcList = deliveryChalanDao.getDeliveryChallansByDcIds(conn, dcIds);
		invoice.setDeliveryChallansList(dcList);
	}
	
	private static void loadDeleveryItems(Invoice1 invoice, String dcIds){
		DeliveryChalanDao deliveryChalanDao = new DeliveryChalanDao();
		List<DeliveryItem> diList = deliveryChalanDao.getDeliveryItemsByDcIds(invoice, dcIds);
		invoice.setItemsList(diList);
	}*/
	
	public static Integer saveDeliveryChallan(DeliveryChalanTO deliveryChalanTO){
		DeliveryChalanDao deliveryChalanDao = new DeliveryChalanDao();
		Integer primaryKey = deliveryChalanDao.saveDeliveryChallan(deliveryChalanTO);
		return primaryKey;
	}

	public static List<DeliveryChalanTO> getActiveDeliveryChallans(String companyName){
		DeliveryChalanDao deliveryChalanDao = new DeliveryChalanDao();
		return deliveryChalanDao.getDeliveryChallans(companyName);
	}
	
	public static void generateInvoice(Invoice1 invoice){
		//1. Save the Data into Invoice Table
		//2. Update the INVOICE_AND_DC
		//3. Fetch the data from DELIVERY_ITEM
	}
	/*public static Integer saveCustomer(CustomerData customerData){
		
		System.out.println("Customer Name: "+customerData.getCustomerName());
		System.out.println("Father Name"+customerData.getFatherName());
		System.out.println("Address"+customerData.getAddress1());
		System.out.println("Rate of Interest"+customerData.getRateOfInterest());
		customerData.setPrincipalAmt("0");
		customerData.setOutStandingAmt("0");
		System.out.println("                    ");
		
		for(ItemData itemdata : customerData.getItemList()){
			System.out.println("Item Name: "+itemdata.getItemName());
			System.out.println("Metal"+itemdata.getMetal());
			System.out.println("Weight"+itemdata.getWeight());
			System.out.println("Quantity"+itemdata.getQuantity());
			System.out.println("Item wise Principal Amount"+itemdata.getItemPa());
			System.out.println("                    ");
		}
		
		CustomerDao customerDao = new CustomerDao();
		return customerDao.saveCustomer(customerData);
		//return new Integer(1234567890);
	}
	
	public static boolean updateCustomer(CustomerData customerData){
		///////// DATA CHECK
		System.out.println("Customer ID: "+customerData.getCustomerId());
		System.out.println("Customer Name: "+customerData.getCustomerName());
		System.out.println("Father Name"+customerData.getFatherName());
		System.out.println("Address"+customerData.getAddress1());
		System.out.println("Rate of Interest"+customerData.getRateOfInterest());
		System.out.println("                    ");
		
		for(ItemData itemdata : customerData.getItemList()){
			System.out.println("Item Name: "+itemdata.getItemName());
			System.out.println("Metal"+itemdata.getMetal());
			System.out.println("Weight"+itemdata.getWeight());
			System.out.println("Quantity"+itemdata.getQuantity());
			System.out.println("Item wise Principal Amount"+itemdata.getItemPa());
			System.out.println("                    ");
		}
		/////////
		boolean updated = false;
		CustomerDao customerDao = new CustomerDao();
		return customerDao.updateCustomer(customerData);
		//return true;
		
	}*/
	
	public static boolean deleteCustomer(Integer cutomerId){
		boolean deleted = false;
		
		return deleted;
	}
	
	/*public static CustomerData getCustomerDetails(String cutomerId){
		System.out.println("222222$$$$$$$$$$$$ Before DB call 2 ======>"+ cutomerId);
		CustomerDao customerDao = new CustomerDao();
		return customerDao.getCustomerDetails(cutomerId.trim());
		
	}*/
	
	/*public static ArrayList<CustomerData> getCustomersList(SearchCriteria searchCriteria){
		
		ArrayList<CustomerData> customerList = new ArrayList<CustomerData>();
		
		CustomerDao customerDao = new CustomerDao();
		customerList = customerDao.searchCustomer(searchCriteria);
		
		//Replace this hard coded values with the values taken from DB
		CustomerData cd = new CustomerData();
		cd.setCustomerName("CustomeName001");
		cd.setCustomerId("1234567890");
		cd.setDateOfReceipt("21-04-2015");// + Other values also available in the cd.
		customerList.add(cd);
		
		CustomerData cd1 = new CustomerData();
		cd1.setCustomerName("CustomerName002");
		cd1.setCustomerId("1234567891");
		cd1.setDateOfReceipt("23-04-2015");// + Other values also available in the cd.
		customerList.add(cd1);
		
		CustomerData cd2 = new CustomerData();
		cd2.setCustomerName("CustomerName003");
		cd2.setCustomerId("1234567892");
		cd2.setDateOfReceipt("24-04-2015");// + Other values also available in the cd.
		customerList.add(cd2);
		
		return customerList;
		
	}*/

}
