/**
 * 
 */
package com.pb.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 *
 */
public class Invoice1 {


	private static final long serialVersionUID = -7536173576050063557L;
	
	private String billNumber; // Auto generated Number primary key
	private String billDate; // System Date
	private String serviceTaxLabel;//Display Purpose . coming from DC table    Invoice1.serviceTaxLabel
	private String serviceTaxPercentage;//Display Purpose . coming from DC table  Invoice1.serviceTaxPercentage
	private String partyTinNo;// Take this value from 1st recored of Delivery Challan table
	private String toMs;// Take this value from 1st recored of Delivery Challan table
	//private String vat;
	private List<DeliveryChalanTO> deliveryChallansList = new ArrayList<>();
	private List<DeliveryItem> itemsList = new ArrayList<>();
	private String dcIds;
	private String tax;
	private String total;
	/**
	 * @return the billNumber
	 */
	public String getBillNumber() {
		return billNumber;
	}
	/**
	 * @param billNumber the billNumber to set
	 */
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	/**
	 * @return the billDate
	 */
	public String getBillDate() {
		return billDate;
	}
	/**
	 * @param billDate the billDate to set
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
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
	 * @return the toMs
	 */
	public String getToMs() {
		return toMs;
	}
	/**
	 * @param toMs the toMs to set
	 */
	public void setToMs(String toMs) {
		this.toMs = toMs;
	}
	/**
	 * @return the deliveryChallansList
	 */
	public List<DeliveryChalanTO> getDeliveryChallansList() {
		return deliveryChallansList;
	}
	/**
	 * @param deliveryChallansList the deliveryChallansList to set
	 */
	public void setDeliveryChallansList(List<DeliveryChalanTO> deliveryChallansList) {
		this.deliveryChallansList = deliveryChallansList;
	}
	/**
	 * @return the itemsList
	 */
	public List<DeliveryItem> getItemsList() {
		return itemsList;
	}
	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(List<DeliveryItem> itemsList) {
		this.itemsList = itemsList;
	}
	/**
	 * @return the dcIds
	 */
	public String getDcIds() {
		return dcIds;
	}
	/**
	 * @param dcIds the dcIds to set
	 */
	public void setDcIds(String dcIds) {
		this.dcIds = dcIds;
	}
	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	/**
	 * @return the tax
	 */
	public String getTax() {
		return tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}
	


}
