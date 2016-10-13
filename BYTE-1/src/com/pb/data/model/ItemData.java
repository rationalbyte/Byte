package com.pb.data.model;

import java.io.Serializable;

/**
 * @author AVemula
 *
 */
public class ItemData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemId;
	private String itemName;
	private String metal;
	private String weight;
	private String quantity;
	private String itemPa;
	private String customerId;
	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the metal
	 */
	public String getMetal() {
		return metal;
	}
	/**
	 * @param metal the metal to set
	 */
	public void setMetal(String metal) {
		this.metal = metal;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getItemPa() {
		return itemPa;
	}
	public void setItemPa(String itemPa) {
		this.itemPa = itemPa;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
	

}
