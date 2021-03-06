/***********************************************************************
 * Module:  OfficeControler.java
 * Author:  Nikola
 * Purpose: Defines the Class OfficeControler
 ***********************************************************************/

package controller;

import view.ApplicationView;
import view.DataView;
import view.inputViews.PoslovniceInputView;
import model.ProcedureModel;
import model.TableModel;
import model.WorkingState;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import javax.swing.SwingUtilities;



/** @pdOid 4f7a3217-2251-4b87-9a86-b72c7897932f */
public class OfficeControler implements ActionListener {
   /** @pdRoleInfo migr=no name=DataView assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<DataView> dataView;
   /** @pdRoleInfo migr=no name=TableModel assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TableModel> tableModel;
   
   
   Vector<String> columns = null;
   Vector<Vector<String>> data = null; 
   PoslovniceInputView piv = null;
   ApplicationView view;
   TableModel model;
   
   public OfficeControler()  {
	   
   }
   public OfficeControler(PoslovniceInputView piV)
   {
	   piv=piV;
   }
   
   public TableModel getOffices()
   {
	   TableModel tableModel_Glavni = null;
	   columns = new Vector<String>();
	   data = new Vector<Vector<String>>();
	   
	   try {
			ResultSet result=ProcedureModel.getInstance().executeProcedure("{call st_PregledPoslovnica}");
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
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   
	   view =(ApplicationView) SwingUtilities.getRoot((Component)e.getSource());
	   Integer previousSelectedRow = view.getCenterView().getDataView().getPreviousSelectedRow();
	   
	   switch(e.getActionCommand())
	   {
	   	case "add":
	   		ProcedureModel.getInstance().executeProcedure("{call st_InsertPoslovnice(?,?,?,?,?)}",piv.getGradoviBIH().getSelectedItem(),
	   		piv.gettNaziv().getText(),piv.gettAdresa().getText(),piv.gettTelefon().getText(),piv.gettEmail().getText());
	   		model = getOffices();
	   		view.getCenterView().getDataView().setTableModel(model);
	   		view.getCenterView().getDataView().setRowSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
	   		view.getModel().setAplicationState(new WorkingState(view));
	   		 
	   		break;
	   	case "edit":
	   		
		   	ProcedureModel.getInstance().executeProcedure("{call st_UpdateJedinice(?,?,?,?,?,?)}",piv.gettOznakaJedinice().getText(),piv.gettNaziv().getText(),
		   	piv.gettAdresa().getText(),piv.gettTelefon().getText(),piv.gettEmail().getText(),piv.getGradoviBIH().getSelectedItem());
		    model = getOffices();
		   	view.getCenterView().getDataView().setTableModel(model);
		   	view.getCenterView().getDataView().setRowSelectionInterval(previousSelectedRow, previousSelectedRow);
		   	view.getModel().setAplicationState(new WorkingState(view));
	   		
	   		break;
   	}
   	
   }
   
   public void deleteOffice(int rowId)
   {
	   ResultSet result = ProcedureModel.instance.executeProcedure("{call st_DeletePoslovnice(?)}", rowId);
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