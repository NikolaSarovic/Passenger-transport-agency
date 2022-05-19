package view.inputViews;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.OfficeControler;
import controller.ReservationController;
import model.ProcedureModel;
import model.TableModel;
import view.inputViews.component.InputComponent;

public class RezervacijeInputMenadzer extends JPanel {
	
	private JTextField tID;
	private JTextField tDržava;
	private JComboBox odobrenjeRezervacije;
	private JTextField tVrijemeRez;
    private JTextField tLokacijaPolaska;
    private JTextField tLokacijaDolaska;
    private JTextField tFl_id;
    private JTextField tImeputnika;
    private JTextField tPrezimeputnika;
    private JTextField tMaticni;
    private JTextField tEmail;
    private JTextField tMobilni;
    
    private JButton submitButton;
	
	public RezervacijeInputMenadzer(TableModel tableModel,Boolean isAddAction) {
		//int rowCount = tableModel.getColumnCount()/4;
				GridLayout gridLayout=new GridLayout(3,5);
				setLayout(gridLayout);
				gridLayout.setHgap(4);
				setLayout(gridLayout);
				setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
				
		submitButton=new JButton();
		odobrenjeRezervacije=new JComboBox<>();
		odobrenjeRezervacije.addItem("Prihvacena rezervacija");
		odobrenjeRezervacije.addItem("Odbijena rezervacija");
		
		tID=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),0).toString());
		 tDržava=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),1).toString());
		tVrijemeRez= new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),3).toString());
		tLokacijaPolaska=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),4).toString());
		 tLokacijaDolaska=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),5).toString());
		tFl_id=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),6).toString());
		 tImeputnika=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),7).toString());
		 tPrezimeputnika= new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),8).toString());
		tMaticni=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),9).toString());
		 tEmail=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),10).toString());
		 tMobilni=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),11).toString());
		 
		 
		 add(new InputComponent(tableModel.getColumnName(0), tID, false));
			add(new InputComponent(tableModel.getColumnName(1), tDržava, false));
			 
add(new InputComponent(tableModel.getColumnName(2), odobrenjeRezervacije,(tableModel.getValueAt(tableModel.getSelectRow(),2).toString()),false));
			
			 add(new InputComponent(tableModel.getColumnName(3), tVrijemeRez, false));
			add(new InputComponent(tableModel.getColumnName(4), tLokacijaPolaska, false));
			add(new InputComponent(tableModel.getColumnName(5), tLokacijaDolaska, false));
			add(new InputComponent(tableModel.getColumnName(6), tFl_id, false));
			add(new InputComponent(tableModel.getColumnName(7), tImeputnika, false));
			 add(new InputComponent(tableModel.getColumnName(8), tPrezimeputnika, false));
			add(new InputComponent(tableModel.getColumnName(9), tMaticni, false));
			add(new InputComponent(tableModel.getColumnName(10), tEmail, false));
			add(new InputComponent(tableModel.getColumnName(11), tMobilni, false));
			
      
			 submitButton.setText("Izmjeni");
             submitButton.setActionCommand("edit");
             submitButton.addActionListener(new ReservationController(this));
                 
             add(new InputComponent(submitButton));
		
		
		
	}


	public JTextField gettFl_id() {
		return tFl_id;
	}


	public JTextField gettID() {
		return tID;
	}

	public JTextField gettDržava() {
		return tDržava;
	}

	public JComboBox getOdobrenjeRezervacije() {
		return odobrenjeRezervacije;
	}

	public JTextField gettVrijemeRez() {
		return tVrijemeRez;
	}

	public JTextField gettLokacijaPolaska() {
		return tLokacijaPolaska;
	}

	public JTextField gettLokacijaDolaska() {
		return tLokacijaDolaska;
	}

	public JTextField gettImeputnika() {
		return tImeputnika;
	}

	public JTextField gettPrezimeputnika() {
		return tPrezimeputnika;
	}

	public JTextField gettMaticni() {
		return tMaticni;
	}

	public JTextField gettEmail() {
		return tEmail;
	}

	public JTextField gettMobilni() {
		return tMobilni;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}
	
	
	

}
