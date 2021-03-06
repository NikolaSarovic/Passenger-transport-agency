/***********************************************************************
 * Module:  TransportationController.java
 * Author:  Nikola
 * Purpose: Defines the Class TransportationController
 ***********************************************************************/

package controller;

import view.ApplicationView;
import view.DataView;
import view.inputViews.PutovanjaInputMenadzer;
import view.inputViews.RezervacijeInputMenadzer;
import model.ProcedureModel;
import model.TableModel;
import model.User;
import model.WorkingState;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import javax.swing.SwingUtilities;

/** @pdOid 6e4443bd-49f0-405b-b9a6-e216bcb1cc20 */
public class TransportationController implements ActionListener {
   /** @pdRoleInfo migr=no name=DataView assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<DataView> dataView;
   /** @pdRoleInfo migr=no name=TableModel assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TableModel> tableModel;
   
   PutovanjaInputMenadzer put;
   ApplicationView view;
   TableModel model;
   
   Vector<String> columns;
   Vector<Vector<String>> data;
   
   public TransportationController() {
	   
   }
   public TransportationController(PutovanjaInputMenadzer putovanjaMenadzer)
   {
	   put=putovanjaMenadzer;
   }
  
   
   public TableModel getTravelsForManager()
   {
	   TableModel tableModel_Glavni;
	   columns = new Vector<String>();
	   data = new Vector<Vector<String>>();
	   
	   try {
			ResultSet result=ProcedureModel.instance.executeProcedure("{call st_PregledPutovanjaMenadzer(?)}",User.getInstance().getId());
			ResultSetMetaData resultSetMetaData=result.getMetaData();
			for(int i=0;i<resultSetMetaData.getColumnCount();i++)
			{
				columns.add(resultSetMetaData.getColumnName(i+1));					
			}
			while(result.next())
			{
				Vector<String> dat=new Vector<String>();
				for(int i=0;i<resultSetMetaData.getColumnCount();i++)
				{
					dat.add(result.getString(i+1));
					
				}
				data.add(dat);
				
			}
			
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	   tableModel_Glavni = new TableModel(columns, data);
	   return tableModel_Glavni;
   }
   
   public TableModel getTravelsForTravelers()
   {
	   TableModel tableModel_Glavni;
	   columns = new Vector<String>();
	   data = new Vector<Vector<String>>();
	   
	   try {
			ResultSet result=ProcedureModel.instance.executeProcedure("{call st_PregledPutovanjaPutnik(?)}", User.getInstance().getId());
			ResultSetMetaData resultSetMetaData=result.getMetaData();
			for(int i=0;i<resultSetMetaData.getColumnCount();i++)
			{
				columns.add(resultSetMetaData.getColumnName(i+1));
			}
			while(result.next())
			{
				Vector<String> dat=new Vector<String>();
				for(int i=0;i<resultSetMetaData.getColumnCount();i++)
				{
					dat.add(result.getString(i+1));
				}
				data.add(dat);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	   tableModel_Glavni = new TableModel(columns, data);
	   return tableModel_Glavni;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	   	view =(ApplicationView) SwingUtilities.getRoot((Component)e.getSource());
	   	Integer previousSelectedRow = view.getCenterView().getDataView().getPreviousSelectedRow();
	   	
	   	switch(e.getActionCommand())
	   	{
		   	case "add":
		   		ProcedureModel.getInstance().executeProcedure("{call st_InsertPutovanjaMenadzer(?,?,?,?,?,?,?,?)}",
		   		put.getLokacijaPolaska().getSelectedItem(),put.getLokacijaDolaska().getSelectedItem(),put.getFtVrijemePolaska().getText(),put.getFtVrijemeDolaska().getText()
		   		,put.gettNapomena().getText(),put.getTipPrevoza().getSelectedItem(),put.getTipPutovanja().getSelectedItem(),User.getInstance().getId());
		   		
		   		view =(ApplicationView) SwingUtilities.getRoot((Component)e.getSource());
		   		model = getTravelsForManager();
		   		view.getCenterView().getDataView().setTableModel(model);
		   		view.getCenterView().getDataView().setRowSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
		   		view.getModel().setAplicationState(new WorkingState(view));
		   		
		   		break;
		   	case "edit":
		   		ProcedureModel.getInstance().executeProcedure("{call st_UpdatePutovanjaMenadzer(?,?,?,?,?,?,?,?,?)}", 
		   		put.gettID().getText(),User.getInstance().getId(),put.getLokacijaPolaska().getSelectedItem(),put.getLokacijaDolaska().getSelectedItem(),
		   		put.getFtVrijemePolaska().getText(),put.getFtVrijemeDolaska().getText(),
		   		put.getTipPrevoza().getSelectedItem().toString(),put.getTipPutovanja().getSelectedItem().toString(),put.gettNapomena().getText());
		 		
		   		view =(ApplicationView) SwingUtilities.getRoot((Component)e.getSource());
		   		model = getTravelsForManager();
		   		view.getCenterView().getDataView().setTableModel(model);
			   	view.getCenterView().getDataView().setRowSelectionInterval(previousSelectedRow, previousSelectedRow);
		   		view.getModel().setAplicationState(new WorkingState(view));
		   		
		   		break;
	   	}
   	
   }

   
   public void deleteTravel(int rowId)
   {
	   ResultSet result = ProcedureModel.instance.executeProcedure("{call st_DeletePutovanje(?)}", rowId);
   }
   
   /** @pdGenerated default getter */
   public java.util.Collection<DataView> getDataView() {
      if (dataView == null)
         dataView = new java.util.HashSet<DataView>();
      return dataView;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDataView() {
      if (dataView == null)
         dataView = new java.util.HashSet<DataView>();
      return dataView.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDataView */
   public void setDataView(java.util.Collection<DataView> newDataView) {
      removeAllDataView();
      for (java.util.Iterator iter = newDataView.iterator(); iter.hasNext();)
         addDataView((DataView)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDataView */
   public void addDataView(DataView newDataView) {
      if (newDataView == null)
         return;
      if (this.dataView == null)
         this.dataView = new java.util.HashSet<DataView>();
      if (!this.dataView.contains(newDataView))
         this.dataView.add(newDataView);
   }
   
   /** @pdGenerated default remove
     * @param oldDataView */
   public void removeDataView(DataView oldDataView) {
      if (oldDataView == null)
         return;
      if (this.dataView != null)
         if (this.dataView.contains(oldDataView))
            this.dataView.remove(oldDataView);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDataView() {
      if (dataView != null)
         dataView.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TableModel> getTableModel() {
      if (tableModel == null)
         tableModel = new java.util.HashSet<TableModel>();
      return tableModel;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTableModel() {
      if (tableModel == null)
         tableModel = new java.util.HashSet<TableModel>();
      return tableModel.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTableModel */
   public void setTableModel(java.util.Collection<TableModel> newTableModel) {
      removeAllTableModel();
      for (java.util.Iterator iter = newTableModel.iterator(); iter.hasNext();)
         addTableModel((TableModel)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTableModel */
   public void addTableModel(TableModel newTableModel) {
      if (newTableModel == null)
         return;
      if (this.tableModel == null)
         this.tableModel = new java.util.HashSet<TableModel>();
      if (!this.tableModel.contains(newTableModel))
         this.tableModel.add(newTableModel);
   }
   
   /** @pdGenerated default remove
     * @param oldTableModel */
   public void removeTableModel(TableModel oldTableModel) {
      if (oldTableModel == null)
         return;
      if (this.tableModel != null)
         if (this.tableModel.contains(oldTableModel))
            this.tableModel.remove(oldTableModel);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTableModel() {
      if (tableModel != null)
         tableModel.clear();
   }

}