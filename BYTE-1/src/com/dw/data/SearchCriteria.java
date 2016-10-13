package com.dw.data;

import java.io.Serializable;

public class SearchCriteria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerName;
	private String customerId;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	

}
