/***********************************************************************
 * Module:  ApplicationModel.java
 * Author:  Nikola
 * Purpose: Defines the Class ApplicationModel
 ***********************************************************************/

package model;

import java.util.*;

import controller.ApplicationControler;
import view.ApplicationView;

/** @pdOid a76b4908-9a48-4079-b099-726a6635cffe */
public class ApplicationModel {
   public static User user;
   public AplicationState aplicationState;
   public Subscriber subscriber;
   public ApplicationBrowserModel applicationBrowserModel;
   
   private TableModel tableModel = new TableModel();
   
   private String currentTableType = "";
   
   public ApplicationModel() {
		this.user = User.getInstance();
   }
   
   public ApplicationModel(User korisnik, AplicationState aplicationState) {
	   this.user = korisnik;
	   this.aplicationState = aplicationState;
   }
   
   public ApplicationModel(User korisnik, AplicationState aplicationState, Subscriber subscriber) {
	   this.user = korisnik;
	   this.aplicationState = aplicationState;
	   this.subscriber = subscriber;
   }	
   
	   public AplicationState getAplicationState() {
		return aplicationState;
	}
	
	public void setAplicationState(AplicationState aplicationState) {
		this.aplicationState = aplicationState;
	}

	public void setTableModel(TableModel tabmodel) {
		this.tableModel=tabmodel; 
		System.out.println(this.tableModel.getColumnCount());
	}
   
	public TableModel getTableModel() {
		return this.tableModel;
	}

	public String getCurrentTableType() {
		return currentTableType;
	}

	public void setCurrentTableType(String currentTableType) {
		this.currentTableType = currentTableType;
	}
	
	
   
}