/***********************************************************************
 * Module:  TableModel.java
 * Author:  Nikola
 * Purpose: Defines the Class TableModel
 ***********************************************************************/

package model;

import java.util.*;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/** @pdOid 8d3f7486-6351-481e-b372-0f3f33c801a7 */
public class TableModel extends AbstractTableModel implements ISubscriber {
	private Vector<Observer> observers = new Vector<>();
	private int selectRow; 


	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<String>> data = new Vector<Vector<String>>();
	
  
   public DBConnection dBConnection;
   public TableModel() {
	   columns.add("Dobro ");
 		columns.add("dosli");
 		columns.add("G7");
 		
 		for(int i = 0 ; i<5;i++) {
 			Vector<String> row = new Vector<String>();
 			row.add("Agencija");
 			row.add("za");
 			row.add("prevoz putnika");
 			data.add(row);
           }
	   
	   		
	   	}
   
   
   public TableModel(Vector<String> columns, Vector<Vector<String>> data) {
	   this.columns=columns;
	   this.data=data;
	   
   }

   
   public void addRow(String text) {
	   Vector<String> dat = new Vector<>();
	   dat.add(text);
	   dat.add(text);
	   dat.add(text);
	   this.data.add(dat);
	   notifyObservers();
   }
   public void removeRow(int rowIndex) {
	   this.data.remove(rowIndex);
	   System.out.println(rowIndex);
	   notifyObservers();
   }
   

@Override
public String getColumnName(int column) {
	// TODO Auto-generated method stub
	return columns.get(column);
}

@Override
public Class<?> getColumnClass(int columnIndex) {
	// TODO Auto-generated method stub
	return this.columns.get(columnIndex).getClass();
}

@Override
public void subscribe(Observer observer) {
	// TODO Auto-generated method stub
	this.observers.add(observer);
	
}

@Override
public void unsubscribe(Observer observer) {
	// TODO Auto-generated method stub
	this.observers.remove(observer);
	
}

@Override
public void notifyObservers() {
	// TODO Auto-generated method stub
	for(Observer observer : this.observers)
		observer.update();
	
}

public void setTableData(Vector<Vector<String>> newData) {
	this.data = newData;
	this.notifyObservers();
}


public Vector<Observer> getObservers() {
	return observers;
}

public void setObservers(Vector<Observer> observers) {
	this.observers = observers;
}

public Vector<String> getColumns() {
	return columns;
}

public void setColumns(Vector<String> columns) {
	this.columns = columns;
}

public Vector<Vector<String>> getData() {
	return data;
}

public void setData(Vector<Vector<String>> data) {
	this.data = data;
}

@Override
public int getRowCount() {
	// TODO Auto-generated method stub
	return this.data.size();
}

@Override
public int getColumnCount() {
	// TODO Auto-generated method stub
	return this.columns.size();
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	// TODO Auto-generated method stub
	String value = null;
 	value = data.get(rowIndex).get(columnIndex);
	return value;
}
public int getSelectRow() {
	return selectRow;
}


public void setSelectRow(int selectRow) {
	this.selectRow = selectRow;
}
}