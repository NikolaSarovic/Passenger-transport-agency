/***********************************************************************
 * Module:  ApplicationView.java
 * Author:  Nikola
 * Purpose: Defines the Class ApplicationView
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.ApplicationModel;
import model.ReadyState;
import model.TableModel;
import model.User;

/** @pdOid cb609eba-9bd3-44c8-bc0b-60249bd5acb1 */
public class ApplicationView extends JFrame implements model.Observer {
   
	private CenterView centerView = null;
	private DataView dataView = null; //pregled tabele 
	private MenuBarView menuBarView;
	private ToolBarView toolBarView=new ToolBarView();
	private StatusBarView statusBarView;
    private ApplicationBrowserView browserView;
    private ApplicationModel appModel;
   
	public ApplicationView(ApplicationModel appModel) {
		super();
		
		this.appModel = appModel;
		this.browserView = new ApplicationBrowserView(appModel);
		this.statusBarView = new StatusBarView(appModel);
		
		menuBarView = new MenuBarView(this);
		
		ImageIcon img = new ImageIcon("./icons/g7-logo.png");
		this.setIconImage(img.getImage());
		setResizable(false);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		
		this.centerView = new CenterView(this);
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(ss);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new BorderLayout());
		this.add(centerView, BorderLayout.CENTER);
		setJMenuBar(this.menuBarView);
		this.add(toolBarView,BorderLayout.NORTH);
		southPanel.add(statusBarView);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(browserView, BorderLayout.WEST);
		appModel.setAplicationState(new ReadyState(this));
		setTitle("Agencija za prevoz putnika");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public MenuBarView getMenuBarView() {
		return menuBarView;
	}

	public void setMenuBarView(MenuBarView menuBarView) {
		this.menuBarView = menuBarView;
	}

	public StatusBarView getStatusBar() {
		return this.statusBarView;
	}
	
	public DataView getDataView() {
		return this.dataView;
	}
	
	public ApplicationBrowserView getBrowserView() {
		return this.browserView;
	}
	
	public ToolBarView getToolBarView() {
		return toolBarView;
	}

	public CenterView getCenterView() {
		return centerView;
	}

	public void refreshTableView() {
		System.out.println(this.dataView);
		this.dataView.updateUI();
		SwingUtilities.updateComponentTreeUI(this);
	}
	public ApplicationModel getModel() {
		return this.appModel;
	}

@Override
	public void update() {
		// TODO Auto-generated method stub
	  // System.out.println(this.dataView.getTableModel().getValueAt(0, 0));
	   //dataView=new DataView(this.dataView.getTableModel());
//	   dataView.updateUI();
//	   dataView.repaint();
//	   AbstractTableModel dm=(AbstractTableModel)this.dataView.getTableModel();
//	   dm.fireTableDataChanged();
	}

}