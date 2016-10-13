package com.pb.data.model;

import java.io.Serializable;

public class DeliveryItem implements Serializable{

	
	private static final long serialVersionUID = -3272471237832867553L;
	private String serialNo;
	//description field is used for both Description and Particulars
	private String description; 
	private String quantity;
	private String remarks;
	private String per;////DeliveryItem.per
	private String rate;
	private String ourDcNo;//
	
	private String amountInRupees;
	private String amountInPaise;
	
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the per
	 */
	public String getPer() {
		return per;
	}
	/**
	 * @param per the per to set
	 */
	public void setPer(String per) {
		this.per = per;
	}
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @return the ourDcNo
	 */
	public String getOurDcNo() {
		return ourDcNo;
	}
	/**
	 * @param ourDcNo the ourDcNo to set
	 */
	public void setOurDcNo(String ourDcNo) {
		this.ourDcNo = ourDcNo;
	}
	/**
	 * @return the amountInRupees
	 */
	public String getAmountInRupees() {
		return amountInRupees;
	}
	/**
	 * @param amountInRupees the amountInRupees to set
	 */
	public void setAmountInRupees(String amountInRupees) {
		this.amountInRupees = amountInRupees;
	}
	/**
	 * @return the amountInPaise
	 */
	public String getAmountInPaise() {
		return amountInPaise;
	}
	/**
	 * @param amountInPaise the amountInPaise to set
	 */
	public void setAmountInPaise(String amountInPaise) {
		this.amountInPaise = amountInPaise;
	}
	
	
	
	
	
	
	
	
	
}
