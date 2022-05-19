/***********************************************************************
 * Module:  StatusBarView.java
 * Author:  Nikola
 * Purpose: Defines the Class StatusBarView
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.ApplicationControler;
import model.ApplicationModel;
import view.style.StyledButtonUI;

/** @pdOid e5e5be84-b545-44f7-a2f2-a0b874228623 */
public class StatusBarView extends JPanel implements model.Observer {
	private JLabel userLabel;
	private JLabel dateLabel;
	private JLabel userTypeLabel;
	public JLabel applicationStateLabel;
	private JButton odjava=new JButton("Odjava");

	public StatusBarView(ApplicationModel appModel) {
		setPreferredSize(new Dimension(0, 50));
		
		setBackground(Color.decode("#c6e2e5"));
		this.setLayout(null);
		
//		this.userLabel = new JLabel("Korisnik: " + appModel.user.getUsername());
		this.userLabel = new JLabel(String.format("Korisnik: %s %s", appModel.user.getFirstName(), appModel.user.getLastName()));
		this.userLabel.setLocation(41,5);
		userLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		userLabel.setSize(new Dimension(300, 20));
		this.add(this.userLabel);
		
		userTypeLabel = new JLabel();
		setUserType(appModel.user.getUserType());
		userTypeLabel.setLocation(10,25);
		userTypeLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		userTypeLabel.setSize(new Dimension(300, 20));
		add(userTypeLabel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setDateTime();
		dateLabel = new JLabel();
		dateLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		dateLabel.setSize(new Dimension(300, 20));
		dateLabel.setLocation((screenSize.width/2)-dateLabel.getSize().width/2,5);
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setVerticalAlignment(SwingConstants.CENTER);
		this.add(dateLabel);
		
		applicationStateLabel = new JLabel("");
		applicationStateLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		applicationStateLabel.setSize(new Dimension(300, 20));
		applicationStateLabel.setLocation(screenSize.width/2-applicationStateLabel.getSize().width/2,25);
		applicationStateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		applicationStateLabel.setVerticalAlignment(SwingConstants.CENTER);
		add(applicationStateLabel);
		
		odjava.setActionCommand("odjava");
		odjava.setUI(new StyledButtonUI());
		odjava.setBackground(Color.decode("#ff0000"));
		odjava.setContentAreaFilled(false);
		odjava.setSize(new Dimension(140, 40));
		odjava.setLocation(screenSize.width-odjava.getSize().width-5, 5);
		odjava.setForeground(Color.decode("#ffffff"));
		odjava.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		this.add(odjava);
		
	}

	public JButton getOdjava() {
		return odjava;
	}
   

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public void setUser(String user) {
		this.userLabel.setText("Korisnik:  " + user + "  ");
	}
	
	public void setUserType(int userType)
	{
		String userTypeName = null;
		switch (userType) {
		case 1:
			userTypeName = "Administrator";
			break;
		case 2:
			userTypeName = "Menadžer prevoza";
			break;	
		case 3:
			userTypeName = "Putnik";
			break;
		}
		userTypeLabel.setText("Tip korisnika: " + userTypeName);
	}
	
	public void setDateTime() {
		Thread timer = new Thread() {
			@Override
			public void run() {
				while (true) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
					dateLabel.setText(formatter.format(new Date()).toString());
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		};
		timer.start();
	}
}