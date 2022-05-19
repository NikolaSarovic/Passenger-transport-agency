/***********************************************************************
 * Module:  DataView.java
 * Author:  Nikola
 * Purpose: Defines the Class DataView
 ***********************************************************************/

package view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import model.TableModel;

/** @pdOid f169e320-20e3-46af-80c0-767ca441f0c4 */
public class DataView extends JTable implements ListSelectionListener  {
	ApplicationView appView;
	
	int selectedRow;
	
	public DataView(ApplicationView appView)
	{
		this.appView = appView;
		setRowHeight(30);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		setDefaultRenderer(Object.class, new view.style.TableCellRenderer());
	}
	
	public TableModel getTableModel() {
		return (TableModel) getModel();
	}
	public void setTableModel(TableModel tabmodel) {
		setModel(tabmodel);
		setRowSelectionInterval(0, 0);
		this.updateUI();
	}
	
	
   public int getPreviousSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		super.valueChanged(e);
//		appView.getToolBarView().enableButtons();
	}
	
	
	
	
	
	
}