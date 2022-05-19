package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;

import model.ApplicationModel;
import model.DBConnection;
import model.ProcedureModel;
import model.TableModel;
import model.User;
import model.WorkingState;
import view.ApplicationBrowserView;
import view.ApplicationView;
import view.CenterView;
import view.DataView;

public class ApplicationBrowserController implements ActionListener{
	private ApplicationModel model;
	private ApplicationView view = null;
	
	TableModel tabmodel = null;
	Vector<String> columns=new Vector<String>();
	Vector<Vector<String>> data=new Vector<Vector<String>>(); 
	
	public ApplicationBrowserController(ApplicationView view,ApplicationModel model) {
		this.view = view;
		this.model = model;
		for(JButton button: this.view.getBrowserView().getBrowserButtons())
			button.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		OfficeControler officeControler = new OfficeControler();
		ResourceController resourceController = new ResourceController();
		TransportationController transportationController = new TransportationController();
		ReservationController reservationController = new ReservationController();
		
		
		switch(e.getActionCommand()) {
		case "Zaposleni":
			tabmodel = resourceController.getEmployees();
			break;
		  case "Poslovnice":
		  	tabmodel = officeControler.getOffices();
			break;
		case "Resursi":
			tabmodel = resourceController.getCars();
			break;
		case "Putovanja":
			view.getToolBarView().setToolbarForManagerTravels();
			tabmodel = transportationController.getTravelsForManager();	
			break;
		case "Rezervacije":
			view.getToolBarView().setToolbarForManagerReservations();
			tabmodel = reservationController.getReservationsForManager();
			break;
		case "Putovanjaa":
			view.getToolBarView().setToolbarForTraveler("putovanja");
			tabmodel = transportationController.getTravelsForTravelers();
			break;
		case "Pregled rezervacija":
			view.getToolBarView().setToolbarForTraveler("rezervacije");
			tabmodel = reservationController.getReservationsForTravelers();
			break;
		case "Izvještaji":
			view.getToolBarView().setVisible(false);
			break;
		}

		if(e.getActionCommand() != "Izvještaji")
		{
			this.model.setCurrentTableType(e.getActionCommand());
			this.model.setAplicationState(new WorkingState(view));
			this.view.getCenterView().getDataView().setTableModel(tabmodel);
		}	
	}

}
