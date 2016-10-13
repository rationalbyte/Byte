package com.pb.re.gui;

import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import java.awt.event.*;

public class PrintPanel extends JPanel implements
        Printable {

    JButton ok = new JButton("OK");

    public PrintPanel() {
       
    }

    
 

    public int print(Graphics g, PageFormat pf, int index) throws
            PrinterException {

        Graphics2D g2 = (Graphics2D) g;
        if (index >= 1) {
            return Printable.NO_SUCH_PAGE;
        } else {

            ok.printAll(g2);
            return Printable.PAGE_EXISTS;
        }

    }
}