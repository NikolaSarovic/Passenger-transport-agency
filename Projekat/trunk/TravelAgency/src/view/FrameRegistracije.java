package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.RegistrationController;
import model.RegistrationModel;
import view.style.StyledButtonUI;

public class FrameRegistracije extends JFrame {
	
	RegistrationModel registrationModel;

	private Container c;
	
	private JLabel title;
	private JLabel firstName;
	private JTextField tFirstName;
	private JLabel lastName;
	private JTextField tLastName;
	private JLabel userName;
	private JTextField tUserName;
	private JLabel password;
	private JPasswordField tPassword;
	private JLabel confirmPassword;
	private JPasswordField tConfirmPassword;
	private JLabel gender;
	private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup genderButtonGroup;
    private JLabel parentName;
	private JTextField tParentName;
	private JLabel identificationNumber;
	private JTextField tIdentificationNumber;
	private JLabel phoneNumber;
	private JTextField tPhoneNumber;
	private JLabel email;
	private JTextField tEmail;
	private JLabel address;
	private JTextField tAddress;
	private JLabel birthDate;
	private JComboBox day;
    private JComboBox month;
    private JComboBox year;
    
    private JButton submitButton;
    private JButton exitButton;
    
    private String days[]
            = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
        		"10", "11", "12", "13", "14", "15", "16", "17", "18",
        		"19", "20", "21", "22", "23", "24", "25", "26", "27",
        		"28", "29", "30", "26", "27", "28", "29", "30", "31" 
          		};
    
    private String months[]
        = { "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
    
    private String years[]
        = { "2005", "2004", "2003", "2002", "2001", 
    		"2000", "1999", "1998", "1997", "1996", 
    		"1995", "1994", "1993", "1992", "1991", 
    		"1990", "1989", "1988", "1987", "1986", 
    		"1985", "1984", "1983", "1982", "1981", 
    		"1980", "1979", "1978", "1977", "1976", 
    		"1975", "1974", "1973", "1972", "1971", 
    		"1970", "1969", "1968", "1967", "1966", 
    		"1965", "1964", "1963", "1962", "1961", 
    		"1960", "1959", "1958", "1957", "1956", 
    		"1955", "1954", "1953", "1952", "1951"
           };
    
    private String requiredField = "<html><font color=black>%s</font><font color=red>*</font></html>";
	
	public FrameRegistracije(RegistrationModel registrationModel) 
	{
		this.registrationModel = registrationModel;
				
		setTitle("Registracija");
	    setBounds(300, 90, 750, 460);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    
	    c = getContentPane();
	    c.setLayout(null);
	    
	    title = new JLabel("Forma za registraciju");
        title.setFont(new Font("Arial", Font.PLAIN, 26));
        title.setSize(250, 30);
        title.setLocation(250, 25);
        c.add(title);
        
        firstName = new JLabel(String.format(requiredField, "Ime"));
        firstName.setFont(new Font("Arial", Font.PLAIN, 14));
        firstName.setSize(150, 20);
        firstName.setLocation(50, 100);
        c.add(firstName);
        
        tFirstName = new JTextField();
        tFirstName.setFont(new Font("Arial", Font.PLAIN, 12));
        tFirstName.setSize(150, 20);
        tFirstName.setLocation(50, 120);
        c.add(tFirstName);
        
        lastName = new JLabel(String.format(requiredField, "Prezime"));
        lastName.setFont(new Font("Arial", Font.PLAIN, 14));
        lastName.setSize(150, 20);
        lastName.setLocation(300, 100);
        c.add(lastName);
        
        tLastName = new JTextField();
        tLastName.setFont(new Font("Arial", Font.PLAIN, 12));
        tLastName.setSize(150, 20);
        tLastName.setLocation(300, 120);
        c.add(tLastName);
        
        parentName = new JLabel("Ime roditelja");
        parentName.setFont(new Font("Arial", Font.PLAIN, 14));
        parentName.setSize(150, 20);
        parentName.setLocation(550, 100);
        c.add(parentName);
        
        tParentName = new JTextField();
        tParentName.setFont(new Font("Arial", Font.PLAIN, 12));
        tParentName.setSize(150, 20);
        tParentName.setLocation(550, 120);
        c.add(tParentName);
        
        userName = new JLabel(String.format(requiredField, "Korisni??ko ime"));
        userName.setFont(new Font("Arial", Font.PLAIN, 14));
        userName.setSize(150, 20);
        userName.setLocation(50, 160);
        c.add(userName);
        
        tUserName = new JTextField();
        tUserName.setFont(new Font("Arial", Font.PLAIN, 12));
        tUserName.setSize(150, 20);
        tUserName.setLocation(50, 180);
        c.add(tUserName);
        
        password = new JLabel(String.format(requiredField, "Lozinka"));
        password.setFont(new Font("Arial", Font.PLAIN, 14));
        password.setSize(150, 20);
        password.setLocation(300, 160);
        c.add(password);
        
        tPassword = new JPasswordField();
        tPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        tPassword.setSize(150, 20);
        tPassword.setLocation(300, 180);
        c.add(tPassword);
        
        confirmPassword = new JLabel(String.format(requiredField, "Potvrda lozinke"));
        confirmPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPassword.setSize(150, 20);
        confirmPassword.setLocation(550, 160);
        c.add(confirmPassword);
        
        tConfirmPassword = new JPasswordField();
        tConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        tConfirmPassword.setSize(150, 20);
        tConfirmPassword.setLocation(550, 180);
        c.add(tConfirmPassword);
        
        gender = new JLabel(String.format(requiredField, "Pol"));
        gender.setFont(new Font("Arial", Font.PLAIN, 14));
        gender.setSize(30, 20);
        gender.setLocation(50, 230);
        c.add(gender);
 
        male = new JRadioButton("Mu??ko");
        male.setFont(new Font("Arial", Font.PLAIN, 14));
        male.setSelected(true);
        male.setSize(80, 20);
        male.setLocation(120, 230);
        c.add(male);
 
        female = new JRadioButton("??ensko");
        female.setFont(new Font("Arial", Font.PLAIN, 14));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(120, 250);
        c.add(female);
 
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(male);
        genderButtonGroup.add(female);
        
        birthDate = new JLabel(String.format(requiredField, "Datum ro??enja"));
        birthDate.setFont(new Font("Arial", Font.PLAIN, 14));
        birthDate.setSize(100, 20);
        birthDate.setLocation(300, 230);
        c.add(birthDate);
 
        day = new JComboBox(days);
        day.setFont(new Font("Arial", Font.PLAIN, 12));
        day.setSize(50, 20);
        day.setLocation(300, 250);
        c.add(day);
 
        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 12));
        month.setSize(60, 20);
        month.setLocation(350, 250);
        c.add(month);
 
        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 12));
        year.setSize(60, 20);
        year.setLocation(420, 250);
        c.add(year);
        
        identificationNumber = new JLabel(String.format(requiredField, "Mati??ni broj"));
        identificationNumber.setFont(new Font("Arial", Font.PLAIN, 14));
        identificationNumber.setSize(150, 20);
        identificationNumber.setLocation(550, 230);
        c.add(identificationNumber);
        
        tIdentificationNumber = new JTextField();
        tIdentificationNumber.setFont(new Font("Arial", Font.PLAIN, 12));
        tIdentificationNumber.setSize(150, 20);
        tIdentificationNumber.setLocation(550, 250);
        c.add(tIdentificationNumber);
        
        phoneNumber = new JLabel("Broj telefona");
        phoneNumber.setFont(new Font("Arial", Font.PLAIN, 14));
        phoneNumber.setSize(150, 20);
        phoneNumber.setLocation(50, 300);
        c.add(phoneNumber);
        
        tPhoneNumber = new JTextField();
        tPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
        tPhoneNumber.setSize(150, 20);
        tPhoneNumber.setLocation(50, 320);
        c.add(tPhoneNumber);
        
        email = new JLabel("E-mail");
        email.setFont(new Font("Arial", Font.PLAIN, 14));
        email.setSize(150, 20);
        email.setLocation(300, 300);
        c.add(email);
        
        tEmail = new JTextField();
        tEmail.setFont(new Font("Arial", Font.PLAIN, 12));
        tEmail.setSize(150, 20);
        tEmail.setLocation(300, 320);
        c.add(tEmail);
        
        address = new JLabel("Adresa");
        address.setFont(new Font("Arial", Font.PLAIN, 14));
        address.setSize(150, 20);
        address.setLocation(550, 300);
        c.add(address);
        
        tAddress = new JTextField();
        tAddress.setFont(new Font("Arial", Font.PLAIN, 12));
        tAddress.setSize(150, 20);
        tAddress.setLocation(550, 320);
        c.add(tAddress);
        
        submitButton = new JButton("Registruj se");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        submitButton.setSize(150, 25);
        submitButton.setLocation(300, 380);
        submitButton.setBackground(Color.decode("#D0D3D4"));
        submitButton.setUI(new StyledButtonUI());
        submitButton.setActionCommand("Registration");
        c.add(submitButton);
 
        exitButton = new JButton("Odustani");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        exitButton.setSize(100, 20);
        exitButton.setLocation(325, 420);
        exitButton.setBackground(Color.decode("#EC7063"));
        exitButton.setUI(new StyledButtonUI());
        exitButton.setActionCommand("Exit");
        c.add(exitButton);
	    
        setUndecorated(true);
        setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	public String getFirstName() {
		return tFirstName.getText();
	}


	public String getLastName() {
		return tLastName.getText();
	}


	public String getParentName() {
		return tParentName.getText();
	}
	
	public String getUserName() {
		return tUserName.getText();
	}


	public String getPassword() {
		return convertToMD5Hash(tPassword.getText());
	}


	public String getConfirmPassword() {
		return convertToMD5Hash(tConfirmPassword.getText());
	}


	public String getGender() {
		String gender = "";
		for(Enumeration<AbstractButton> buttons = genderButtonGroup.getElements(); buttons.hasMoreElements();) 
		{
	        AbstractButton genderButton = buttons.nextElement();
			if(genderButton.isSelected())
			{
				switch (genderButton.getText()) {
				case "Mu??ko":
					gender = "M";
					break;

				case "??ensko":
					gender = "??";
					break;
				}
			}
		}
	
		return gender;
	}


	public String getBirthDate() {
		String selectDay = day.getSelectedItem().toString();
		String selectMonth = month.getSelectedItem().toString();
		String selectYear = year.getSelectedItem().toString();
		return String.format("%s-%s-%s", selectYear, selectMonth, selectDay);
	}
	

	public String getIdentificationNumber() {
		return tIdentificationNumber.getText();
	}


	public String getPhoneNumber() {
		return tPhoneNumber.getText();
	}


	public String getEmail() {
		return tEmail.getText();
	}


	public String getAddress() {
		return tAddress.getText();
	}
	
	
	public RegistrationModel getRegistrationModel() {
		return registrationModel;
	}

	public void setRegistrationModel(RegistrationModel registrationModel) {
		this.registrationModel = registrationModel;
	}
	
	public void addActionListeners(RegistrationController controller)
	{
		this.submitButton.addActionListener(controller);
		this.exitButton.addActionListener(controller);
	}
	
	private String convertToMD5Hash(String string)
	{
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(string.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            string = sb.toString();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		return string;
	}
	
	public void clearPasswordFields()
	{
		tPassword.setText("");
		tConfirmPassword.setText("");
	}
	
	

}
