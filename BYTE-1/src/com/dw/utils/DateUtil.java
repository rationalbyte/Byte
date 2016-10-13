package com.dw.utils;

//Later I will capture this as method in Utility Class.


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
 //Needs to be improved.
 public static Date convertStringToDate(String dtString){
     Date dt = new Date(1,2,3);
     return dt;
 }
 
 public static void main(String args[]){
     //Date convertion  Util date to String
     Date date = Calendar.getInstance().getTime();
     DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
     String today = formatter.format(date);
     System.out.println("Today : " + today);
     
     // SQL Date to String.
     java.sql.Date dt = new java.sql.Date(System.currentTimeMillis());
     String todayMysql = formatter.format(dt);
     System.out.println("My SQL Today : " + todayMysql);
     
     String dateInString = "12-05-2015";
     try {
         Date strToDate = formatter.parse(dateInString); // String to UtilDate
         System.out.println("String to Date section"+strToDate);
         System.out.println("String to Date section"+formatter.format(strToDate));
         
         java.sql.Date strToDateMysql = new java.sql.Date(strToDate.getTime());//Util date to sql Date
         System.out.println("String to SQL Date section"+strToDateMysql);
         System.out.println("String to SQL Date section"+formatter.format(strToDateMysql));
     } catch (ParseException e) {
         e.printStackTrace();
     }
 }

}
