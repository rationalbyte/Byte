/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dw.utils;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author samuel
 */
public class ItemTableModel extends AbstractTableModel {

    ArrayList<ArrayList<String>> model = new ArrayList<ArrayList<String>>();
    String columns[] = {"SNO", "PARTICULARS", "QTY", "PER", "RATE", "AMOUNT RS", "AMOUNT PRICE"};

    public ItemTableModel() {
        ArrayList<String> aux = new ArrayList<String>();
        aux.add("PARTICULARS1");
        aux.add("5");
        aux.add("6");
        aux.add("16");
        aux.add("1200");
        aux.add("00");
        model.add(aux);
        ArrayList<String> aux1 = new ArrayList<String>();
        aux1.add("PARTICULARS2");
        aux1.add("24");
        aux1.add("8");
        aux1.add("13");
        aux1.add("2500");
        aux1.add("00");
        model.add(aux1);

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
        model.add(aux);
    }

}
