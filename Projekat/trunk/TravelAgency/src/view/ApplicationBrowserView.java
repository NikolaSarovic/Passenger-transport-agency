/***********************************************************************
 * Module:  ApplicationBrowserView.java
 * Author:  Nikola
 * Purpose: Defines the Class ApplicationBrowserView
 ***********************************************************************/

package view;

import model.ApplicationBrowserModel;
import model.ApplicationModel;
import view.style.StyledButtonUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ApplicationBrowserController;

/** @pdOid dfbb6bb5-6571-4f41-9749-0bd1e035ebc6 */
public class ApplicationBrowserView extends JPanel implements MouseListener {
	private ApplicationModel appModel;
	public ApplicationBrowserModel applicationBrowserModel;
   	public JButton[] buttons;
   
   	public ApplicationBrowserView(ApplicationModel appModel) {
   		
   		this.appModel = appModel;
   		
   		setPreferredSize(new Dimension(250, 0));
		setBackground(Color.decode("#c6e9ef"));
		Border border = BorderFactory.createMatteBorder(4,4,4,4, Color.decode("#c6e2e5"));
		setBorder(border);
		
		int userType = appModel.user.getUserType();
	
		switch (userType) {
		case 1:
			buttons = addAdminOptions();
			break;
		case 2:
			buttons = addManangerOptions();
			break;	
		case 3:
			buttons = addTravelerOptions();
			break;
		default:
			break;
		}
		
		int brojac = 0;

		for (JButton btn : buttons) {

			btn.setPreferredSize(new Dimension(235, 45));
			btn.setBorderPainted(false);
			btn.setFocusPainted(false);
			btn.setContentAreaFilled(false);
			btn.setFont(new Font("Arial", Font.BOLD, 15));
			btn.setBackground(Color.decode("#c6e9ef"));
			btn.setUI(new StyledButtonUI());
			btn.addMouseListener(this);
			add(btn);
		}
   }
   
   private JButton[] addAdminOptions() {
		JButton[] buttons = new JButton[3];

		buttons[0] = new JButton("Poslovnice");
		buttons[0].setActionCommand("Poslovnice");
		buttons[0].setIcon(new ImageIcon(new ImageIcon("icons/office.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		buttons[1] = new JButton("Zaposleni");
		buttons[1].setActionCommand("Zaposleni");
		buttons[1].setIcon(new ImageIcon(new ImageIcon("icons/users.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		buttons[2] = new JButton("Resursi");
		buttons[2].setIcon(new ImageIcon(new ImageIcon("icons/resource.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		buttons[2].setActionCommand("Resursi");
		
		return buttons;
	}
   
   private JButton[] addManangerOptions() {
		JButton[] buttons = new JButton[2];

		buttons[0] = new JButton("Pregled putovanja");
		buttons[0].setActionCommand("Putovanja");
		buttons[0].setIcon(new ImageIcon(new ImageIcon("icons/travel.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		buttons[1] = new JButton("Spisak Rezervacija");
		buttons[1].setActionCommand("Rezervacije");
		buttons[1].setIcon(new ImageIcon(new ImageIcon("icons/reservation.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
//		buttons[2] = new JButton("Pregled izvještaja");
//		buttons[2].setActionCommand("Izvještaji");
//		buttons[2].setIcon(new ImageIcon(new ImageIcon("icons/report.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		
		return buttons;
	}
   
   private JButton[] addTravelerOptions() {
		JButton[] buttons = new JButton[2];

		buttons[0] = new JButton("Pregled putovanja");
		buttons[0].setActionCommand("Putovanjaa");
		buttons[0].setIcon(new ImageIcon(new ImageIcon("icons/travel.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		buttons[1] = new JButton("Pregled rezervacija");
		buttons[1].setActionCommand("Pregled rezervacija");
		buttons[1].setIcon(new ImageIcon(new ImageIcon("icons/reservation.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));

		return buttons;
	}
   
   public JButton[] getBrowserButtons() {
	   return this.buttons;
   }
   public void setController(ApplicationBrowserController controller) {
	   for(JButton button : this.buttons)
		   button.addActionListener(controller);
   }
   
   
   @Override
   public void mouseEntered(MouseEvent e) {
	   
	   JButton currentButton = (JButton) e.getSource();
	   currentButton.setBackground(Color.decode("#eeeee6"));
	   
   }
   
   @Override
	public void mouseExited(MouseEvent e) {
	   JButton currentButton = (JButton) e.getSource();
	   currentButton.setBackground(Color.decode("#c6e9ef"));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
   
   
}