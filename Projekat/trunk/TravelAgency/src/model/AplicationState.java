/***********************************************************************
 * Module:  AplicationState.java
 * Author:  Nikola
 * Purpose: Defines the Interface AplicationState
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid ab21de64-fbeb-44dd-ae9d-60b5502da524 */
public interface AplicationState {
	

	void setLoginVIew();

	void setDataView();

	void setMenuBar();

	void setToolBar();
   
	void setApplicationBrowser();
   
	void setStatusBar();
   
	void setCenterView();
   
	void setInputView();
}