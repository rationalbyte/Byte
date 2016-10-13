package com.pb.pdf.generation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;





import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.pb.data.model.DeliveryChalanTO;
import com.pb.data.model.DeliveryItem;
import com.pb.data.model.Invoice;
import com.pb.data.model.Invoice1;
import com.pb.data.model.Item;
import com.pb.constants.Constants;
import com.pb.exceptions.ProcessingException;

/**
 * The class has been designed to generate the PDF using ITEXT api 5.x version.
 * 
 * @author AXJ8041
 * 
 */
public class PDFGenerator implements Serializable
{

	
	private static final long serialVersionUID = 2348427325409318972L;
	
	public static void main(String... args)
	{
		try {
			
			DeliveryChalanTO deliveryChannel = new DeliveryChalanTO();
			deliveryChannel.setDate("08-27-2016");
			deliveryChannel.setMs("MS");
			deliveryChannel.setNo("1");
			deliveryChannel.setOrderDate("08-27-2016");
			
			List<DeliveryItem> deliveryItemsList = new ArrayList<DeliveryItem>();
			
			DeliveryItem deliveryItem1 = new DeliveryItem();
			deliveryItem1.setDescription("Description1");
			deliveryItem1.setQuantity("1");
			deliveryItem1.setRemarks("Remarks1");
			deliveryItem1.setSerialNo("1");
			
			DeliveryItem deliveryItem2 = new DeliveryItem();
			deliveryItem2.setDescription("Description2");
			deliveryItem2.setQuantity("2");
			deliveryItem2.setRemarks("Remarks2");
			deliveryItem2.setSerialNo("2");
			
			DeliveryItem deliveryItem3 = new DeliveryItem();
			deliveryItem3.setDescription("Description3");
			deliveryItem3.setQuantity("3");
			deliveryItem3.setRemarks("Remarks3");
			deliveryItem3.setSerialNo("3");
			
			DeliveryItem deliveryItem4 = new DeliveryItem();
			deliveryItem4.setDescription("Description4");
			deliveryItem4.setQuantity("4");
			deliveryItem4.setRemarks("Remarks4");
			deliveryItem4.setSerialNo("4");
		    
			
			DeliveryItem deliveryItem5 = new DeliveryItem();
			deliveryItem5.setDescription("Description5");
			deliveryItem5.setQuantity("5");
			deliveryItem5.setRemarks("Remarks5");
			deliveryItem5.setSerialNo("5");
			
			DeliveryItem deliveryItem6 = new DeliveryItem();
			deliveryItem6.setDescription("Description6");
			deliveryItem6.setQuantity("6");
			deliveryItem6.setRemarks("Remarks6");
			deliveryItem6.setSerialNo("6");
			
			
			DeliveryItem deliveryItem7 = new DeliveryItem();
			deliveryItem7.setDescription("Description7");
			deliveryItem7.setQuantity("7");
			deliveryItem7.setRemarks("Remarks7");
			deliveryItem7.setSerialNo("7");
			
			DeliveryItem deliveryItem8 = new DeliveryItem();
			deliveryItem8.setDescription("Description8");
			deliveryItem8.setQuantity("8");
			deliveryItem8.setRemarks("Remarks8");
			deliveryItem8.setSerialNo("8");
		    
			
			deliveryItemsList.add(deliveryItem1);
			deliveryItemsList.add(deliveryItem2);
			deliveryItemsList.add(deliveryItem3);
			deliveryItemsList.add(deliveryItem4);
			deliveryItemsList.add(deliveryItem5);
			deliveryItemsList.add(deliveryItem6);
			deliveryItemsList.add(deliveryItem7);
			deliveryItemsList.add(deliveryItem8);
			deliveryChannel.setDeliveryItemsList(deliveryItemsList);
			generateDeliveryChalanPDF(deliveryChannel);
		} catch (ProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void generateDeliveryChalanPDF(DeliveryChalanTO deliveryChalanTo)throws ProcessingException
	{
		try {
			Document document = createDocument("delivery");
			addHeaderContentForDeliveryChanal(document, deliveryChalanTo);
			addBodyContentForDeliveryChanal(document, deliveryChalanTo);
			Chunk footerChunk = new Chunk("Receiver's Signature",PDFFont.getCourier06WithNormal());
			Chunk emptyChunk = new Chunk("                                                                        ");
			Chunk footerChunk2 = new Chunk("for",PDFFont.getCourier06WithNormal());
			Chunk footerChunk3 = new Chunk(" RAMANA ENGINEERING WORKS",PDFFont.getCourier08WithBold());
			Paragraph footerParagraph = new Paragraph();
			footerParagraph.add(footerChunk);
			footerParagraph.add(emptyChunk);
			footerParagraph.add(footerChunk2);
			footerParagraph.add(footerChunk3);
			footerParagraph.setIndentationLeft(60f);
			footerParagraph.setLeading(8,0);
			document.add(footerParagraph);
			document.close();
			
		} catch (Exception e) {
			if (e instanceof DocumentException)
			{
				DocumentException de = (DocumentException) e;
				throw new ProcessingException(Constants.DOCUMENT_EXCEPTION_ERROR, de.getMessage());
			}
			else
			{
				throw new ProcessingException(Constants.UNKNOWN_ERROR, e.getMessage());
			}
		}
	}

	/**
	 * This method is used to generate the Invoice PDF.
	 * 
	 * @param invoiceObj
	 *            - this is the helper object for generating PDF with the
	 *            required inputs.
	 * @throws ProcessingException
	 *             - All generic exceptions will be converted back to custom
	 *             exception of type Processing Exception and thrown back from
	 *             current method.
	 */
	public static void generateInvoicePDF(final Invoice1 invoiceObj) throws ProcessingException
	{
		@SuppressWarnings("rawtypes")
		List<DeliveryItem> itemsList = null;
		try
		{
			if (null == invoiceObj)
			{
				throw new ProcessingException(Constants.INVOICE_OBJECT_CANT_BE_NULL, "Invoice object should be populated to generate the Invoice PDF");
			}
			else
			{
				itemsList = invoiceObj.getItemsList();
				if (itemsList.isEmpty())
				{
					throw new ProcessingException(Constants.ITEMS_LIST_CANT_BE_EMPTY,
							"Items list should not be empty for genetrating the Invoice PDF");
				}
			}
			
			//List<Order> ordersList = invoiceObj.getOrdersList();
			List<DeliveryChalanTO> ordersList = invoiceObj.getDeliveryChallansList();

			Document document = createDocument("invoice");
			
			
			addHeaderContent(document);
			
			addBillTable(document, invoiceObj);
			
			addOrdersTable(document, ordersList);
			
	
			addBodyContent(document, itemsList);

			
			Chunk chunk1 = new Chunk("For ");
			chunk1.setFont(PDFFont.getCourier06WithNormal());

			Chunk chunk2 = new Chunk("RAMANA ENGINEERING WORKS");
			chunk2.setFont(PDFFont.getCourier07WithBold());

			Paragraph paragraph = new Paragraph();
			paragraph.add(chunk1);
			paragraph.add(chunk2);
			paragraph.setSpacingBefore(0f);
			paragraph.setIndentationLeft(395f);
			paragraph.setLeading(8, 0);
			// paragraph.setIndentationRight(Element.ALIGN_LEFT);
			document.add(paragraph);
			document.close();
			
		}
		catch (Exception e)
		{
			if (e instanceof DocumentException)
			{
				DocumentException de = (DocumentException) e;
				throw new ProcessingException(Constants.DOCUMENT_EXCEPTION_ERROR, de.getMessage());
			}
			else
			{
				throw new ProcessingException(Constants.UNKNOWN_ERROR, e.getMessage());
			}
		}
	}

	/**
	 * This method created the PDF Document and opens it to write content in it.
	 * 
	 * @return Document - returns the PDF Document object
	 * @throws DocumentException
	 *             - throws DocumentException
	 * @throws ProcessingException
	 *             - All generic exceptions will be converted back to custom
	 *             exception of type Processing Exception.
	 */
	private static Document createDocument(String name) throws DocumentException, ProcessingException
	{
		// left,right,top and bottom margins.[50,50,50,50]
		Document document = new Document(PageSize.A4, 25, 25, 25, 25);
		PdfWriter writer = null;
		try
		{
			if (name.equalsIgnoreCase("invoice")) {
				writer = PdfWriter.getInstance(document, new FileOutputStream(
						"E:\\PROJECTS\\INVOICE\\ramana_engg\\Reports\\FirstExample.pdf"));//  E:\\PROJECTS\\INVOICE\\ramana_engg\\Reports
			}
			else
			{
				writer = PdfWriter.getInstance(document, new FileOutputStream(
						"E:\\PROJECTS\\INVOICE\\ramana_engg\\Reports\\SecondExample.pdf"));
			}	
			writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);

			document.open();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			throw new ProcessingException(Constants.UNKNOWN_ERROR, e.getMessage());
		}

		return document;
	}

	/**
	 * @param document
	 *            - PDF Document
	 * @return Document - PDF Document with header content filled in
	 * @throws DocumentException
	 * @throws ProcessingException
	 */
	private static void addHeaderContent(Document document) throws DocumentException, ProcessingException
	{

		Image img = null;
		Chunk cellChunk = new Chunk("Cell: 9940467636", PDFFont.getCourier06WithNormal());
		Paragraph initialParaGraph = new Paragraph(cellChunk);
		initialParaGraph.setAlignment(Element.ALIGN_RIGHT);
		initialParaGraph.setFont(PDFFont.getCourier06WithNormal());
		initialParaGraph.setSpacingBefore(0);

		// working one.
		// initialParaGraph.setLeading(-40, 0);
         
		initialParaGraph.setLeading(-15, 0);

		// initialParaGraph.setLeading(-30, 0);
		initialParaGraph.setIndentationRight(30f);
		try
		{
			//img = Image.getInstance("C:\\Users\\axj8041\\Desktop\\Personal\\invoice_logo.png");
			img = Image.getInstance("E:\\PROJECTS\\INVOICE\\ramana_engg\\Reports\\rew_logo.png");
			// img.scalePercent(300f);
			// img.scaleToFit(150f, 150f);

			// working one img.scaleAbsolute(40, 46);
			img.scaleAbsolute(40, 38);
			img.setIndentationLeft(50f);
			img.setAlignment(Element.ALIGN_LEFT);
			// img.setAbsolutePosition(-50f, 50f);
			// img.setSpacingBefore(50f);
			document.add(img);

			Chunk chunk = new Chunk("INVOICE BILL", PDFFont.getCourier08WithNormal());
			chunk.setUnderline(0f, -2f);
			chunk.setCharacterSpacing(0f);

			Paragraph paragraph1 = new Paragraph(chunk);
			paragraph1.setSpacingBefore(0);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			// paragraph1.setLeading(-10, 0);

			// working one.
			paragraph1.setLeading(4, 0);
			// paragraph1.setLeading(25, 0);

			// paragraph1.set
			Paragraph paragraph2 = new Paragraph("RAMANA ENGINEERING WORKS", PDFFont.getCourier14WithBold());
			paragraph2.setSpacingBefore(0);
			paragraph2.setAlignment(Element.ALIGN_CENTER);
			paragraph2.setLeading(16, 0);

			Paragraph paragraph3 = new Paragraph("{All kinds of Turning Works,Jigs,Fixtures,Job Work & Tool Room Works}",
					PDFFont.getCourier06WithBold());
			paragraph3.setAlignment(Element.ALIGN_CENTER);
			paragraph3.setSpacingBefore(0);

			Paragraph paragraph4 = new Paragraph("No, 1/252-B, Selvakumar Avenue, Thuraipakkam, Chennai-97,", PDFFont.getCourier06WithNormal());
			paragraph4.setAlignment(Element.ALIGN_CENTER);
			paragraph4.setSpacingBefore(0);

			// Date needs to be append dynamically.
			Paragraph paragraph5 = new Paragraph("TIN No. 33210927102/CST : 1017909/ Dt:" + "30-12-2010", PDFFont.getCourier07WithBold());
			paragraph5.setAlignment(Element.ALIGN_CENTER);
			paragraph5.setSpacingBefore(0);
			paragraph5.setSpacingAfter(0);
			paragraph5.setExtraParagraphSpace(0);
			paragraph5.setLeading(8, 0);

			/*
			// Line seperator starts.
			Chunk linebreakStart = new Chunk(new LineSeparator(0.7f, 90f, BaseColor.BLUE, Element.ALIGN_CENTER, -1));
			Paragraph paragraph6 = new Paragraph(linebreakStart);
			paragraph6.setAlignment(Element.ALIGN_CENTER);
			paragraph6.setSpacingBefore(0);
			paragraph6.setSpacingAfter(0);
			paragraph6.setExtraParagraphSpace(0);
			paragraph6.setLeading(10, 0);

			Chunk lineContentChunk = new Chunk(StringUtils.rightPad("Bill No.", 23, " ") + StringUtils.rightPad("150", 16, " ") + " "
					+ StringUtils.rightPad("Date:", 22, " ") + StringUtils.rightPad("2016/8/8", 22, " ")
					+ StringUtils.rightPad("Your Order No.", 26, " ") + StringUtils.rightPad("12345", 17, " ")
					+ StringUtils.rightPad("Date:", 17, " ") + StringUtils.rightPad("2016/8/8", 22, " ")
					+ StringUtils.rightPad("Our D.C.No.", 28, " ") + StringUtils.rightPad("123", 15, " ") + StringUtils.rightPad("Date:", 15, " ")
					+ StringUtils.rightPad("2016/8/8", 10, " "), PDFFont.getCourier06WithNormal());

			// lineContentChunk.seti
			Paragraph paragraph7 = new Paragraph(lineContentChunk);
			// paragraph7.setAlignment(Element.ALIGN_CENTER);
			paragraph7.setIndentationLeft(27f);
			paragraph7.setSpacingBefore(0);
			paragraph7.setSpacingAfter(0);
			paragraph7.setExtraParagraphSpace(0);
			paragraph7.setLeading(10, 0);

			// Line seperator ends.
			Chunk linebreakEnd = new Chunk(new LineSeparator(0.7f, 90f, BaseColor.BLUE, Element.ALIGN_CENTER, -1));
			Paragraph paragraph8 = new Paragraph(linebreakEnd);
			paragraph8.setAlignment(Element.ALIGN_CENTER);
			paragraph8.setSpacingBefore(0);
			paragraph8.setSpacingAfter(0);
			paragraph8.setExtraParagraphSpace(0);
			paragraph8.setLeading(7, 0);

			Paragraph paragraph9 = new Paragraph("To.M/s", PDFFont.getCourier06WithNormal());
			DottedLineSeparator dottedLineSeperator = new DottedLineSeparator();
			dottedLineSeperator.setLineWidth(1f);
			// dottedLineSeperator.setGap(1f);
			dottedLineSeperator.setLineColor(BaseColor.BLUE);
			paragraph9.add(new Chunk(dottedLineSeperator));
			paragraph9.setIndentationLeft(25f);
			paragraph9.setIndentationRight(25f);
			paragraph9.setSpacingBefore(0);
			paragraph9.setSpacingAfter(0);
			paragraph9.setExtraParagraphSpace(0);
			paragraph9.setLeading(15, 0);
			paragraph9.setAlignment(Element.ALIGN_CENTER);

			DottedLineSeparator dottedLineSeperator1 = new DottedLineSeparator();
			dottedLineSeperator1.setLineWidth(1f);
			dottedLineSeperator1.setLineColor(BaseColor.BLUE);
			Chunk dottedLineChunk = new Chunk(dottedLineSeperator1);
			Paragraph paragrap10 = new Paragraph(dottedLineChunk);
			paragrap10.setIndentationLeft(25f);
			paragrap10.setIndentationRight(25f);
			paragrap10.setSpacingBefore(0);
			paragrap10.setSpacingAfter(0);
			paragrap10.setExtraParagraphSpace(0);
			paragrap10.setLeading(15, 0);
			paragrap10.setAlignment(Element.ALIGN_CENTER);
			// paragrap10.setFont(PDFFont.getCourier06WithNormal());

			Paragraph paragraph11 = new Paragraph();
			DottedLineSeparator dottedLineSeperator2 = new DottedLineSeparator();
			dottedLineSeperator2.setLineWidth(1f);
			// dottedLineSeperator.setGap(1f);
			dottedLineSeperator2.setLineColor(BaseColor.BLUE);
			paragraph11.add(new Chunk(dottedLineSeperator));
			paragraph11.setIndentationLeft(25f);
			paragraph11.setIndentationRight(25f);
			paragraph11.setSpacingBefore(0);
			paragraph11.setSpacingAfter(10f);
			paragraph11.setExtraParagraphSpace(0);
			paragraph11.setLeading(15, 0);
			paragraph11.setAlignment(Element.ALIGN_CENTER);
			Chunk labelChunk = new Chunk("Party Tin NO :");
			DottedLineSeparator dottedLineSeperator3 = new DottedLineSeparator();
			dottedLineSeperator3.setLineWidth(1f);
			dottedLineSeperator3.setLineColor(BaseColor.BLUE);
			Chunk dottedLineChunk11 = new Chunk(dottedLineSeperator3);
			labelChunk.setFont(PDFFont.getCourier06WithNormal());
			paragraph11.add(labelChunk);
			paragraph11.add(dottedLineChunk11);

        */
			document.add(initialParaGraph);
			document.add(paragraph1);
			document.add(paragraph2);
			document.add(paragraph3);
			document.add(paragraph4);
			document.add(paragraph5);
			//document.add(paragraph6);
			//document.add(paragraph7);
			//document.add(paragraph8);
			//document.add(paragraph9);
			//document.add(paragrap10);
			//document.add(paragraph11);
		}
		catch (BadElementException be)
		{
			throw new ProcessingException(Constants.BAD_ELEMENT_EXCEPTION_ERROR, be.getMessage());
		}

		catch (MalformedURLException me)
		{
			throw new ProcessingException(Constants.MALFORMED_ELEMENT_EXCEPTION_ERROR, me.getMessage());
		}
		catch (IOException ioe)
		{
			throw new ProcessingException(Constants.IO_EXCEPTION_ERROR, ioe.getMessage());
		}
		catch (Exception e)
		{
			throw new ProcessingException(Constants.UNKNOWN_ERROR, e.getMessage());
		}

		return ;
	}

	/**
	 * @param document
	 *            - PDF Document with Body content
	 * @param itemsList
	 *            - List of items that are going to be dynamically appended to
	 *            the PDF Body.
	 * @return Document - PDF Document.
	 * @throws DocumentException
	 * @throws ProcessingException
	 */
	private static void addBodyContent(Document document, List<DeliveryItem> itemsList) throws DocumentException, ProcessingException
	{

		try
		{
			PdfPTable pdfTable = new PdfPTable(8);
			pdfTable.setSpacingBefore(10f);

			float[] columnWidths = new float[]
					{ 10f, 10f,20f, 10f, 10f, 10f, 15f, 5f };
			pdfTable.setWidths(columnWidths);
			pdfTable.setWidthPercentage(90f);

			// cell1.
			PdfPCell pdfCell1 = new PdfPCell(new Phrase("SI.No.", PDFFont.getCourier06WithNormal()));
			pdfCell1.setBorderColor(BaseColor.BLUE);
			pdfCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell1.setRowspan(10);
			pdfTable.addCell(pdfCell1);

			PdfPCell pdfCell21 = new PdfPCell(new Phrase("Our D.C.No", PDFFont.getCourier06WithNormal()));
			pdfCell21.setBorderColor(BaseColor.BLUE);
			pdfCell21.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell1.setRowspan(10);
			pdfTable.addCell(pdfCell21);
			
			// cell2.
			PdfPCell pdfCell2 = new PdfPCell(new Phrase("PARTICULARS", PDFFont.getCourier06WithNormal()));
			pdfCell2.setBorderColor(BaseColor.BLUE);
			pdfCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell2.setRowspan(10);
			pdfTable.addCell(pdfCell2);

			// cell3.
			PdfPCell pdfCell3 = new PdfPCell(new Phrase("Qty", PDFFont.getCourier06WithNormal()));
			pdfCell3.setBorderColor(BaseColor.BLUE);
			pdfCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell3.setRowspan(10);
			pdfTable.addCell(pdfCell3);

			// cell4.
			PdfPCell pdfCell4 = new PdfPCell(new Phrase("Per", PDFFont.getCourier06WithNormal()));
			pdfCell4.setBorderColor(BaseColor.BLUE);
			pdfCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell4.setRowspan(10);
			pdfTable.addCell(pdfCell4);

			// cell5.
			PdfPCell pdfCell5 = new PdfPCell(new Phrase("Rate", PDFFont.getCourier06WithNormal()));
			pdfCell5.setBorderColor(BaseColor.BLUE);
			pdfCell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell5.setRowspan(10);
			pdfTable.addCell(pdfCell5);

			// cell6.
			PdfPCell pdfCell6 = new PdfPCell(new Phrase("Amount Rs.                                  P.", PDFFont.getCourier06WithNormal()));
			pdfCell6.setBorderColor(BaseColor.BLUE);
			pdfCell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfCell6.setColspan(2);
			pdfTable.addCell(pdfCell6);

			pdfTable.setHeaderRows(1);

			float allAmountsAmnt = 0;
			float sum = 0;
			float amountInRupees = 0;
			for (DeliveryItem itemObj : itemsList)
			{
				allAmountsAmnt = Integer.parseInt(itemObj.getAmountInRupees());
				sum = sum + allAmountsAmnt;
				amountInRupees = (Float.valueOf(itemObj.getQuantity())) * (Float.valueOf(itemObj.getRate()));
				// serial no:-
				PdfPCell pdfCell = new PdfPCell(new Phrase(itemObj.getSerialNo(), PDFFont.getCourier06WithNormal()));
				// pdfCell.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfTable.addCell(pdfCell);

				pdfCell = null;
				
				
				// Our D.C.No
				pdfCell = new PdfPCell(new Phrase(itemObj.getOurDcNo(), PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfTable.addCell(pdfCell);

				pdfCell = null;

				// particulars.
				pdfCell = new PdfPCell(new Phrase(itemObj.getDescription(), PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfTable.addCell(pdfCell);

				pdfCell = null;

				// Qty.
				pdfCell = new PdfPCell(new Phrase(itemObj.getQuantity(), PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfTable.addCell(pdfCell);

				pdfCell = null;
				// per.
				pdfCell = new PdfPCell(new Phrase("-", PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(pdfCell);

				pdfCell = null;
				// Rate..
				pdfCell = new PdfPCell(new Phrase(StringUtils.leftPad(itemObj.getRate(), 5, " "), PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(pdfCell);

				pdfCell = null;

				// Amount in Rupees.
				pdfCell = new PdfPCell(new Phrase(StringUtils.leftPad(String.valueOf(amountInRupees), 5, " "), PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(pdfCell);

				pdfCell = null;

				// Amount in Paise.
				pdfCell = new PdfPCell(new Phrase(StringUtils.leftPad(itemObj.getAmountInPaise(), 5, " "), PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				// pdfCell.setBorder(PdfPCell.RIGHT);
				pdfCell.setBorder(PdfPCell.RIGHT);
				pdfCell.enableBorderSide(Rectangle.LEFT);
				pdfCell.enableBorderSide(Rectangle.RIGHT);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(pdfCell);

			}

			/**********************************************************************************************************************/
			// Table VAT Percentage row
			/**********************************************************************************************************************/

			// serial no:-
			PdfPCell pdfCell = new PdfPCell(new Phrase("", PDFFont.getCourier06WithNormal()));
			// pdfCell.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfTable.addCell(pdfCell);

			pdfCell = null;

		    pdfCell = new PdfPCell(new Phrase("", PDFFont.getCourier06WithNormal()));
			// pdfCell.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfTable.addCell(pdfCell);

			pdfCell = null;
			
			// particulars.
			pdfCell = new PdfPCell(new Phrase(StringUtils.leftPad("VAT", 10, " ").concat("   ").concat("%"), PDFFont.getCourier06WithNormal()));
			// pdfCell22.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			// pdfCell.setVerticalAlignment(verticalAlignment);
			pdfTable.addCell(pdfCell);

			pdfCell = null;

			// Qty.
			pdfCell = new PdfPCell(new Phrase("", PDFFont.getCourier06WithNormal()));
			// pdfCell22.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfTable.addCell(pdfCell);

			pdfCell = null;
			// per.
			pdfCell = new PdfPCell(new Phrase("6", PDFFont.getCourier06WithNormal()));
			// pdfCell22.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(pdfCell);

			pdfCell = null;
			// Rate..
			pdfCell = new PdfPCell(new Phrase(StringUtils.leftPad(" ", 5, " "), PDFFont.getCourier06WithNormal()));
			// pdfCell22.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfTable.addCell(pdfCell);

			pdfCell = null;

			float vat = .06f;
			float amountAfterTax = vat * (sum);
			float vatPaise = (amountAfterTax % 1);
			int vatAmount = (int) amountAfterTax;
			float allAmntPaise = (sum % 1);
			double vatPaiseRoundOff = Math.round(vatPaise * 100.0) / 100.0;
			double totalAmtWithVat = sum + vatAmount + vatPaiseRoundOff;
			// Amount in Rupees.
			pdfCell = new PdfPCell(new Phrase(StringUtils.leftPad(String.valueOf(vatAmount), 5, " "), PDFFont.getCourier06WithNormal()));
			// pdfCell22.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(pdfCell);

			pdfCell = null;

			// Amount in Paise.
			pdfCell = new PdfPCell(new Phrase(StringUtils.leftPad(String.valueOf(vatPaiseRoundOff), 5, " "), PDFFont.getCourier06WithNormal()));
			// pdfCell22.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			pdfCell.setBorder(PdfPCell.RIGHT);
			pdfCell.enableBorderSide(Rectangle.LEFT);
			pdfCell.enableBorderSide(Rectangle.RIGHT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(pdfCell);

			pdfCell = null;

			/**********************************************************************************************************************************/
			// Table Footer row starts here..............
			/**********************************************************************************************************************************/
			int totAmtInRuppes = (int) totalAmtWithVat;
			double totAmntPaise = allAmntPaise + vatPaiseRoundOff;

			pdfCell = new PdfPCell(new Phrase("Rupees", PDFFont.getCourier06WithNormal()));
			pdfCell.setColspan(5);
			// pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			pdfTable.addCell(pdfCell);

			pdfCell = null;

			pdfCell = new PdfPCell(new Phrase("Total", PDFFont.getCourier06WithNormal()));
			// pdfCell.setColspan(4);
			// pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(pdfCell);

			pdfCell = null;

			pdfCell = new PdfPCell(new Phrase(String.valueOf(totAmtInRuppes), PDFFont.getCourier06WithNormal()));
			// pdfCell.setColspan(4);
			// pdfCell.setBorder(PdfPCell.LEFT);
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(pdfCell);

			pdfCell = null;

			pdfCell = new PdfPCell(new Phrase(String.valueOf(totAmntPaise), PDFFont.getCourier06WithNormal()));
			// pdfCell.setColspan(4);
			// pdfCell.setBorder(PdfPCell.LEFT);
			// pdfCell.setBorder(PdfPCell.RIGHT);
			// pdfCell.setb
			pdfCell.setBorderColor(BaseColor.BLUE);
			pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(pdfCell);

			/************************************************************************************************************************************/
			// Table Footer row ends here..
			/*************************************************************************************************************************************/

			document.add(pdfTable);
		}
		catch (NumberFormatException e)
		{
			throw new ProcessingException(Constants.NUMBER_FORMAT_EXCEPTION_ERROR, e.getMessage());
		}
		catch (Exception e)
		{
			throw new ProcessingException(Constants.UNKNOWN_ERROR, e.getMessage());
		}

		return ;
	}

	private static Document addHeaderContentForDeliveryChanal(Document document, DeliveryChalanTO deliveryChalanTO)
			throws DocumentException, ProcessingException {
		Image img = null;
		// for cell no:-
		Chunk cellChunk = new Chunk("Cell: 9940467636",
				PDFFont.getCourier06WithNormal());
		Paragraph initialParaGraph = new Paragraph(cellChunk);
		initialParaGraph.setAlignment(Element.ALIGN_LEFT);
		initialParaGraph.setFont(PDFFont.getCourier06WithNormal());
		initialParaGraph.setSpacingBefore(0);
		initialParaGraph.setIndentationLeft(50f);
		initialParaGraph.setLeading(15, 0);
		document.add(initialParaGraph);
		try {
			/*img = Image
					.getInstance("C:\\Users\\axj8041\\Desktop\\invoice_logo.png");*///E:\PROJECTS\INVOICE\ramana_engg\Reports
			img = Image
					.getInstance("E:\\PROJECTS\\INVOICE\\ramana_engg\\Reports\\rew_logo.png");

			// working one img.scaleAbsolute(40, 46);
			img.scaleAbsolute(40, 38);
			img.setIndentationLeft(50f);
			img.setAlignment(Element.ALIGN_LEFT);
			img.setIndentationLeft(50f);
			// img.setAbsolutePosition(75f, 75f);
			// img.setAbsolutePosition(0, PageSize.A4.getHeight() -
			// img.getScaledHeight());

			// img.setAbsolutePosition(-100f, 100f);
			// img.setSpacingBefore(50f);
			document.add(img);

			// for Delivery Challan.
			Chunk chunk = new Chunk("DELIVERY CHALLAN",
					PDFFont.getCourier08WithNormal());
			chunk.setUnderline(0f, -2f);
			chunk.setCharacterSpacing(0f);
			Paragraph paragraph1 = new Paragraph(chunk);
			paragraph1.setSpacingBefore(0);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			// paragraph1.setLeading(-10, 0);
			// working one.
			paragraph1.setLeading(-35, 0);
			// Chunk verticalChunk = new Chunk(new
			// VerticalPositionMark(),100,true);

			// LineSeparator lineSep = new
			// LineSeparator(1,100,BaseColor.BLUE,Element.ALIGN_CENTER,-2);
			// paragraph1.add(lineSep);

			// paragraph1.add(verticalChunk);

			// create a table for header content.
			PdfPTable pdfTable = new PdfPTable(2);
			float[] columnWidths = new float[] { 50f, 50f };
			pdfTable.setWidths(columnWidths);
			pdfTable.setWidthPercentage(90f);

			// cell1 for header starts here..
			Paragraph labelChunk = new Paragraph("RAMANA ENGINEERING WORKS",
					PDFFont.getCourier10WithBold());
			labelChunk.setIndentationLeft(70f);
			labelChunk.setSpacingAfter(0f);
			labelChunk.setLeading(10, 0);

			Paragraph labelChunk2 = new Paragraph(
					"\n (All Kinds of Turning works,Jigs,Fixtures,",
					PDFFont.getCourier06WithNormal());
			labelChunk2.setIndentationLeft(70f);
			labelChunk2.setSpacingBefore(0f);
			labelChunk2.setLeading(5, 0);

			Paragraph labelChunk3 = new Paragraph(
					"\n Job Work & Tool Room Works)\n",
					PDFFont.getCourier06WithNormal());
			labelChunk3.setIndentationLeft(70f);
			labelChunk3.setSpacingBefore(0f);
			labelChunk3.setLeading(4, 0);

			Chunk lblChunk = new Chunk(
					"No.1/252-B, Selvakumar Avenue, Thuraipakkam,Chennai-97,",
					PDFFont.getCourier06WithNormal());
			Paragraph labelParagraph1 = new Paragraph(lblChunk);
			labelParagraph1.setAlignment(Element.ALIGN_LEFT);
			labelParagraph1.setSpacingBefore(0f);
			labelParagraph1.setIndentationLeft(25f);
			labelParagraph1.setLeading(15, 0);

			Chunk labelChunk1 = new Chunk(
					"TIN No.: 33210927102/CST : 1017909/Dt:30-12-2010",
					PDFFont.getCourier06WithNormal());
			Paragraph labelParagraph2 = new Paragraph(labelChunk1);
			labelParagraph2.setAlignment(Element.ALIGN_LEFT);
			labelParagraph2.setLeading(12, 0);
			labelParagraph2.setSpacingBefore(0f);
			labelParagraph2.setIndentationLeft(25f);

			PdfPCell pdfCell1 = new PdfPCell();
			pdfCell1.addElement(labelChunk);
			pdfCell1.addElement(labelChunk2);
			pdfCell1.addElement(labelChunk3);
			pdfCell1.addElement(labelParagraph1);
			pdfCell1.addElement(labelParagraph2);
			pdfCell1.setBorder(PdfPCell.RIGHT);
			pdfCell1.setBorderColor(BaseColor.BLUE);

			// cell1 for header ends here..
			pdfTable.addCell(pdfCell1);

			Chunk cell2Chunk = new Chunk("No: " + deliveryChalanTO.getNo()
					+ "         " + "Date: "+deliveryChalanTO.getDate(), PDFFont.getCourier06WithNormal());
			DottedLineSeparator dottedLnSeperator1 = new DottedLineSeparator();
			dottedLnSeperator1.setLineWidth(0.8f);
			dottedLnSeperator1.setLineColor(BaseColor.BLUE);

			Chunk dottedChunk = new Chunk(dottedLnSeperator1);

			Paragraph cell2paragraph = new Paragraph();
			cell2paragraph.add(cell2Chunk);
			cell2paragraph.add(dottedChunk);
			cell2paragraph.setLeading(10, 0);
			cell2paragraph.setIndentationLeft(10f);
			cell2paragraph.setIndentationRight(40f);

			Chunk msChunk = new Chunk("\n M/s: "+deliveryChalanTO.getMs(),
					PDFFont.getCourier06WithNormal());
			DottedLineSeparator dottedLnSeperator2 = new DottedLineSeparator();
			dottedLnSeperator2.setLineWidth(0.8f);
			dottedLnSeperator2.setLineColor(BaseColor.BLUE);
			Chunk msChunk2 = new Chunk(dottedLnSeperator2);

			Paragraph cell2paragraph1 = new Paragraph();
			cell2paragraph1.add(msChunk);
			cell2paragraph1.add(msChunk2);
			cell2paragraph1.setLeading(7, 0);
			cell2paragraph1.setIndentationLeft(10f);
			cell2paragraph1.setIndentationRight(40f);

			Chunk dottedChunk3 = new Chunk("\n");
			DottedLineSeparator dottedLnSeperator3 = new DottedLineSeparator();
			dottedLnSeperator3.setLineWidth(0.8f);
			dottedLnSeperator3.setLineColor(BaseColor.BLUE);
			Chunk dottedChunk4 = new Chunk(dottedLnSeperator3);

			Paragraph cell2paragraph12 = new Paragraph();
			cell2paragraph12.add(dottedChunk3);
			cell2paragraph12.add(dottedChunk4);
			cell2paragraph12.setLeading(7, 0);
			cell2paragraph12.setIndentationLeft(10f);
			cell2paragraph12.setIndentationRight(40f);

			Chunk dottedChunk41 = new Chunk("\n");
			DottedLineSeparator dottedLnSeperator4 = new DottedLineSeparator();
			dottedLnSeperator4.setLineWidth(0.8f);
			dottedLnSeperator4.setLineColor(BaseColor.BLUE);
			Chunk dottedChunk5 = new Chunk(dottedLnSeperator4);

			Paragraph cell2paragraph13 = new Paragraph();
			cell2paragraph13.add(dottedChunk41);
			cell2paragraph13.add(dottedChunk5);
			cell2paragraph13.setLeading(7, 0);
			cell2paragraph13.setIndentationLeft(10f);
			cell2paragraph13.setIndentationRight(40f);

			PdfPCell pdfcell2 = new PdfPCell();

			pdfcell2.addElement(cell2paragraph);
			pdfcell2.addElement(cell2paragraph1);
			pdfcell2.addElement(cell2paragraph12);
			pdfcell2.addElement(cell2paragraph13);

			pdfcell2.setBorderColor(BaseColor.BLUE);
			pdfcell2.setBorder(PdfPCell.LEFT);

			pdfTable.addCell(pdfcell2);

			Chunk linebreakStart = new Chunk(new LineSeparator(0.7f, 80f,
					BaseColor.BLUE, Element.ALIGN_CENTER, -1));
			Paragraph paragraph6 = new Paragraph(linebreakStart);
			paragraph6.setAlignment(Element.ALIGN_CENTER);
			paragraph6.setSpacingBefore(0);
			paragraph6.setSpacingAfter(0);
			paragraph6.setExtraParagraphSpace(0);
			paragraph6.setLeading(-1, 0);

			// create another table ...
			PdfPTable pdfTable2 = new PdfPTable(2);
			float[] columnWidths2 = new float[] { 60f, 40f };
			pdfTable2.setWidths(columnWidths2);
			pdfTable2.setWidthPercentage(90f);

			Chunk deliveryChunk1 = new Chunk(
					"Please receive the following and return the duplicate copy duly signed.",
					PDFFont.getCourier06WithNormal());
			Paragraph deliveryParagraph = new Paragraph(deliveryChunk1);
			deliveryParagraph.setSpacingBefore(0f);
			deliveryParagraph.setAlignment(Element.ALIGN_CENTER);
			deliveryParagraph.setIndentationLeft(40f);
			deliveryParagraph.setLeading(8, 0);

			Chunk deliveryChunk2 = new Chunk(
					"    Order No: "+deliveryChalanTO.getOrderNo()+"	Date: "+deliveryChalanTO.getOrderDate(),
					PDFFont.getCourier06WithNormal());
			Paragraph deliveryParagraph2 = new Paragraph(deliveryChunk2);
			deliveryParagraph2.setSpacingBefore(0f);
			deliveryParagraph2.setAlignment(Element.ALIGN_LEFT);
			deliveryParagraph2.setIndentationRight(45f);
			deliveryParagraph2.setLeading(8, 0);

			PdfPCell pdfCellD1 = new PdfPCell();
			pdfCellD1.addElement(deliveryParagraph);
			pdfCellD1.setBorder(PdfPCell.RIGHT);
			pdfCellD1.setBorderColor(BaseColor.BLUE);

			pdfTable2.addCell(pdfCellD1);

			PdfPCell pdfCellD2 = new PdfPCell();
			pdfCellD2.addElement(deliveryParagraph2);
			pdfCellD2.setBorder(PdfPCell.LEFT);
			pdfCellD2.setBorderColor(BaseColor.BLUE);

			pdfTable2.addCell(pdfCellD2);

			// adding elements to documents here.

			document.add(paragraph1);
			pdfTable.setSpacingBefore(2f);
			document.add(pdfTable);
			document.add(paragraph6);
			pdfTable2.setSpacingBefore(1f);
			document.add(pdfTable2);

		} catch (MalformedURLException me) {
			throw new ProcessingException(Constants.MALFORMED_ELEMENT_EXCEPTION_ERROR, me.getMessage());
		} catch (IOException ioe) {
			throw new ProcessingException(Constants.IO_EXCEPTION_ERROR, ioe.getMessage());
		}

		return document;

	}
	
	private static Document addBodyContentForDeliveryChanal(Document document, DeliveryChalanTO deliveryChannelTO)throws DocumentException,ProcessingException
	{
		PdfPTable deiveryTable = new PdfPTable(4);
		float[] columnWidths4 = new float[]
				{10f, 45f,20f,25f};
		deiveryTable.setWidths(columnWidths4);
		deiveryTable.setWidthPercentage(80f);
		
		List<DeliveryItem> deleiveryItemsList = deliveryChannelTO.getDeliveryItemsList();
		
		PdfPCell headerCell1 = new PdfPCell(new Phrase("S.No.", PDFFont.getCourier06WithNormal()));
		headerCell1.setBorderColor(BaseColor.BLUE);
		headerCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		deiveryTable.addCell(headerCell1);
		
		PdfPCell headerCell2 = new PdfPCell(new Phrase("Description",PDFFont.getCourier06WithNormal()));
		headerCell2.setBorderColor(BaseColor.BLUE);
		headerCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		deiveryTable.addCell(headerCell2);
		
		PdfPCell headerCell3 = new PdfPCell(new Phrase("Qty",PDFFont.getCourier06WithNormal()));
		headerCell3.setBorderColor(BaseColor.BLUE);
		headerCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		deiveryTable.addCell(headerCell3);
		
		PdfPCell headerCell4 = new PdfPCell(new Phrase("Remarks",PDFFont.getCourier06WithNormal()));
		headerCell4.setBorderColor(BaseColor.BLUE);
		headerCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		deiveryTable.addCell(headerCell4);
		
		deiveryTable.setHeaderRows(1);
		PdfPCell pdfCell=null;
		int count=0;
		try {
			int listSize=deleiveryItemsList.size();
			for(DeliveryItem deliveryItem:deleiveryItemsList)
			{
				count++;
				if (count < listSize) {
					pdfCell = new PdfPCell(new Phrase(deliveryItem.getSerialNo(),
							PDFFont.getCourier06WithNormal()));
					pdfCell.setBorder(PdfPCell.LEFT);
					pdfCell.setBorderColor(BaseColor.BLUE);
					pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);

					deiveryTable.addCell(pdfCell);

					pdfCell = null;

					pdfCell = new PdfPCell(new Phrase(
							deliveryItem.getDescription(),
							PDFFont.getCourier06WithNormal()));
					pdfCell.setBorder(PdfPCell.LEFT);
					pdfCell.setBorderColor(BaseColor.BLUE);
					pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);

					deiveryTable.addCell(pdfCell);

					pdfCell = null;

					pdfCell = new PdfPCell(new Phrase(deliveryItem.getQuantity(),
							PDFFont.getCourier06WithNormal()));
					pdfCell.setBorder(PdfPCell.LEFT);
					pdfCell.setBorderColor(BaseColor.BLUE);
					pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);

					deiveryTable.addCell(pdfCell);

					pdfCell = null;

					pdfCell = new PdfPCell(new Phrase(deliveryItem.getRemarks(),
							PDFFont.getCourier06WithNormal()));
					pdfCell.setBorder(PdfPCell.RIGHT);
					pdfCell.enableBorderSide(Rectangle.LEFT);
					pdfCell.enableBorderSide(Rectangle.RIGHT);
					pdfCell.setBorderColor(BaseColor.BLUE);
					pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);

					deiveryTable.addCell(pdfCell);

					pdfCell = null;
				}
				else
				{
					pdfCell = new PdfPCell(new Phrase(deliveryItem.getSerialNo(), PDFFont.getCourier06WithNormal()));
					pdfCell.setBorderColor(BaseColor.BLUE);
					pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pdfCell.disableBorderSide(PdfPCell.TOP);
					deiveryTable.addCell(pdfCell);
					
					pdfCell = null;
					
					pdfCell = new PdfPCell(new Phrase(deliveryItem.getDescription(), PDFFont.getCourier06WithNormal()));
					pdfCell.setBorderColor(BaseColor.BLUE);
					pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pdfCell.disableBorderSide(PdfPCell.TOP);
					deiveryTable.addCell(pdfCell);
					
					pdfCell = null;
					
					pdfCell = new PdfPCell(new Phrase(deliveryItem.getQuantity(), PDFFont.getCourier06WithNormal()));
					pdfCell.setBorderColor(BaseColor.BLUE);
					pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pdfCell.disableBorderSide(PdfPCell.TOP);
					deiveryTable.addCell(pdfCell);
					
					pdfCell = null;
					
					pdfCell = new PdfPCell(new Phrase(deliveryItem.getRemarks(), PDFFont.getCourier06WithNormal()));
					pdfCell.setBorderColor(BaseColor.BLUE);
					pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pdfCell.disableBorderSide(PdfPCell.TOP);
					deiveryTable.addCell(pdfCell);
					
					pdfCell = null;
					
				}
				
			}
			
			document.add(deiveryTable);
			return document;
		} catch (Exception e) {
			throw new ProcessingException(Constants.UNKNOWN_ERROR, e.getMessage());
		}
	}
	
	/**
	 * @param document - Document object.
	 * @param deliveryItemsList - List of DeliveryItem objects.
	 * @return Document - the Document object.
	 * @throws DocumentException
	 * @throws ProcessingException
	 */
	private static void addOrdersTable(Document document,
			List<DeliveryChalanTO> ordersList) throws DocumentException,
			ProcessingException {
		try {
			PdfPTable pdfTable = new PdfPTable(5);
			pdfTable.setSpacingBefore(10f);

			float[] columnWidths = new float[] { 10f, 22.5f, 22.5f, 22.5f,
					22.5f };
			pdfTable.setWidths(columnWidths);
			pdfTable.setWidthPercentage(90f);

			// cell1.
			PdfPCell pdfCell1 = new PdfPCell(new Phrase("SI.No.",
					PDFFont.getCourier06WithNormal()));
			pdfCell1.setBorderColor(BaseColor.BLUE);
			pdfCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell1.setRowspan(10);
			pdfTable.addCell(pdfCell1);

			// cell2.
			PdfPCell pdfCell2 = new PdfPCell(new Phrase("Your Order No",
					PDFFont.getCourier06WithNormal()));
			pdfCell2.setBorderColor(BaseColor.BLUE);
			pdfCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell2.setRowspan(10);
			pdfTable.addCell(pdfCell2);

			// cell3.
			PdfPCell pdfCell3 = new PdfPCell(new Phrase("Your Order Date",
					PDFFont.getCourier06WithNormal()));
			pdfCell3.setBorderColor(BaseColor.BLUE);
			pdfCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell3.setRowspan(10);
			pdfTable.addCell(pdfCell3);

			// cell4.
			PdfPCell pdfCell4 = new PdfPCell(new Phrase("Our D.C.No",
					PDFFont.getCourier06WithNormal()));
			pdfCell4.setBorderColor(BaseColor.BLUE);
			pdfCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell4.setRowspan(10);
			pdfTable.addCell(pdfCell4);

			// cell4.
			PdfPCell pdfCell5 = new PdfPCell(new Phrase("Our D.C.Date",
					PDFFont.getCourier06WithNormal()));
			pdfCell5.setBorderColor(BaseColor.BLUE);
			pdfCell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			// pdfCell4.setRowspan(10);
			pdfTable.addCell(pdfCell5);

			pdfTable.setHeaderRows(1);

			for (DeliveryChalanTO orderObj : ordersList) {

				// serial no:-
				PdfPCell pdfCell = new PdfPCell(new Phrase(
						orderObj.getSerialNo(),
						PDFFont.getCourier06WithNormal()));
				// pdfCell.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				// pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfTable.addCell(pdfCell);

				pdfCell = null;

				// Your Order No.
				pdfCell = new PdfPCell(new Phrase(
						orderObj.getOrderNo(),
						PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				// pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfTable.addCell(pdfCell);

				pdfCell = null;

				// Your Order Date.
				pdfCell = new PdfPCell(new Phrase(
						orderObj.getOrderDate(),
						PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				// pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfTable.addCell(pdfCell);

				pdfCell = null;

				// Our D.C.No
				pdfCell = new PdfPCell(new Phrase(orderObj.getNo(),
						PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				// pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(pdfCell);
				pdfCell = null;

				// Our D.C.Date
				pdfCell = new PdfPCell(new Phrase(
						orderObj.getDate(),
						PDFFont.getCourier06WithNormal()));
				// pdfCell22.setRowspan(1);
				// pdfCell.setBorder(Rectangle.NO_BORDER);
				// pdfCell.setBorder(PdfPCell.LEFT);
				pdfCell.setBorderColor(BaseColor.BLUE);
				pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(pdfCell);

				pdfCell = null;
			}

			document.add(pdfTable);

		} catch (Exception e) {
			throw new ProcessingException(Constants.UNKNOWN_ERROR,
					e.getMessage());
		}
		return ;
	}
	
	private static void addBillTable(Document document, Invoice1 invoiceObj)throws DocumentException,ProcessingException
	{
		
	    try
	    {
	    	
	   
			PdfPTable billTable = new PdfPTable(2);
			billTable.setSpacingBefore(10f);
			float[] columnWidths = new float[] {50f, 50f};
			billTable.setWidths(columnWidths);
			billTable.setWidthPercentage(90f);
			
			// cell1.
			PdfPCell billCell1 = new PdfPCell(new Phrase("         Bill No"   ,	PDFFont.getCourier06WithNormal()));
			billCell1.setBorderColor(BaseColor.BLUE);
			billCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			//pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			//pdfCell1.setRowspan(10);
			billTable.addCell(billCell1);
			
			
			// cell1.
			PdfPCell billCell2 = new PdfPCell(new Phrase("         Date "   ,	PDFFont.getCourier06WithNormal()));
			billCell2.setBorderColor(BaseColor.BLUE);
			billCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			//pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			//pdfCell1.setRowspan(10);
			billTable.addCell(billCell2);
			
			//billTable.setHeaderRows(1);

			
			PdfPCell billCell21 = new PdfPCell(new Phrase(invoiceObj.getToMs(),	PDFFont.getCourier06WithNormal()));
			// pdfCell.setRowspan(1);
			// pdfCell.setBorder(Rectangle.NO_BORDER);
			// pdfCell.setBorder(PdfPCell.LEFT);
			billCell21.setBorderColor(BaseColor.BLUE);
			billCell21.setHorizontalAlignment(Element.ALIGN_LEFT);
			billCell21.setColspan(2);
			// pdfCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			billTable.addCell(billCell21);

	    	
			document.add(billTable);
			
	    }
	    catch(Exception e)
	    {
	    	throw new ProcessingException(Constants.UNKNOWN_ERROR, e.getMessage());
	    }
		return ;
	}
}
