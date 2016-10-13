/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dw.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author samuel
 */
public class CustomerTableSelectionListener implements ListSelectionListener{

    @Override
    public void valueChanged(ListSelectionEvent e) {
    
        System.out.println("Slected Row Index:"+e.getFirstIndex());
    }
    
}
