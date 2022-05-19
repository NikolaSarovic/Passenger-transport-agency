package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTMLEditorKit.Parser;

import model.ApplicationModel;
import model.EditingState;
import model.TableModel;
import model.WorkingState;
import view.ApplicationView;
import view.DataView;
import view.InputPanel;
import view.ToolBarView;

public class ToolBarController implements ActionListener {
	
	ApplicationModel applicationModel = null;
	ApplicationView applicationView = null;
	DataView dataView = null;
	InputPanel inputView = null;
	TableModel tableModel = null;
	
	OfficeControler officeControler = new OfficeControler();
	ResourceController resourceController = new ResourceController();
	TransportationController transportationController = new TransportationController();
	ReservationController reservationController = new ReservationController();
	
	public ToolBarController(ApplicationModel applicationModel, ApplicationView applicationView) {
		this.applicationModel = applicationModel;
		this.applicationView = applicationView;
		this.applicationView.getToolBarView().addActionListeners(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dataView = applicationView.getCenterView().getDataView();	
		applicationView.getCenterView().setInputView(inputView = new InputPanel());
		tableModel = applicationView.getCenterView().getDataView().getTableModel();
		int selectedRow = dataView.getSelectedRow();
		tableModel.setSelectRow(dataView.getSelectedRow());
		int lastRow = dataView.getRowCount()-1;
		
		switch (e.getActionCommand()) {
			case "addRow":
			{
				inputView.setInputView(tableModel, applicationModel.getCurrentTableType(), true);
				applicationModel.setAplicationState(new EditingState(applicationView));
				break;	
			}
				
			case "editRow":
			{
				inputView.setInputView(tableModel, applicationModel.getCurrentTableType(), false);
				applicationModel.setAplicationState(new EditingState(applicationView));
				dataView.setSelectedRow(selectedRow);
				break;
			}
			case "deleteRow":
			{
				Object rowId = dataView.getModel().getValueAt(selectedRow, 0);
				int response = JOptionPane.showConfirmDialog(applicationView, "Da li ste sigurni da želite obrisati selektovani red?",
						"Potvrda brisanja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION)
				{
					switch(applicationModel.getCurrentTableType())
					{
						case "Poslovnice":
						{
							officeControler.deleteOffice(Integer.parseInt(rowId.toString()));
							tableModel = officeControler.getOffices();
							break;
						}
						case "Zaposleni":
						{
							resourceController.deleteEmployee(Integer.parseInt(rowId.toString()));
							tableModel = resourceController.getEmployees();
							break;
						}
						case "Resursi":
						{
							resourceController.deleteCar(Integer.parseInt(rowId.toString()));
							tableModel = resourceController.getCars();
							break;
						}
						case "Putovanja":
						{
							transportationController.deleteTravel(Integer.parseInt(rowId.toString()));
							tableModel = transportationController.getTravelsForManager();
							break;
						}
						case "Rezervacije":
						{
							
							break;
						}
						case "Putovanjaa":
						{
							
							break;
						}
						case "Pregled rezervacija":
						{
							reservationController.deleteReservation(Integer.parseInt(rowId.toString()));
							tableModel = reservationController.getReservationsForTravelers();
							break;
						}
					}
				}
				dataView.setRowSelectionInterval(selectedRow-1, selectedRow-1);
				break;
			}	
			case "reserve":
			{
				HashMap<String, String> reservationData = new HashMap<String, String>();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				reservationData.put("userId", String.valueOf(applicationModel.user.getId()));
				reservationData.put("travelId", tableModel.getValueAt(selectedRow, 0).toString());
				reservationData.put("currentDateTime", df.format(Calendar.getInstance().getTime()));
				
				reservationController.insertReservation(reservationData);
				tableModel = transportationController.getTravelsForTravelers();
				break;
			}
			case "prev":
			{	
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
		}
		
		if(e.getActionCommand() != "prev"  && e.getActionCommand() != "next")
		{
			applicationView.getCenterView().getDataView().setTableModel(tableModel);
			
			if(e.getActionCommand() == "deleteRow") 
				dataView.setRowSelectionInterval(selectedRow-1, selectedRow-1);
			else
				dataView.setRowSelectionInterval(selectedRow, selectedRow);
		}
	}
}
