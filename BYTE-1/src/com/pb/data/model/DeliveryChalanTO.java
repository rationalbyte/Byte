package com.pb.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeliveryChalanTO  implements Serializable{

	
	private static final long serialVersionUID = -6543004828218079669L;
	
	private String no;
	private String date;
	private String ms;
	private String orderNo;
	private String orderDate;
	private String serviceTaxLabel;
	private String serviceTaxPercentage;
	private String partyTinNo;
	private String serialNo;
	private String companyName;
	private String dcStatus;
	
	private List<DeliveryItem> deliveryItemsList = new ArrayList<DeliveryItem>();

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<DeliveryItem> getDeliveryItemsList() {
		return deliveryItemsList;
	}

	public void setDeliveryItemsList(List<DeliveryItem> deliveryItemsList) {
		this.deliveryItemsList = deliveryItemsList;
	}

	/**
	 * @return the serviceTaxLabel
	 */
	public String getServiceTaxLabel() {
		return serviceTaxLabel;
	}

	/**
	 * @param serviceTaxLabel the serviceTaxLabel to set
	 */
	public void setServiceTaxLabel(String serviceTaxLabel) {
		this.serviceTaxLabel = serviceTaxLabel;
	}

	/**
	 * @return the serviceTaxPercentage
	 */
	public String getServiceTaxPercentage() {
		return serviceTaxPercentage;
	}

	/**
	 * @param serviceTaxPercentage the serviceTaxPercentage to set
	 */
	public void setServiceTaxPercentage(String serviceTaxPercentage) {
		this.serviceTaxPercentage = serviceTaxPercentage;
	}

	/**
	 * @return the partyTinNo
	 */
	public String getPartyTinNo() {
		return partyTinNo;
	}

	/**
	 * @param partyTinNo the partyTinNo to set
	 */
	public void setPartyTinNo(String partyTinNo) {
		this.partyTinNo = partyTinNo;
	}

	/**
	 * @return the serialNo
	 */
	public String getSerialNo() {
		return serialNo;
	}

	/**
	 * @param serialNo the serialNo to set
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the dcStatus
	 */
	public String getDcStatus() {
		return dcStatus;
	}

	/**
	 * @param dcStatus the dcStatus to set
	 */
	public void setDcStatus(String dcStatus) {
		this.dcStatus = dcStatus;
	}
	
	
	
	
	
	
	

	
}
