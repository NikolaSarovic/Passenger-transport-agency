/***********************************************************************
 * Module:  ToolBarView.java
 * Author:  Nikola
 * Purpose: Defines the Class ToolBarView
 ***********************************************************************/

package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RegistrationController;
import controller.ToolBarController;

/** @pdOid 3f3b4c93-2095-41d5-9386-a682f8e7cdda */
public class ToolBarView extends JPanel {
	JButton add = null;
	JButton edit = null;
	JButton delete = null;
	JButton prev = null;
	JButton next = null;
	JButton reserve = null;
	
	JPanel emptyPanel;
	
	public ToolBarView() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setLocation(new Point(40, 0));
		setPreferredSize(new Dimension(0, 40));
		
		setBorder(new EmptyBorder(0, 250, 0, 0));
		setBackground(Color.decode("#c6e2e5"));
		add = new JButton();
		add.setOpaque(false);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
		add.setIcon(new ImageIcon("./icons/add.png"));
		add.setBorder(BorderFactory.createEmptyBorder());
		add.setActionCommand("addRow");
		add.setSize(new Dimension(35, 35));
		add.setToolTipText("Dodaj");
		add(add);

		edit = new JButton();
		edit.setOpaque(false);
		edit.setContentAreaFilled(false);
		edit.setBorderPainted(false);
		edit.setIcon(new ImageIcon("./icons/edit.png"));
		edit.setBorder(BorderFactory.createEmptyBorder());
		edit.setActionCommand("editRow");
		edit.setSize(new Dimension(35, 35));
		edit.setToolTipText("Izmjeni");
		add(edit);

		delete = new JButton();
		delete.setOpaque(false);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);
		delete.setIcon(new ImageIcon("./icons/delete.png"));
		delete.setBorder(BorderFactory.createEmptyBorder());
		delete.setActionCommand("deleteRow");
		delete.setSize(new Dimension(35, 35));
		delete.setToolTipText("Izbriši");
		add(delete);
		
		reserve = new JButton();
		reserve.setOpaque(false);
		reserve.setContentAreaFilled(false);
		reserve.setBorderPainted(false);
		reserve.setIcon(new ImageIcon("./icons/check.png"));
		reserve.setBorder(BorderFactory.createEmptyBorder());
		reserve.setActionCommand("reserve");
		reserve.setSize(new Dimension(35, 35));
		reserve.setToolTipText("Rezerviši");
		reserve.setVisible(false);
		add(reserve);

		prev = new JButton();
		prev.setOpaque(false);
		prev.setContentAreaFilled(false);
		prev.setBorderPainted(false);
		prev.setIcon(new ImageIcon("./icons/prev.png"));
		prev.setBorder(BorderFactory.createEmptyBorder());
		prev.setActionCommand("prev");
		prev.setSize(new Dimension(35, 35));
		prev.setToolTipText("Prethodni");
		add(prev);

		next = new JButton();
		next.setOpaque(false);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.setIcon(new ImageIcon("./icons/next.png"));
		next.setBorder(BorderFactory.createEmptyBorder());
		next.setActionCommand("next");
		next.setSize(new Dimension(35, 35));
		next.setToolTipText("Sljedeći");

		add(next);

	}
	
	public void enableButtons()
	{
		this.add.setEnabled(true);
		this.edit.setEnabled(true);
		this.delete.setEnabled(true);
		this.prev.setEnabled(true);
		this.next.setEnabled(true);
	}
	
	public void disableButtonsForManagerReservation()
	{
		this.edit.setEnabled(false);
		this.delete.setEnabled(false);
//		this.prev.setEnabled(false);
//		this.next.setEnabled(false);
	}
	
	public void setToolbarForManagerTravels()
	{
		add.setVisible(true);
		edit.setVisible(true);
		delete.setVisible(true);
		reserve.setVisible(false);
		prev.setVisible(true);
		next.setVisible(true);
	}
	
	public void setToolbarForManagerReservations()
	{		
		add.setVisible(false);
		edit.setVisible(true);
		delete.setVisible(false);
		reserve.setVisible(false);
		prev.setVisible(true);
		next.setVisible(true);
	}
	
	public void setToolbarForTraveler(String tableType)
	{
		switch (tableType) {
			case "putovanja":
			{
				add.setVisible(false);
				edit.setVisible(false);
				delete.setVisible(false);
				reserve.setVisible(true);
				prev.setVisible(true);
				next.setVisible(true);
				break;
			}
			case "rezervacije":
			{
				add.setVisible(false);
				edit.setVisible(false);
				delete.setVisible(true);
				reserve.setVisible(false);
				prev.setVisible(true);
				next.setVisible(true);
				break;
			}
		}
	}
	
	public void addActionListeners(ToolBarController controller)
	{
		add.addActionListener(controller);
		edit.addActionListener(controller);
		delete.addActionListener(controller);
		prev.addActionListener(controller);
		next.addActionListener(controller);
		reserve.addActionListener(controller);
	}
}