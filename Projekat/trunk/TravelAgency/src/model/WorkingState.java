/***********************************************************************
 * Module:  WorkingState.java
 * Author:  Nikola
 * Purpose: Defines the Class WorkingState
 ***********************************************************************/

package model;

import java.awt.BorderLayout;
import java.util.*;

import javax.swing.JScrollPane;

import view.ApplicationView;

/** @pdOid ff6fe6b3-eae7-4a00-8301-00ff5a051000 */
public class WorkingState implements AplicationState {
	ApplicationView appView = null;
	
	public WorkingState(ApplicationView appView) {
		this.appView = appView;
		
		setMenuBar();
		setToolBar();
		setApplicationBrowser();
		setCenterView();
		setDataView();
		setInputView();
		setStatusBar();
	}
	
	public void setLoginVIew() {
      // TODO: implement
	}
   
   public void setDataView() {
	   appView.getCenterView().removeAll();
	   appView.getCenterView().setDataView(appView);
	
	}
   	
	public void setMenuBar() {
		appView.getMenuBarView().show();
		appView.getMenuBarView().enableNavigationButtons();
	}
  
	public void setToolBar() {
		appView.getToolBarView().show();
	}
  
	public void setApplicationBrowser() {
		appView.getBrowserView().show();
	}
  
	public void setStatusBar() {
		appView.getStatusBar().show();
		appView.getStatusBar().applicationStateLabel.setText("Working State");
	}

	@Override
	public void setCenterView() {
		appView.getCenterView().show();
	}

	@Override
	public void setInputView() {
		if(appView.getCenterView().getInputView() != null)
			appView.getCenterView().getInputView().hide();
	}

}