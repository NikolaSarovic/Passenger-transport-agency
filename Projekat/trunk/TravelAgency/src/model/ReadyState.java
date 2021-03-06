/***********************************************************************
 * Module:  ReadyState.java
 * Author:  Nikola
 * Purpose: Defines the Class ReadyState
 ***********************************************************************/

package model;

import java.util.*;

import view.ApplicationView;

public class ReadyState implements AplicationState {
	ApplicationView appView = null;
	
	public ReadyState(ApplicationView appView) {
		this.appView = appView;
		
		setMenuBar();
		setToolBar();
		setApplicationBrowser();
		setCenterView();
//		setDataView();
//		setInputView();
		setStatusBar();
	}
	
	public void setLoginVIew() {
		
	}
   
	public void setDataView() {
		appView.getCenterView().getDataView().hide();
	}
   
	public void setMenuBar() {
		appView.getMenuBarView().show();
		appView.getMenuBarView().disableNavigationButtons();
	}
   
	public void setToolBar() {
		appView.getToolBarView().hide();
	}
   
	public void setApplicationBrowser() {
		appView.getBrowserView().show();
	}
   
	public void setStatusBar() {
		appView.getStatusBar().show();
		appView.getStatusBar().applicationStateLabel.setText("Ready State");
	}

	@Override
	public void setCenterView() {
		appView.getCenterView().show();
	}

	@Override
	public void setInputView() {
		appView.getCenterView().getInputView().hide();
	}

}