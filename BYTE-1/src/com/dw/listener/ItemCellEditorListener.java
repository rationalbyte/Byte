/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dw.listener;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author samuel
 */
public class ItemCellEditorListener implements CellEditorListener {

    @Override
    public void editingStopped(ChangeEvent e) {
        System.out.println("Stopped");
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
        System.out.println("Cancelled");
    }

}
