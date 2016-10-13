package com.pb.pdf.generation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pb.data.model.DeliveryChalanTO;
import com.pb.data.model.DeliveryItem;
import com.pb.data.model.Invoice;
import com.pb.data.model.Invoice1;
import com.pb.data.model.Item;
import com.pb.exceptions.ProcessingException;

public class TestUtillity
{
	public static void main(String... args)
	{
		//Initialze invoice object here.
		Invoice1 invoiceObj = new Invoice1();
		
		List<DeliveryItem> itemsList = new ArrayList<DeliveryItem>();
		List<DeliveryChalanTO> ordersList = new ArrayList<DeliveryChalanTO>();

		// Mocking first Object1:
		DeliveryItem itemObj1 = new DeliveryItem();
		itemObj1.setSerialNo("1");
		itemObj1.setDescription("Particulars1");
		itemObj1.setRate("5");
		itemObj1.setPer("Set");
		itemObj1.setQuantity("10");
		itemObj1.setAmountInRupees("50");
		itemObj1.setAmountInPaise("0");
		itemObj1.setOurDcNo("DC1");	
		itemsList.add(itemObj1);

		// Mocking second object:
		DeliveryItem itemObj2 = new DeliveryItem();
		itemObj2.setSerialNo("2");
		itemObj2.setDescription("Particulars2");
		itemObj2.setRate("4");
		itemObj2.setPer("Piece");
		itemObj2.setQuantity("10");
		itemObj2.setAmountInRupees("40");
		itemObj2.setAmountInPaise("0");
		itemObj2.setOurDcNo("DC1");	
		itemsList.add(itemObj2);

		// Mocking third object:
		DeliveryItem itemObj3 = new DeliveryItem();
		itemObj3.setSerialNo("3");
		itemObj3.setDescription("Particulars3");
		itemObj3.setRate("3");
		itemObj3.setPer("Set");
		itemObj3.setQuantity("10");
		itemObj3.setAmountInRupees("30");
		itemObj3.setAmountInPaise("0");
		itemObj3.setOurDcNo("DC2");	
		itemsList.add(itemObj3);

		// Mocking fourth object:
		DeliveryItem itemObj4 = new DeliveryItem();
		itemObj4.setSerialNo("4");
		itemObj4.setDescription("Particulars4");
		itemObj4.setRate("4");
		itemObj4.setPer("Set");
		itemObj4.setQuantity("12");
		itemObj4.setAmountInRupees("48");
		itemObj4.setAmountInPaise("0");
		itemObj4.setOurDcNo("DC2");	
		itemsList.add(itemObj4);

		// Mocking 5th object.
		DeliveryItem itemObj5 = new DeliveryItem();
		itemObj5.setSerialNo("5");
		itemObj5.setDescription("Particulars5");
		itemObj5.setRate("4");
		itemObj5.setPer("Set");
		itemObj5.setQuantity("15");
		itemObj5.setAmountInRupees("60");
		itemObj5.setAmountInPaise("0");
		itemObj5.setOurDcNo("DC3");	
		itemsList.add(itemObj5);
		
		DeliveryItem itemObj6 = new DeliveryItem();
		itemObj6.setSerialNo("6");
		itemObj6.setDescription("Particulars6");
		itemObj6.setRate("3");
		itemObj6.setPer("Piece");
		itemObj6.setQuantity("12");
		itemObj6.setAmountInRupees("36");
		itemObj6.setAmountInPaise("0");
		itemObj6.setOurDcNo("DC4");	
		itemsList.add(itemObj6);
		
		//Order1 object.
		DeliveryChalanTO order1 = new DeliveryChalanTO();
		order1.setOrderNo("Order1");
		order1.setDate("2016-10-08");
		order1.setNo("DC1");
		order1.setSerialNo("1");
		order1.setOrderDate("2016-09-25");
		
		//Order2 object.
		DeliveryChalanTO order2 = new DeliveryChalanTO();
		order2.setOrderNo("Order2");
		order2.setDate("2016-10-07");
		order2.setNo("DC2");
		order2.setSerialNo("2");
		order2.setOrderDate("2016-09-24");
		
		//Order3 object.
		DeliveryChalanTO order3 = new DeliveryChalanTO();
		order3.setOrderNo("Order3");
		order3.setDate("2016-10-06");
		order3.setNo("DC3");
		order3.setSerialNo("3");
		order3.setOrderDate("2016-09-23");
		
		//Order4 object.
		DeliveryChalanTO order4 = new DeliveryChalanTO();
		order4.setOrderNo("Order4");
		order4.setDate("2016-10-05");
		order4.setNo("DC4");
		order4.setSerialNo("4");
		order4.setOrderDate("2016-09-22");
		
		
		ordersList.add(order1);
		ordersList.add(order2);
		ordersList.add(order3);
		ordersList.add(order4);
		
		
		
		invoiceObj.setItemsList(itemsList);
		invoiceObj.setDeliveryChallansList(ordersList);
		
		StringBuilder toMsBuilder = new StringBuilder();
		toMsBuilder.append("To.M/s \n");
		toMsBuilder.append("\nHonda Motors Pvt Ltd \n");
		toMsBuilder.append("\n T.Nagar \n");
		toMsBuilder.append("\n CHENNAI - 600001 \n");
		toMsBuilder.append("\nParty Tin NO: 25590117220 \n");
		
		invoiceObj.setToMs(toMsBuilder.toString());
		
		try
		{
			PDFGenerator.generateInvoicePDF(invoiceObj);
		}
		catch (ProcessingException e)
		{
			e.printStackTrace();
		}

	}

	 
}
