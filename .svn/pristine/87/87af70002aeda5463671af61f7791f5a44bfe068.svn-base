package view.inputViews;

import java.awt.GridLayout;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.OfficeControler;
import controller.ResourceController;
import model.TableModel;
import view.inputViews.component.InputComponent;

public class ZaposleniInputView extends JPanel {
	private JTextField tId;
	private JTextField tDrzava;
	private JTextField tIme;
	private JTextField tImeRoditelja;
	private JTextField tPrezime;
	private JRadioButton rMale;
    private JRadioButton rFemale;
    private ButtonGroup genderButtonGroup;
    private JTextField tMaticni;
    private JTextField tUsername;
    private JTextField tPassword;
    private JButton submitButton;
	
	public ZaposleniInputView(TableModel tableModel,Boolean isAdAction)
	{
		GridLayout gridLayout=new GridLayout(2,2);
		setLayout(gridLayout);
		gridLayout.setHgap(4);
		setLayout(gridLayout);
		setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		rMale=new JRadioButton("Musko");
		rFemale=new JRadioButton("Zensko");
		genderButtonGroup = new ButtonGroup();
		 genderButtonGroup.add(rFemale);
		 genderButtonGroup.add(rMale);
		submitButton=new JButton();
		
			 		 
		
		if(isAdAction)
		{
			 tIme=new JTextField();
			tImeRoditelja=new JTextField();
			tPrezime=new JTextField();
			tMaticni=new JTextField();
		    tUsername=new JTextField();
		    tPassword=new JTextField();
			
			add(new InputComponent(tableModel.getColumnName(2),tPrezime,true));
			add(new InputComponent(tableModel.getColumnName(3),tImeRoditelja,true));
			add(new InputComponent(tableModel.getColumnName(4),tIme,true));
			
			add(new InputComponent(tableModel.getColumnName(5),genderButtonGroup,rMale,rFemale));
		
			
			add(new InputComponent(tableModel.getColumnName(6),tMaticni,true));
			
			add(new InputComponent("Username",tUsername,true));
			add(new InputComponent("Password",tPassword,true));
			
			submitButton.setText("Dodaj");
            submitButton.setActionCommand("addZaposleni");
            submitButton.addActionListener(new ResourceController(this));
                
            add(new InputComponent(submitButton)); 	
			 
			
			
		}
		else
		{
			tId=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(), 0).toString());
			tDrzava=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(), 1).toString());
			tPrezime=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(), 2).toString());
			tImeRoditelja=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(), 3).toString());
			tIme=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(), 4).toString());
			tMaticni=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(), 6).toString());
			
			
			add(new InputComponent(tableModel.getColumnName(0),tId,false));
			add(new InputComponent(tableModel.getColumnName(1),tDrzava,false));
			add(new InputComponent(tableModel.getColumnName(2),tPrezime,true));
			add(new InputComponent(tableModel.getColumnName(3),tImeRoditelja,true));
			add(new InputComponent(tableModel.getColumnName(4),tIme,true));
			
          
			if(tableModel.getValueAt(tableModel.getSelectRow(),5).toString().equals("m"))
			rMale.setSelected(true);
			else
			rFemale.setSelected(true);
				
			add(new InputComponent(tableModel.getColumnName(5),genderButtonGroup,rMale,rFemale)); 
			
			
		    add(new InputComponent(tableModel.getColumnName(6),tMaticni,true));
			
		    submitButton.setText("Izmjeni");
            submitButton.setActionCommand("editZaposleni");
            submitButton.addActionListener(new ResourceController(this));
                
            add(new InputComponent(submitButton)); 
			
		}
		
				
		
	}
	public JTextField gettId() {
		return tId;
	}
	public JTextField gettDrzava() {
		return tDrzava;
	}
	public JTextField gettIme() {
		return tIme;
	}
	public JTextField gettImeRoditelja() {
		return tImeRoditelja;
	}
	public JTextField gettPrezime() {
		return tPrezime;
	}
	public JRadioButton getrMale() {
		return rMale;
	}
	public JRadioButton getrFemale() {
		return rFemale;
	}
	public ButtonGroup getGenderButtonGroup() {
		return genderButtonGroup;
	}
	public JTextField gettMaticni() {
		return tMaticni;
	}
	public JTextField gettUsername() {
		return tUsername;
	}
	public JTextField gettPassword() {
		return tPassword;
	}
	public JButton getSubmitButton() {
		return submitButton;
	}
	public String getGender() {
		String gender = "";
		for(Enumeration<AbstractButton> buttons = genderButtonGroup.getElements(); buttons.hasMoreElements();) 
		{
	        AbstractButton genderButton = buttons.nextElement();
			if(genderButton.isSelected())
			{
				switch (genderButton.getText()) {
				case "Musko":
					gender = "m";
					break;

				case "Zensko":
					gender = "z";
					break;
				}
			}
		}
	
		return gender;
	}
	public String getPaswordMd5()
	{
		String password=gettPassword().getText();
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
		
		return password;
	}



}
