package com.pb.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateUtils {

	// single d and M handles both digits but two digit d and M forces to prepend zero
	private static final String DEFAULT_LOCAL_DATE_FORMAT_TXT="d-M-yyyy";
	
	private static final String DEFAULT_SIMPLE_DATE_FORMAT="d-M-yyyy";
	
	
	public static java.util.Date stringToUtilDate( String  dateComingFromUIScreen){
		java.util.Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_SIMPLE_DATE_FORMAT);
		try {
			date = sdf.parse(dateComingFromUIScreen);
		} catch (ParseException e) {
			throw new RuntimeException("parse failed");
		}
		return date;
	}

	public static java.sql.Date stringToSqlDate( String  dateComingFromUIScreen){
	    
	    	return DateUtils.toSqlDate(DateUtils.toLocalDate(dateComingFromUIScreen));
		
	}

	public static String utilDateToString( java.util.Date date){
	     String dateInString = null;
	     SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_SIMPLE_DATE_FORMAT);
	     dateInString = sdf.format(date);
	     return dateInString;
	}

	public static String sqlDateString( java.sql.Date  date){
	      String dateInString = null;
		     SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_SIMPLE_DATE_FORMAT);
		     dateInString = sdf.format(date);
		     return dateInString;
	}
	
	/**
	 * LocalDate is new api from java 8 on wards.
	 * @param dateComingFromUIScreen
	 * @param format
	 * @return
	 */
	
	public static LocalDate toLocalDate(String date){
		return toLocalDate(date,DEFAULT_LOCAL_DATE_FORMAT_TXT);
	}
	public static LocalDate toLocalDate( String  dateComingFromUIScreen,String format){
		LocalDate date = null;
		if(Objects.nonNull(dateComingFromUIScreen) && Objects.nonNull(format)){
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
			date = LocalDate.parse(dateComingFromUIScreen, dateFormat);
		}
		return date;
	}
	
	
	public static String toString( LocalDate date){
		return toString(date,DEFAULT_LOCAL_DATE_FORMAT_TXT);
	}
	
	
	public static String toString( LocalDate date,String format){
		String dateInString = null;
		if(Objects.nonNull(date)){
			dateInString = date.format(DateTimeFormatter.ofPattern(format));
		}
		return dateInString;
	}

	
	public static java.sql.Date toSqlDate(LocalDate date){
		return  Objects.nonNull(date)  ? java.sql.Date.valueOf(date) : null;
	}
	
	public static LocalDate toLocalDate(java.sql.Date date){
		return Objects.nonNull(date) ? date.toLocalDate() : null;
	}
}
