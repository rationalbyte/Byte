package com.dw.data;

import java.io.Serializable;

public class Item implements Serializable
{

private static final long serialVersionUID = 3589810903425538494L;
private String serialNo;
private String particulars;
private String qty;
private String perRate;
private String per;
private String amountInRupees;
private String amountInPaise;
private String allItemsAmnt;

public String getAllItemsAmnt()
{
	return allItemsAmnt;
}
public void setAllItemsAmnt(String allItemsAmnt)
{
	this.allItemsAmnt = allItemsAmnt;
}
public String getPer()
{
	return per;
}
public void setPer(String per)
{
	this.per = per;
}
public String getSerialNo()
{
	return serialNo;
}
public void setSerialNo(String serialNo)
{
	this.serialNo = serialNo;
}
public String getParticulars()
{
	return particulars;
}
public void setParticulars(String particulars)
{
	this.particulars = particulars;
}
public String getQty()
{
	return qty;
}
public void setQty(String qty)
{
	this.qty = qty;
}
public String getPerRate()
{
	return perRate;
}
public void setPerRate(String perRate)
{
	this.perRate = perRate;
}
public String getAmountInRupees()
{
	return amountInRupees;
}
public void setAmountInRupees(String amountInRupees)
{
	this.amountInRupees = amountInRupees;
}
public String getAmountInPaise()
{
	return amountInPaise;
}
public void setAmountInPaise(String amountInPaise)
{
	this.amountInPaise = amountInPaise;
}

}
