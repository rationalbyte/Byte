package com.pb.pdf.generation;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;


public class PDFFont {

	public static final float size6=6f;	
	public static final float size7=7f;
	public static final float size8=8f;
	public static final float size14=14f;
	public static final float size10=10f;
	
	public static final float size12=12f;
	
	private static Font courier06WithNormal = 
			FontFactory.getFont(FontFactory.HELVETICA, size6, Font.NORMAL,BaseColor.BLUE);
	
	private static Font courier06WithBold = 
			FontFactory.getFont(FontFactory.HELVETICA, size6, Font.BOLD,BaseColor.BLUE);
			
	private static Font courier07WithBold = 
			FontFactory.getFont(FontFactory.HELVETICA, size7, Font.BOLD,BaseColor.BLUE);
	
	private static Font courier08WithNormal = 
			FontFactory.getFont(FontFactory.HELVETICA, size8, Font.NORMAL,BaseColor.BLUE);

	private static Font courier08WithBold = 
			FontFactory.getFont(FontFactory.HELVETICA, size8, Font.BOLD,BaseColor.BLUE);
	
	private static Font courier10WithBold = 
			FontFactory.getFont(FontFactory.HELVETICA, size10, Font.BOLD,BaseColor.BLUE);
	
	private static Font courier12WithBold = 
			FontFactory.getFont(FontFactory.HELVETICA, size12, Font.BOLD,BaseColor.BLUE);
	

	public static Font getCourier10WithBold() {
		return courier10WithBold;
	}


	public static void setCourier10WithBold(Font courier10WithBold) {
		PDFFont.courier10WithBold = courier10WithBold;
	}


	public static Font getCourier12WithBold() {
		return courier12WithBold;
	}


	public static void setCourier12WithBold(Font courier12WithBold) {
		PDFFont.courier12WithBold = courier12WithBold;
	}


	public static void setCourier14WithBold(Font courier14WithBold) {
		PDFFont.courier14WithBold = courier14WithBold;
	}

	public static Font getCourier08WithBold()
	{
		return courier08WithBold;
	}

	private static Font courier14WithBold = 
			FontFactory.getFont(FontFactory.HELVETICA,size14,Font.BOLD,BaseColor.BLUE);
	
	
	public static Font getCourier14WithBold() {
		return courier14WithBold;
	}


	public static Font getCourier08WithNormal() {
		return courier08WithNormal;
	}
	

	public static Font getCourier06WithNormal() {
		return courier06WithNormal;
	}

	public static Font getCourier06WithBold() {
		return courier06WithBold;
	}

	public static Font getCourier07WithBold() {
		return courier07WithBold;
	}



}
