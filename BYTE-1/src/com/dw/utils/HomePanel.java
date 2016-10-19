package com.dw.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.dw.model.CustomerTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samuel
 */
public class HomePanel extends javax.swing.JFrame {
	javax.swing.JTabbedPane jTabbedPane1 = null;
	CreateDCPanel cdPanel = null;
	CustomerTableModel customerTableModel = null;

	JComboBox<String> itemsList = null;

	public JComboBox<String> getItemsList() {
		return itemsList;
	}

	public void setItemsList(JComboBox<String> itemsList) {
		this.itemsList = itemsList;
	}

	public CustomerTableModel getCustomerTableModel() {
		return customerTableModel;
	}

	public void setCustomerTableModel(CustomerTableModel customerTableModel) {
		this.customerTableModel = customerTableModel;
	}

	public CreateDCPanel getCdPanel() {
		return cdPanel;
	}

	public void setCdPanel(CreateDCPanel cdPanel) {
		this.cdPanel = cdPanel;
	}

	/**
	 * Creates new form HomePanel
	 */
	public HomePanel() {
		initComponents();
	}
	// jTable2

	public HomePanel(JTable table, javax.swing.JTabbedPane jTabbedPane) {
		this.dcTable = table;
		initComponents();
		editDCButton.setEnabled(false);
		deleteDCButton.setEnabled(false);

		dcTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (dcTable.getSelectedRowCount() > 0) {
					editDCButton.setEnabled(true);
					deleteDCButton.setEnabled(true);
				} else {
					editDCButton.setEnabled(false);
					deleteDCButton.setEnabled(false);
				}
			}
		});
		dcTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (dcTable.getSelectedRowCount() > 0) {
					editDCButton.setEnabled(true);
					deleteDCButton.setEnabled(true);
				} else {
					editDCButton.setEnabled(false);
					deleteDCButton.setEnabled(false);
				}
			}
		});

		jTabbedPane1 = jTabbedPane;
		createDCButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				jTabbedPane1.setEnabledAt(0, true);
				jTabbedPane1.setEnabledAt(1, false);
				jTabbedPane1.setEnabledAt(2, true);
				jTabbedPane1.setEnabledAt(3, false);
				jTabbedPane1.setEnabledAt(4, false);
				jTabbedPane1.setEnabledAt(5, false);

				cdPanel.getDcModel().getModel().clear();
				cdPanel.setRcnt(0);
				cdPanel.getDcModel().fireTableDataChanged();
				cdPanel.getSaveButton().setText("Save");
				cdPanel.getCancelButton().setText("Cancel");
				jTabbedPane1.getModel().setSelectedIndex(2);

			}
		});
		loadDCButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("LoadDelievryChallan do here");
			}
		});
		editDCButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rno = dcTable.getSelectedRow();

				System.out.println("EDIT DelievryChallan do here");

				cdPanel.getDateOP().setEnabled(false);
				cdPanel.getCompanyTextField().setText(jComboBox2.getSelectedItem().toString());
				jTabbedPane1.setEnabledAt(0, true);
				jTabbedPane1.setEnabledAt(1, false);
				jTabbedPane1.setEnabledAt(2, true);
				jTabbedPane1.setEnabledAt(3, false);
				jTabbedPane1.setEnabledAt(4, false);
				jTabbedPane1.setEnabledAt(5, false);

				jTabbedPane1.getModel().setSelectedIndex(2);
			}
		});
		deleteDCButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Delete DelievryChallan do here");
			}
		});
		editButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("EDIT INOICE..do here");
			}
		});
		delteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("DELETE INOICE..do here");
			}
		});
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		toplevelPanel = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		createDCButton = new javax.swing.JButton();
		createDCButton.setFont(new java.awt.Font("Ubuntu", 0, 18));
		msLabel = new javax.swing.JLabel();
		msLabel.setFont(new java.awt.Font("Ubuntu", 0, 18));
		jComboBox2 = new javax.swing.JComboBox<>();
		jComboBox2.setFont(new java.awt.Font("Ubuntu", 0, 18));
		loadDCButton = new javax.swing.JButton();
		loadDCButton.setFont(new java.awt.Font("Ubuntu", 0, 18));
		editDCButton = new javax.swing.JButton();
		editDCButton.setFont(new java.awt.Font("Ubuntu", 0, 18));
		deleteDCButton = new javax.swing.JButton();
		deleteDCButton.setFont(new java.awt.Font("Ubuntu", 0, 18));
		jPanel3 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		// jTable2 = new javax.swing.JTable();
		jPanel4 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		invNoLabel = new javax.swing.JLabel();
		invNoLabel.setFont(new java.awt.Font("Ubuntu", 0, 18));
		invNOTextField = new javax.swing.JTextField();
		invNOTextField.setFont(new java.awt.Font("Ubuntu", 0, 18));
		percTextField = new javax.swing.JTextField();
		percTextField.setFont(new java.awt.Font("Ubuntu", 0, 18));
		tinTextField = new javax.swing.JTextField();
		tinTextField.setFont(new java.awt.Font("Ubuntu", 0, 18));

		editButton = new javax.swing.JButton();
		editButton.setFont(new java.awt.Font("Ubuntu", 0, 18));
		delteButton = new javax.swing.JButton();
		delteButton.setFont(new java.awt.Font("Ubuntu", 0, 18));
		jPanel5 = new javax.swing.JPanel();
		serviceTaxLabel = new javax.swing.JLabel();
		serviceTaxLabel.setFont(new java.awt.Font("Ubuntu", 0, 18));
		jComboBox1 = new javax.swing.JComboBox<>();
		jComboBox1.setFont(new java.awt.Font("Ubuntu", 0, 18));
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextPane2 = new javax.swing.JTextPane();
		jTextPane2.setFont(new java.awt.Font("Ubuntu", 0, 18));
		percentLabel = new javax.swing.JLabel();
		percentLabel.setFont(new java.awt.Font("Ubuntu", 0, 18));
		partyTINnoLabel = new javax.swing.JLabel();
		partyTINnoLabel.setFont(new java.awt.Font("Ubuntu", 0, 18));
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextPane1 = new javax.swing.JTextPane();
		jTextPane1.setFont(new java.awt.Font("Ubuntu", 0, 18));
		genInvButton = new javax.swing.JButton();
		genInvButton.setFont(new java.awt.Font("Ubuntu", 0, 18));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		toplevelPanel.setLayout(new java.awt.GridBagLayout());

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delivery Challan",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Ubuntu", 0, 18)));
		jPanel1.setLayout(new java.awt.GridBagLayout());

		createDCButton.setText("Create Delivery Challan");
		jPanel1.add(createDCButton, new java.awt.GridBagConstraints());

		msLabel.setText("Customer Name:");
		jPanel1.add(msLabel, new java.awt.GridBagConstraints());

		jComboBox2.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "pexabyte", "Item 2", "Item 3", "Item 4" }));
		jPanel1.add(jComboBox2, new java.awt.GridBagConstraints());

		loadDCButton.setText("LoadDelievryChallan");
		jPanel1.add(loadDCButton, new java.awt.GridBagConstraints());

		editDCButton.setText("EDIT DelievryChallan");
		jPanel1.add(editDCButton, new java.awt.GridBagConstraints());

		deleteDCButton.setText("Delete DelievryChallan");
		jPanel1.add(deleteDCButton, new java.awt.GridBagConstraints());

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.2;
		toplevelPanel.add(jPanel1, gridBagConstraints);

		jPanel3.setLayout(new java.awt.BorderLayout());

		jScrollPane2.setViewportView(dcTable);

		jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.3;
		toplevelPanel.add(jPanel3, gridBagConstraints);

		jPanel4.setBorder(
				javax.swing.BorderFactory.createTitledBorder(null, "Invoice", javax.swing.border.TitledBorder.LEFT,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 18)));
		jPanel4.setLayout(new java.awt.GridBagLayout());

		jPanel2.setLayout(new java.awt.GridBagLayout());

		invNoLabel.setText("INVOICE NO:");
		jPanel2.add(invNoLabel, new java.awt.GridBagConstraints());

		invNOTextField.setText("invNOTextField");
		invNOTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		jPanel2.add(invNOTextField, new java.awt.GridBagConstraints());

		editButton.setText("EDIT");
		jPanel2.add(editButton, new java.awt.GridBagConstraints());

		delteButton.setText("DELETE");
		jPanel2.add(delteButton, new java.awt.GridBagConstraints());

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 1.0;
		jPanel4.add(jPanel2, gridBagConstraints);

		jPanel5.setLayout(new java.awt.GridBagLayout());

		serviceTaxLabel.setText("Service Tax:");
		jPanel5.add(serviceTaxLabel, new java.awt.GridBagConstraints());

		jComboBox1.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		jPanel5.add(jComboBox1, new java.awt.GridBagConstraints());
		jScrollPane3.setViewportView(jTextPane2);
		percTextField.setText("%");
		jPanel5.add(percTextField, new java.awt.GridBagConstraints());

		percentLabel.setText("%");
		jPanel5.add(percentLabel, new java.awt.GridBagConstraints());

		partyTINnoLabel.setText("Party TIN No:");
		jPanel5.add(partyTINnoLabel, new java.awt.GridBagConstraints());

		jScrollPane1.setViewportView(jTextPane1);
		tinTextField.setText("TIN");
		tinTextField.setColumns(15);
		jPanel5.add(tinTextField);

		genInvButton.setText("Generate Invoice");
		genInvButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jPanel5.add(genInvButton, new java.awt.GridBagConstraints());

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 1.0;
		jPanel4.add(jPanel5, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.5;
		toplevelPanel.add(jPanel4, gridBagConstraints);

		getContentPane().add(toplevelPanel, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		// TODO add your handling code here:

		// TODO Auto-generated method stub

		jTabbedPane1.setEnabledAt(0, true);
		jTabbedPane1.setEnabledAt(1, false);
		jTabbedPane1.setEnabledAt(2, false);
		jTabbedPane1.setEnabledAt(3, true);
		jTabbedPane1.setEnabledAt(4, false);
		jTabbedPane1.setEnabledAt(5, false);

		jTabbedPane1.getModel().setSelectedIndex(3);

	}// GEN-LAST:event_jButton3ActionPerformed

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(HomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(HomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(HomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(HomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HomePanel().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton createDCButton;
	private javax.swing.JButton editButton;
	private javax.swing.JButton genInvButton;
	private javax.swing.JButton loadDCButton;
	private javax.swing.JButton editDCButton;
	private javax.swing.JButton deleteDCButton;
	private javax.swing.JButton delteButton;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JComboBox<String> jComboBox2;
	private javax.swing.JLabel invNoLabel;
	private javax.swing.JLabel serviceTaxLabel;
	private javax.swing.JLabel partyTINnoLabel;
	private javax.swing.JLabel percentLabel;
	private javax.swing.JLabel msLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable dcTable;
	private javax.swing.JTextField invNOTextField;
	private javax.swing.JTextPane jTextPane1;
	private javax.swing.JTextPane jTextPane2;
	private javax.swing.JTextField percTextField;
	private javax.swing.JTextField tinTextField;
	private javax.swing.JPanel toplevelPanel;

	// End of variables declaration//GEN-END:variables
	public javax.swing.JPanel getToplevelPanel() {
		return toplevelPanel;
	}

	public void setToplevelPanel(javax.swing.JPanel toplevelPanel) {
		this.toplevelPanel = toplevelPanel;
	}
}
