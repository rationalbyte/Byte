package com.pb.data.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author AVemula
 *
 */
public class CustomerData implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerId;
	private String dateOfPayment;
	private String customerName;
	private String fatherName;
	private String address1;
	private String address2;
	private String address3;
	private String rateOfInterest;
	private String principalAmt;
	private String outStandingAmt;//Out Standing Amount
	private String dateOfReceipt;
	private String amountPaidStatus;
	private String ratePerGram;
	
	private ArrayList<ItemData> itemList = new ArrayList<ItemData>();
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}
	/**
	 * @param address3 the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	/**
	 * @return the rateOfInterest
	 */
	public String getRateOfInterest() {
		return rateOfInterest;
	}
	/**
	 * @param rateOfInterest the rateOfInterest to set
	 */
	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	/**
	 * @return the outStandingAmt
	 */
	public String getOutStandingAmt() {
		return outStandingAmt;
	}
	/**
	 * @param outStandingAmt the outStandingAmt to set
	 */
	public void setOutStandingAmt(String outStandingAmt) {
		this.outStandingAmt = outStandingAmt;
	}
	/**
	 * @return the dateOfPayment
	 */
	public String getDateOfPayment() {
		return dateOfPayment;
	}
	/**
	 * @param dateOfPayment the dateOfPayment to set
	 */
	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	/**
	 * @return the amountPaidStatus
	 */
	public String getAmountPaidStatus() {
		return amountPaidStatus;
	}
	/**
	 * @param amountPaidStatus the amountPaidStatus to set
	 */
	public void setAmountPaidStatus(String amountPaidStatus) {
		this.amountPaidStatus = amountPaidStatus;
	}
	/**
	 * @return the itemList
	 */
	public ArrayList<ItemData> getItemList() {
		return itemList;
	}
	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(ArrayList<ItemData> itemList) {
		this.itemList = itemList;
	}
	public String getDateOfReceipt() {
		return dateOfReceipt;
	}
	public void setDateOfReceipt(String dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}
	public String getPrincipalAmt() {
		return principalAmt;
	}
	public void setPrincipalAmt(String principalAmt) {
		this.principalAmt = principalAmt;
	}

	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}
	public String getRatePerGram() {
		return ratePerGram;
	}
	public void setRatePerGram(String ratePerGram) {
		this.ratePerGram = ratePerGram;
	}  
	
	
	
	
}
