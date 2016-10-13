/**
 * 
 */
package com.pb.re.gui;

import java.awt.Desktop;
import java.io.File;

/**
 * @author user
 *
 */
public class AnyPlatformAppPDF {
	public static void main(String[] args) {

		  try {

			File pdfFile = new File("E:\\PROJECTS\\INVOICE\\ramana_engg\\Reports\\SecondExample.pdf");
			if (pdfFile.exists()) {

				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfFile);
				} else {
					System.out.println("Awt Desktop is not supported!");
				}
				

			} else {
				System.out.println("File is not exists!");
			}

			System.out.println("Done");

		  } catch (Exception ex) {
			ex.printStackTrace();
		  }

	}
}
