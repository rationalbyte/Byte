/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dw.rendere;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author samuel
 */
public class ItemTableCellRenderer implements TableCellRenderer{
 JComponent rendere = new JTextField();
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
     //   rendere=new JTextField();
        rendere.setToolTipText("Values at:"+row+":"+column);
      
       ((JTextField) rendere).setText( value+"");
       return rendere;
    }
    
}
