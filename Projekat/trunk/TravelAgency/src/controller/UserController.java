/***********************************************************************
 * Module:  UserController.java
 * Author:  Nikola
 * Purpose: Defines the Class UserController
 ***********************************************************************/

package controller;

import model.TableModel;
import view.DataView;
import java.util.*;

/** @pdOid 3a6df297-0927-481c-84f8-f51638babf64 */
public class UserController {
   /** @pdRoleInfo migr=no name=TableModel assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TableModel> tableModel;
   /** @pdRoleInfo migr=no name=DataView assc=association13 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<DataView> dataView;
   
   
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