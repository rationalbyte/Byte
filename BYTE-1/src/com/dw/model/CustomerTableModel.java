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
    String columns[] = {" Sno ", "Your Order No", "Your Order Date", "Our DC No", "Our DC Date"};

    public CustomerTableModel() {
        ArrayList<String> aux = new ArrayList<String>();
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
        model.add(aux);
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
        model.add(aux);
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
        model.add(aux);
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
        model.add(aux);
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
        model.add(aux);
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
        model.add(aux);
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
        model.add(aux);
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
        model.add(aux);
        aux.add("aaa");
        aux.add("bbb");
        aux.add("ccc");
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
