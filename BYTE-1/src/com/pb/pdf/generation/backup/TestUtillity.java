package com.pb.pdf.generation.backup;

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
import com.pb.data.model.Invoice;
import com.pb.data.model.Item;
import com.pb.exceptions.ProcessingException;

public class TestUtillity
{
	public static void main(String... args)
	{
		//Initialze invoice object here.
		Invoice invoiceObj = new Invoice();
		
		List<Item> itemsList = new ArrayList<Item>();

		// Mocking first Object1:
		Item itemObj1 = new Item();
		itemObj1.setSerialNo("1");
		itemObj1.setParticulars("Particulars1");
		itemObj1.setPerRate("5");
		itemObj1.setPer("-");
		itemObj1.setQty("10");
		itemObj1.setAmountInRupees("50");
		itemObj1.setAmountInPaise("0");
		itemsList.add(itemObj1);

		// Mocking second object:
		Item itemObj2 = new Item();
		itemObj2.setSerialNo("2");
		itemObj2.setParticulars("Particulars2");
		itemObj2.setPerRate("4");
		itemObj2.setPer("-");
		itemObj2.setQty("10");
		itemObj2.setAmountInRupees("40");
		itemObj2.setAmountInPaise("0");
		itemsList.add(itemObj2);

		// Mocking third object:
		Item itemObj3 = new Item();
		itemObj3.setSerialNo("3");
		itemObj3.setParticulars("Particulars3");
		itemObj3.setPerRate("3");
		itemObj3.setPer("-");
		itemObj3.setQty("10");
		itemObj3.setAmountInRupees("30");
		itemObj3.setAmountInPaise("0");
		itemsList.add(itemObj3);

		// Mocking fourth object:
		Item itemObj4 = new Item();
		itemObj4.setSerialNo("4");
		itemObj4.setParticulars("Particulars4");
		itemObj4.setPerRate("4");
		itemObj4.setPer("-");
		itemObj4.setQty("12");
		itemObj4.setAmountInRupees("48");
		itemObj4.setAmountInPaise("0");
		itemsList.add(itemObj4);

		// Mocking 5th object.
		Item itemObj5 = new Item();
		itemObj5.setSerialNo("5");
		itemObj5.setParticulars("Particulars5");
		itemObj5.setPerRate("4");
		itemObj5.setPer("-");
		itemObj5.setQty("15");
		itemObj5.setAmountInRupees("60");
		itemObj5.setAmountInPaise("0");
		itemsList.add(itemObj5);
		
		Item itemObj6 = new Item();
		itemObj5.setSerialNo("6");
		itemObj5.setParticulars("Particulars6");
		itemObj5.setPerRate("3");
		itemObj5.setPer("-");
		itemObj5.setQty("12");
		itemObj5.setAmountInRupees("36");
		itemObj5.setAmountInPaise("0");
		itemsList.add(itemObj5);
		
		invoiceObj.setItemsList(itemsList);
		
		
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
