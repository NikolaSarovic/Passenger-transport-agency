package model;

import view.ApplicationView;

public class EditingState implements AplicationState {
	ApplicationView appView = null;
	
	public EditingState(ApplicationView appView) {
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
	   if(appView.getCenterView().getDataView() != null)
	   {
//		   appView.getCenterView().getDataView().removeAll();
		   appView.getCenterView().getDataView().show();
	   }
	}
   	
	public void setMenuBar() {
		appView.getMenuBarView().show();
		appView.getMenuBarView().disableNavigationButtons();
	}
  
	public void setToolBar() {
		appView.getToolBarView().show();
	}
  
	public void setApplicationBrowser() {
		appView.getBrowserView().show();
	}
  
	public void setStatusBar() {
		appView.getStatusBar().show();
		appView.getStatusBar().applicationStateLabel.setText("Editing State");
	}

	@Override
	public void setCenterView() {
		appView.getCenterView().show();
		appView.getCenterView().setDataAndInputView();
	}

	@Override
	public void setInputView() {
		if(appView.getCenterView().getInputView() != null)
		{
//			appView.getCenterView().getInputView().removeAll();
			appView.getCenterView().getInputView().show();
		}
	}
}
