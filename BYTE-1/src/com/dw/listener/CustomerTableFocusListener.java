/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dw.listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author samuel
 */
public class CustomerTableFocusListener implements FocusListener{

    @Override
    public void focusGained(FocusEvent e) {
        System.out.print(e.getSource().toString());
    }

    @Override
    public void focusLost(FocusEvent e) {
      System.out.print(e.getSource().toString());
    }
    
}
