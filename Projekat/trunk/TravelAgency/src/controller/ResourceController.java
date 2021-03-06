/***********************************************************************
 * Module:  ResourceController.java
 * Author:  Nikola
 * Purpose: Defines the Class ResourceController
 ***********************************************************************/

package controller;

import model.ProcedureModel;
import model.TableModel;
import model.User;
import model.WorkingState;
import view.ApplicationView;
import view.DataView;
import view.inputViews.VozilaInputView;
import view.inputViews.ZaposleniInputView;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import javax.swing.SwingUtilities;

/** @pdOid 5351e69c-59ce-4a31-b4c2-dca0058b0e5a */
public class ResourceController implements ActionListener {
   /** @pdRoleInfo migr=no name=TableModel assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TableModel> tableModel;
   /** @pdRoleInfo migr=no name=DataView assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<DataView> dataView;
   
  
   Vector<String> columns;
   Vector<Vector<String>> data; 
   ZaposleniInputView ziv;
   VozilaInputView v;
   ApplicationView view;
   TableModel model;
   
   public ResourceController() {
		this.columns = new Vector<String>();
		this.data = new Vector<Vector<String>>();
   }
   public ResourceController(ZaposleniInputView zaposleniInput)
   {
	   ziv=zaposleniInput;
   }
   public ResourceController(VozilaInputView vozilaInpit)
   {
	   v=vozilaInpit;
   }
   
   public TableModel getEmployees()
   {
	   TableModel tableModel_Glavni;
	   columns = new Vector<String>();
	   data = new Vector<Vector<String>>();
	   
	   try {
			ResultSet result=ProcedureModel.getInstance().executeProcedure("{call st_PregledZaposlenih}");
			ResultSetMetaData resultsetmetadata=result.getMetaData();
			for(int i=0;i<resultsetmetadata.getColumnCount();i++)
			{
				columns.add(resultsetmetadata.getColumnLabel(i+1));
			}
			while(result.next())
			{
				Vector<String> dat = new Vector<String>();
				for(int i=0;i<resultsetmetadata.getColumnCount();i++)
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
   
   public TableModel getCars()
   {
	   TableModel tableModel_Glavni;
	   columns = new Vector<String>();
	   data = new Vector<Vector<String>>();
	   
	   try {
			ResultSet result=ProcedureModel.instance.executeProcedure("{call st_PregledVozila}");
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
		case "addZaposleni":
			ProcedureModel.getInstance().executeProcedure("{call st_InsertZaposleni(?,?,?,?,?,?,?)}",ziv.gettPrezime().getText(),ziv.gettImeRoditelja().getText(),
			ziv.gettIme().getText(),ziv.getGender(),ziv.gettMaticni().getText(),ziv.gettUsername().getText(),ziv.getPaswordMd5());
			model = getEmployees();
		 	view.getCenterView().getDataView().setTableModel(model);
			view.getCenterView().getDataView().setRowSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
			view.getModel().setAplicationState(new WorkingState(view));
			
			break;
		case "editZaposleni":
			ProcedureModel.getInstance().executeProcedure("{call st_UpdateZaposleni(?,?,?,?,?,?)}",ziv.gettId().getText(),ziv.gettPrezime().getText(),
			ziv.gettImeRoditelja().getText(),ziv.gettIme().getText(),ziv.getGender(),ziv.gettMaticni().getText());
		    model = getEmployees();
			view.getCenterView().getDataView().setTableModel(model);
		   	view.getCenterView().getDataView().setRowSelectionInterval(previousSelectedRow, previousSelectedRow);
			view.getModel().setAplicationState(new WorkingState(view));
			
		    break;
	    case "addVozila":
	    	ProcedureModel.getInstance().executeProcedure("{call st_InsertVozila(?,?,?,?)}",
	        v.getNacinPrevoza().getSelectedItem(),v.gettNazivVozila().getText(),v.gettPotrosnja().getText(),v.getGradoviBIH().getSelectedItem());
		    model = getCars();
			view.getCenterView().getDataView().setTableModel(model);
	   		view.getCenterView().getDataView().setRowSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
			view.getModel().setAplicationState(new WorkingState(view));
	    	  	
			break;
	    case "editVozila":
	    	ProcedureModel.getInstance().executeProcedure("{call st_UpdateVozila(?,?,?,?,?)}",
	    	v.gettID().getText(),v.getGradoviBIH().getSelectedItem(),v.getNacinPrevoza().getSelectedItem(),v.gettNazivVozila().getText(),v.gettPotrosnja().getText());
	    	model = getCars();
			view.getCenterView().getDataView().setTableModel(model);
			view.getCenterView().getDataView().setRowSelectionInterval(previousSelectedRow, previousSelectedRow);
			view.getModel().setAplicationState(new WorkingState(view));
	    	
	    	break;
	}
	
}
   
 
   public void deleteCar(int rowId)
   {
	   ResultSet result = ProcedureModel.instance.executeProcedure("{call st_DeleteVozila(?)}", rowId);
   }
   
   public void deleteEmployee(int rowId)
   {
	   ResultSet result = ProcedureModel.instance.executeProcedure("{call st_DeleteZaposleni(?)}", rowId);
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


}