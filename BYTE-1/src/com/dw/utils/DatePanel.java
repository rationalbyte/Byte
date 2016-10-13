package com.dw.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class DatePanel {

	public static JXDatePicker getDateUI() {
		JXDatePicker picker = new JXDatePicker();
		picker.setFont(new java.awt.Font("Ubuntu", 0, 18));
		picker.setDate(Calendar.getInstance().getTime());
		picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));

		return picker;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("JXPicker Example");
		JPanel panel = new JPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(400, 400, 250, 100);

		JXDatePicker picker = new JXDatePicker();
		picker.setFont(new java.awt.Font("Ubuntu", 0, 18));
		picker.setDate(Calendar.getInstance().getTime());
		picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));

		panel.add(picker);
		frame.getContentPane().add(panel);

		frame.setVisible(true);
	}
}