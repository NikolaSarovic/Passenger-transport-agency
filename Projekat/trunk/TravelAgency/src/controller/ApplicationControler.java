/***********************************************************************
 * Module:  ApplicationControler.java
 * Author:  Nikola
 * Purpose: Defines the Class ApplicationControler
 ***********************************************************************/

package controller;

import model.ApplicationModel;
import model.User;
import view.ApplicationView;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class ApplicationControler implements ActionListener {
   
   private ApplicationModel applicationModel;
   
   private ApplicationView applicationView;
   
   private ApplicationBrowserController appBrowserController = null;
   
   private ToolBarController toolBarController = null;
   
   
   public ApplicationControler(ApplicationView view, ApplicationModel model) {
	   this.applicationModel = model;
	   this.applicationView = view;
	   this.appBrowserController = new ApplicationBrowserController(view, model);
	   this.toolBarController = new ToolBarController(model, view);
	   this.applicationView.getStatusBar().getOdjava().addActionListener(this);
	 
	   
   }



@Override
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand()=="odjava")
	{
		User.setInstance(null);
		this.applicationModel=null;
		this.applicationView.dispose();
		this.applicationView=null;
		new LoginView();
	}
	
	
	
}

   
   
   

}