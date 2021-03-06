package view.inputViews;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.OfficeControler;
import model.ProcedureModel;
import model.TableModel;
import view.inputViews.component.InputComponent;

public class PoslovniceInputView extends JPanel {
	
	private JTextField tOznakaJedinice;
	private JTextField tDr?ava;
	private JTextField tNaziv;
	private JTextField tAdresa;
	private JTextField tTelefon;
	private JTextField tEmail;
    private JComboBox gradoviBIH;
	private JButton submitButton;
	
	OfficeControler office;
	public PoslovniceInputView(TableModel tableModel, Boolean isAddAction)
	{
		//int rowCount = tableModel.getColumnCount()/4;
		GridLayout gridLayout=new GridLayout(2,4);
		setLayout(gridLayout);
		gridLayout.setHgap(4);
		setLayout(gridLayout);
		setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		submitButton=new JButton();
		gradoviBIH=gradovi();	
		
		if(isAddAction)
		{
			tNaziv= new JTextField();
			tAdresa=new JTextField();
			 tTelefon=new JTextField();
			 tEmail=new JTextField();
				
			add(new InputComponent(tableModel.getColumnName(2), tNaziv, true));
			add(new InputComponent(tableModel.getColumnName(3), tAdresa, true));
			add(new InputComponent(tableModel.getColumnName(4), tTelefon, true));
			add(new InputComponent(tableModel.getColumnName(5), tEmail, true));
            add(new InputComponent(tableModel.getColumnName(6), gradoviBIH," ",true));
			
            submitButton.setText("Dodaj");
            submitButton.setActionCommand("add");
            submitButton.addActionListener(new OfficeControler(this));
                
            add(new InputComponent(submitButton));       
			
		}
		else
		{
			 tOznakaJedinice=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),0).toString());
			 tDr?ava=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),1).toString());
			tNaziv= new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),2).toString());
			tAdresa=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),3).toString());
			 tTelefon=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),4).toString());
			 tEmail=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),5).toString());
			 
			    add(new InputComponent(tableModel.getColumnName(0), tOznakaJedinice, false));
				add(new InputComponent(tableModel.getColumnName(1), tDr?ava, false));
				add(new InputComponent(tableModel.getColumnName(2), tNaziv, true));
				add(new InputComponent(tableModel.getColumnName(3), tAdresa, true));
				add(new InputComponent(tableModel.getColumnName(4), tTelefon, true));
				add(new InputComponent(tableModel.getColumnName(5), tEmail, true));
		        add(new InputComponent(tableModel.getColumnName(6), gradoviBIH,(tableModel.getValueAt(tableModel.getSelectRow(),6).toString()),false));
			
		        submitButton.setText("Izmjeni");
                submitButton.setActionCommand("edit");
                submitButton.addActionListener(new OfficeControler(this));
                    
                add(new InputComponent(submitButton));
		
				
               
		}
		
						
	}
	
	public JComboBox gradovi()
	{
		JComboBox box;
		 Vector<String> podaci=new Vector<>();
		
		try {
			ResultSet result=ProcedureModel.getInstance().executeProcedure("{call st_AInputGradoviZaposleni}");
			ResultSetMetaData resultSetMetaData=result.getMetaData();
			while(result.next())
			{
			for(int i=0;i<resultSetMetaData.getColumnCount();i++)
			{
				
				podaci.add(result.getString(i+1));
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		box=new JComboBox(podaci);
		
		
				
		return box;
	}

	public JTextField gettOznakaJedinice() {
		return tOznakaJedinice;
	}

	public JTextField gettDr?ava() {
		return tDr?ava;
	}

	public JTextField gettNaziv() {
		return tNaziv;
	}

	public JTextField gettAdresa() {
		return tAdresa;
	}

	public JTextField gettTelefon() {
		return tTelefon;
	}

	public JTextField gettEmail() {
		return tEmail;
	}

	public JComboBox getGradoviBIH() {
		return gradoviBIH;
	}
	

	public JButton getSubmitButton() {
		return submitButton;
	}

	
}
