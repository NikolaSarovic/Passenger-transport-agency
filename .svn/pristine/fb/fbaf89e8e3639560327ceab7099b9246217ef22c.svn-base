package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ProcedureModel;
import model.RegistrationModel;
import view.FrameRegistracije;

public class RegistrationController implements ActionListener {

	private RegistrationModel registrationModel;
	private FrameRegistracije registrationView;
	
	public RegistrationController() {
		// TODO Auto-generated constructor stub
	}
	
	public RegistrationController(RegistrationModel registrationModel, FrameRegistracije registrationView) {
		super();
		this.registrationModel = registrationModel;
		this.registrationView = registrationView;
		this.registrationView.addActionListeners(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Registration":
			populateRegistrationModel(registrationModel, registrationView);
			
			if(isRequiredFieldEmpty())
			{
				showOptionPane("Nisu popunjena sva obavezna polja za unos!", "Obavezna polja");
				break;
			}
			
			if(!isConfirmPasswordCorrect(registrationModel.getPassword(), registrationModel.getConfirmPassword()))
			{
				showOptionPane("Lozinka za potvrdu nije odgovarajuća!Unesite novu lozinku.", "Lozinka potvrde");
				registrationView.clearPasswordFields();
				break;
			}
			
			if(isUserNameExists(registrationModel.getUserName()))
			{
				showOptionPane("Uneseno korisničko ime je zauzeto! Unesite novo.", "Zauzeto korisničko ime");
				break;
			}
			else
			{
				registerUser(registrationModel);
				String successRegistrationMessage = String.format("Poštovani %s %s, uspješno ste se registrovali!", registrationModel.getFirstName(), registrationModel.getLastName());
				showOptionPane(successRegistrationMessage, "Uspješna registracija");
				registrationView.dispose();
			}
			
			break;

		case "Exit":
			registrationView.dispose();
			break;
		}
		
	}
	
	public void populateRegistrationModel(RegistrationModel registrationModel, FrameRegistracije registrationView)
	{
		registrationModel.setFirstName(registrationView.getFirstName());
		registrationModel.setLastName(registrationView.getLastName());
		registrationModel.setParentName(registrationView.getParentName());
		registrationModel.setUserName(registrationView.getUserName());
		registrationModel.setPassword(registrationView.getPassword());
		registrationModel.setConfirmPassword(registrationView.getConfirmPassword());
		registrationModel.setGender(registrationView.getGender());
		registrationModel.setBirthDate(registrationView.getBirthDate());
		registrationModel.setIdentificationNumber(registrationView.getIdentificationNumber());
		registrationModel.setPhoneNumber(registrationView.getPhoneNumber());
		registrationModel.setEmail(registrationView.getEmail());
		registrationModel.setAddress(registrationView.getAddress());
	}
	
	public void registerUser(RegistrationModel rm)
	{
		ProcedureModel.getInstance().executeProcedure("{call st_Registracija(?,?,?,?,?,?,?,?,?,?,?,?,?)}",
		rm.getFirstName(), rm.getLastName(), rm.getUserName(), rm.getPassword(), rm.getGender(), rm.getCreationDate(), 
		rm.getYear(), rm.getParentName(), rm.getIdentificationNumber(), rm.getPhoneNumber(), rm.getEmail(),
		rm.getAddress(), rm.getBirthDate());
		
	}
	
	public Boolean isConfirmPasswordCorrect(String password, String confirmPassword)
	{
		if(password.equals(confirmPassword))
			return true;
		else
			return false;
	}
	
	public Boolean isUserNameExists(String userName)
	{
		ResultSet rs = ProcedureModel.getInstance().executeProcedure("{call st_ProvjeriKorisnickoIme(?)}", userName);
		
		try {
			while(rs.next())
			{	
				if (rs.getString(1) != null)
				{
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void showOptionPane(String messagge, String title)
	{
		JOptionPane.showMessageDialog(registrationView, messagge, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Boolean isRequiredFieldEmpty()
	{
		if(registrationModel.getFirstName().equals("") || registrationModel.getLastName().equals("") ||
			registrationModel.getUserName().equals("") || registrationModel.getPassword().equals("") ||
			registrationModel.getGender().equals("") || registrationModel.getBirthDate().equals("") ||
			registrationModel.getIdentificationNumber().equals(""))
		{
			return true;
		}
		else
			return false;
	}
	
}
