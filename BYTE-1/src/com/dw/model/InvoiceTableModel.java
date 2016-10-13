package com.dw.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class InvoiceTableModel extends AbstractTableModel {
	String names[] = { "Sr No", "Our DC NO", "Particulars", "Qty", "Per", "Rate", "Amount" };
	ArrayList<ArrayList<String>> model = new ArrayList<ArrayList<String>>();

	public InvoiceTableModel() {
		// TODO Auto-generated constructor stub
		ArrayList<String> row = new ArrayList<String>();
		row.add("1");
		row.add("2");
		row.add("3");
		row.add("4");
		row.add("5");
		row.add("6");
		row.add("7");
		model.add(row);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return model.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	public String getColumnName(int col) {
		return names[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return model.get(rowIndex).get(columnIndex);
	}

}
