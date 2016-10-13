package com.pb.data.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Invoice implements Serializable
{

private static final long serialVersionUID = -7536173576050063557L;

private String billNumber;
private String billDate;
private String yourOrderNo;
private String orderDate;
private String ourDcNo;
private String dcDate;
private String toMs;
private String partyTinNo;
private String vat;
private String serviceTaxLabel;
private String serviceTaxPercentage;

private List<DeliveryChalanTO> deliveryChallansList = new ArrayList<>();
private List<Item> itemsList = new ArrayList<>();

public List<Item> getItemsList()
{
	return itemsList;
}
public void setItemsList(List<Item> itemsList)
{
	this.itemsList = itemsList;
}
public String getBillNumber()
{
	return billNumber;
}
public void setBillNumber(String billNumber)
{
	this.billNumber = billNumber;
}
public String getBillDate()
{
	return billDate;
}
public void setBillDate(String billDate)
{
	this.billDate = billDate;
}
public String getYourOrderNo()
{
	return yourOrderNo;
}
public void setYourOrderNo(String yourOrderNo)
{
	this.yourOrderNo = yourOrderNo;
}
public String getOrderDate()
{
	return orderDate;
}
public void setOrderDate(String orderDate)
{
	this.orderDate = orderDate;
}
public String getOurDcNo()
{
	return ourDcNo;
}
public void setOurDcNo(String ourDcNo)
{
	this.ourDcNo = ourDcNo;
}
public String getDcDate()
{
	return dcDate;
}
public void setDcDate(String dcDate)
{
	this.dcDate = dcDate;
}
public String getToMs()
{
	return toMs;
}
public void setToMs(String toMs)
{
	this.toMs = toMs;
}
public String getPartyTinNo()
{
	return partyTinNo;
}
public void setPartyTinNo(String partyTinNo)
{
	this.partyTinNo = partyTinNo;
}
/**
 * @return the vat
 */
public String getVat() {
	return vat;
}
/**
 * @param vat the vat to set
 */
public void setVat(String vat) {
	this.vat = vat;
}




}
