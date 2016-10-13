/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dw.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author samuel
 */
public class ItemDetailsTableModel extends AbstractTableModel {

    ArrayList<ArrayList<String>> model = new ArrayList<ArrayList<String>>();
    String columns[] = {"Sno", "Item Name", "Metal", "Item Weight", "Rate per Gram", "Amount Approved"};

    public ItemDetailsTableModel() {
        ArrayList<String> aux = new ArrayList<String>();
        aux.add("Item Name");
        aux.add("Metal");
        aux.add("Item Weight");
        aux.add("Rate per Gram");
        aux.add("Amount Approved");
        //     model.add(aux);

    }

    public ArrayList<ArrayList<String>> getModel() {
        return model;
    }

    public void addRow(ArrayList<String> aux) {
        model.add(aux);
        super.fireTableDataChanged();
    }

    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public int getRowCount() {
        return model.size();

    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return rowIndex + 1;
        }

        return model.get(rowIndex).get(columnIndex - 1);
    }

    void add(ArrayList<String> aux) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
