package com.dw.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class DCTableModel extends AbstractTableModel {
	public ArrayList<ArrayList<String>> getModel() {
		return model;
	}

	public void setModel(ArrayList<ArrayList<String>> model) {
		this.model = model;
	}

	ArrayList<ArrayList<String>> model = new ArrayList<ArrayList<String>>();
	String columns[] = { "Sno", "Description", "Qty", "Per", "Rate", "Remarks" };

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return model.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	public String getColumnName(int i) {
		return columns[i];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return model.get(rowIndex).get(columnIndex);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ArrayList<String> currVal=model.get(rowIndex);
		currVal.set(columnIndex, aValue.toString());
		System.out.println(aValue);
	}

	public boolean isCellEditable(int r, int c) {
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void add(ArrayList<String> row) {
		model.add(row);
		fireTableDataChanged();
	}

}
