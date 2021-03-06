/***********************************************************************
 * Module:  LoginView.java
 * Author:  Nikola
 * Purpose: Defines the Class LoginView
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import org.xml.sax.SAXException;

import controller.ApplicationControler;
import controller.RegistrationController;
import model.ApplicationModel;
import model.DBConnection;
import model.ProcedureModel;
import model.ReadyState;
import model.RegistrationModel;
import model.User;
import view.style.StyledButtonUI;

/** @pdOid 2387b629-9904-4bf9-8aa6-97e499fedc3e */
public class LoginView extends JFrame {
	private JButton exitButton = null;
	private JTextField tbUsername = null;
	private JPasswordField tbPassword = null;
	private JButton submit = null;
	private JButton registration = null;
	private static final long serialVersionUID = 1L;

	public LoginView() {
		exitButton = new JButton("X");
//		exitButton.setBackground(Color.decode("#EC7063"));
//		exitButton.setUI(new StyledButtonUI());
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		setBackground(Color.decode("#c6e2e5"));
		this.getRootPane().setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), BorderFactory.createEmptyBorder(8, 8, 8, 8)));
		JPanel barPanel = new JPanel();
		barPanel.setLayout(new BoxLayout(barPanel, BoxLayout.X_AXIS));
		barPanel.add(Box.createHorizontalGlue());
		barPanel.add(this.exitButton);

		setLayout(new BorderLayout());
		add(barPanel, BorderLayout.NORTH); 
		add(initLoginPanel(),BorderLayout.CENTER);
		setSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);

	}

	private JPanel initLoginPanel() {
		JPanel loginPanel = new JPanel();

		loginPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		loginPanel.setLayout(new FlowLayout());
		tbPassword = new JPasswordField();
		tbPassword.setPreferredSize(new Dimension(200, 30));
		tbUsername = new JTextField();
		tbUsername.setPreferredSize(new Dimension(200, 30));
		submit = new JButton("Pristup");
		registration = new JButton("Registracija");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				DBConnection dbInstance = DBConnection.getInstance();
				dbInstance.getConnection();
				
				String username = tbUsername.getText();
				String password = tbPassword.getText();
				
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(password.getBytes());
					byte[] bytes = md.digest();
					StringBuilder sb = new StringBuilder();
		            for(int i=0; i< bytes.length ;i++)
		            {
		                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		            }
		            password = sb.toString();
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
				

				if (validateUser(username, password)) {
					dispose();
					getUserDetailInfo(User.getInstance().getId());
					ApplicationModel appModel = new ApplicationModel();
					ApplicationView view = new ApplicationView(appModel);
					new ApplicationControler(view, appModel);

				} else
				{
					JOptionPane.showMessageDialog(null, "Uneseni podaci nisu validni. Poku??ajte ponovo!", "Greska",
							JOptionPane.ERROR_MESSAGE);
					tbUsername.setText(null);
					tbPassword.setText(null);
				}
			}
		});

		registration.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				RegistrationModel registrationModel = new RegistrationModel();
				FrameRegistracije registrationView = new FrameRegistracije(registrationModel);
				RegistrationController registrationController = new RegistrationController(registrationModel, registrationView);
			}
		});

		loginPanel.add(new JLabel("Korisnicko ime"));
		loginPanel.add(tbUsername);
		loginPanel.add(new JLabel("Lozinka            "));
		loginPanel.add(tbPassword);
		submit.setBackground(Color.decode("#2ECC71"));
		submit.setUI(new StyledButtonUI());
		loginPanel.add(submit);
		registration.setBackground(Color.decode("#D0D3D4"));
		registration.setUI(new StyledButtonUI());
		loginPanel.add(registration);
		return loginPanel;

	}

	private boolean validateUser(String username, String password) {
		ResultSet rs = ProcedureModel.getInstance().executeProcedure("{call st_Login(?,?)}", username,password);
		
		try {
			while(rs.next())
			{	
				if (rs.getString(1) != null && (username.equals(rs.getString("Username")))
						&& String.valueOf(password).equals(rs.getString("Password"))) {
					User user = User.getInstance();
					user.setId(Integer.parseInt(rs.getString("ID")));
					user.setUserType(Integer.parseInt(rs.getString("Tip_ID")));
					user.setUsername(rs.getString("Username"));
					user.setPassword(rs.getString("Password"));
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void getUserDetailInfo(int userID)
	{
		ResultSet rs = ProcedureModel.getInstance().executeProcedure("{call st_DetaljniPodaciKorisnika(?)}", userID);
		try {
			while(rs.next())
			{	
				if (rs.getString(1) != null) {
					User user = User.getInstance();
					user.setFirstName(rs.getString("Ime"));
					user.setLastName(rs.getString("Prezime"));
					user.setIdentificationNumber(rs.getString("Mati??ni broj"));
					
					if(user.getUserType() == 3)
					{
						user.setEmailAddress(rs.getString("Email"));
						user.setPhoneNumber(rs.getString("Broj telefona"));
					}			
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}