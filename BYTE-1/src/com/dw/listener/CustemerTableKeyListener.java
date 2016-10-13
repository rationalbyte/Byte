/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dw.listener;

import com.dw.model.ItemDetailsTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author samuel
 */
public class CustemerTableKeyListener implements KeyListener {

    JTable jTable1 = null;
    ItemDetailsTableModel model = null;

    int del = 127;

    public CustemerTableKeyListener(JTable jTable1, ItemDetailsTableModel model) {
        this.jTable1 = jTable1;
        this.model = model;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (del == (int) e.getKeyChar()) {
          ArrayList<ArrayList<String>> auxModel = new ArrayList<ArrayList<String>>();
            int rows[] = jTable1.getSelectedRows();
            int len = rows.length;
            ArrayList<String> aux = null;
            for (int i = 0; i < len; i++) {
                aux = model.getModel().get(rows[i]);
                auxModel.add(aux);
                
            }
            len = auxModel.size();
            for (int i = 0; i < len; i++) {
                aux = auxModel.get(i);
                model.getModel().remove(aux);
            }
            model.fireTableDataChanged();
            
 
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
