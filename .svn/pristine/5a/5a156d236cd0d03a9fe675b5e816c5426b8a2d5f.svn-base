/***********************************************************************
 * Module:  MenuBarView.java
 * Author:  Nikola
 * Purpose: Defines the Class MenuBarView
 ***********************************************************************/

package view;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import controller.ToolBarController;
import model.ApplicationModel;
import model.DBConnection;
import model.User;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/** @pdOid 220ced1f-e932-4717-a5b6-ebc1aaf62c8a */
public class MenuBarView extends JMenuBar implements model.Observer, ActionListener  {
	
	private JMenu fajl = new JMenu("Fajl");
	private JMenuItem pocetna = new JMenuItem("Početna");
	private JMenuItem izlaz = new JMenuItem("Izlaz");
	private JMenu navigacija = new JMenu("Navigacija");
	private JMenuItem pomjeranjePr = new JMenuItem("Prethodni");
	private JMenuItem pomjeranjeSl = new JMenuItem("Slijedeci");
	private JMenu izvjestaji = new JMenu("Izvjestaji");
	//private JMenuItem izPoslovnice = new JMenuItem("Izvjestaj o poslovnicama");
	private JMenuItem izPutnici = new JMenuItem("Izvjestaj o putnicima");
	
	ApplicationView view;

	public MenuBarView(ApplicationView view) {
		super();
		this.view = view;
		
		if( User.getInstance().getUserType()==3)
			izvjestaji.setVisible(false);
		
		pocetna.setIcon(new ImageIcon("./icons/home.png"));
		pocetna.setActionCommand("home");
		pocetna.addActionListener(this);
		
		izlaz.setIcon(new ImageIcon("./icons/exit.png"));
		izlaz.setActionCommand("exit");
		izlaz.addActionListener(this);
		
		izPutnici.addActionListener(this);
		izPutnici.setActionCommand("evlica");
		
		pomjeranjePr.setIcon(new ImageIcon("./icons/prev.png"));
		pomjeranjePr.setActionCommand("prev");
		pomjeranjePr.addActionListener(this);
		
		pomjeranjeSl.setIcon(new ImageIcon("./icons/next.png"));
		pomjeranjeSl.setActionCommand("next");
		pomjeranjeSl.addActionListener(this);
		
	//	fajl.add(pocetna);
		fajl.add(izlaz);
		navigacija.add(pomjeranjePr);
		navigacija.add(pomjeranjeSl);
	//	izvjestaji.add(izPoslovnice);
		izvjestaji.add(izPutnici);
		
    	this.add(fajl);
		this.add(navigacija);
		this.add(izvjestaji);
		setVisible(true);
	}
	
	public void enableNavigationButtons()
	{
		pomjeranjePr.setEnabled(true);
		pomjeranjeSl.setEnabled(true);
	}
	
	public void disableNavigationButtons()
	{
		pomjeranjePr.setEnabled(false);
		pomjeranjeSl.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "home":
			{
				
				break;
			}
			case "exit":
			{
				view.dispose();
				System.exit(0);
				break;
			}
			case "prev":
			{	
				DataView dataView = view.getCenterView().getDataView();
				int selectedRow = dataView.getSelectedRow();
				int lastRow = dataView.getRowCount()-1;	
				
				if(selectedRow == 0)
				{
					dataView.setRowSelectionInterval(lastRow, lastRow);
				}
				else {
					dataView.setRowSelectionInterval(selectedRow-1, selectedRow-1);
				}
				dataView.updateUI();
				break;
			}
			case "next":
			{			
				DataView dataView = view.getCenterView().getDataView();
				int selectedRow = dataView.getSelectedRow();
				int lastRow = dataView.getRowCount()-1;		
				if(selectedRow == lastRow)
					
				{
					dataView.setRowSelectionInterval(0, 0);
				}
				else {
					dataView.setRowSelectionInterval(selectedRow+1, selectedRow+1);
					
				}
				dataView.updateUI();
				break;
			}
			case "evlica":
				Connection con=DBConnection.getInstance().getConnection();
				String reportPath = "reports/EvPutnika.jrxml";//putanja do njihovog iyvjestaja
			JasperReport jr;
			try {
				jr = JasperCompileManager.compileReport(reportPath);
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				// JasperViewer.viewReport(jp);
				JasperExportManager.exportReportToPdfFile(jp, "reports/Evputnika.pdf");
				
				if (Desktop.isDesktopSupported()) {
					try {
						File myFile = new File("reports/Evputnika.pdf");
						Desktop.getDesktop().open(myFile);
						// JasperPrintManager.printReport( myFile, true);

					} catch (IOException ex) {
						// no application registered for PDFs
					}
				}
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
				
				break;
			
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}