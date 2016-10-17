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
public class CustomerTableModel extends AbstractTableModel {

    ArrayList<ArrayList<String>> model = new ArrayList<ArrayList<String>>();
    String columns[] = {" Sno ", "Order No", "Order Date", "DC No", "DC Date"};

    public CustomerTableModel() {
        ArrayList<String> aux = new ArrayList<String>();
        aux.add("1");
        aux.add("Order No");
        aux.add("Order Date");
        aux.add("Our DC No");
        aux.add("Our DC Date");
        model.add(aux);
       

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
        return model.get(rowIndex).get(columnIndex);
    }

    public ArrayList<ArrayList<String>> getModel() {
        return model;
    }
}
