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
import controller.ResourceController;
import model.ProcedureModel;
import model.TableModel;
import view.inputViews.component.InputComponent;

public class VozilaInputView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField tID;
	private JTextField tDržava;
    private JComboBox gradoviBIH;
    private JComboBox nacinPrevoza;
    private JTextField tNazivAgencijeJedinice;
    private JTextField tNazivVozila;
    private JTextField tPotrosnja;
    private JButton submitButton;
    
	
	public VozilaInputView(TableModel tableModel,Boolean isAddAction) {
		
		GridLayout gridLayout=new GridLayout(2,4);
		setLayout(gridLayout);
		gridLayout.setHgap(4);
		setLayout(gridLayout);
		setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		gradoviBIH=gradovi();
		nacinPrevoza=tipPrevoza();
		submitButton=new JButton();
		
		if(isAddAction)
		{
			  tNazivVozila=new JTextField();
		     tPotrosnja=new JTextField();
    		
		    add(new InputComponent(tableModel.getColumnName(2), gradoviBIH," ",true));
			add(new InputComponent(tableModel.getColumnName(3), nacinPrevoza," ",true));
			
			add(new InputComponent(tableModel.getColumnName(5), tNazivVozila, true));
			add(new InputComponent(tableModel.getColumnName(6), tPotrosnja, true));
			
			submitButton.setText("Dodaj");
            submitButton.setActionCommand("addVozila");
            submitButton.addActionListener(new ResourceController(this));
                
            add(new InputComponent(submitButton));  
		}
		else
		{
			tID=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),0).toString());
			 tDržava=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),1).toString());
			 tNazivVozila=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),5).toString());
			 tPotrosnja=new JTextField(tableModel.getValueAt(tableModel.getSelectRow(),6).toString());
			 
			 add(new InputComponent(tableModel.getColumnName(0), tID, false));
			 add(new InputComponent(tableModel.getColumnName(1), tDržava, false));
			 
			 add(new InputComponent(tableModel.getColumnName(2), gradoviBIH,(tableModel.getValueAt(tableModel.getSelectRow(),2).toString()),false));
			 add(new InputComponent(tableModel.getColumnName(3), nacinPrevoza,(tableModel.getValueAt(tableModel.getSelectRow(),3).toString()),false));
			
			 add(new InputComponent(tableModel.getColumnName(5), tNazivVozila, true));
			 add(new InputComponent(tableModel.getColumnName(6), tPotrosnja, true));
			 
			 submitButton.setText("Izmjeni");
	         submitButton.setActionCommand("editVozila");
	         submitButton.addActionListener(new ResourceController(this));
	                
	           add(new InputComponent(submitButton));  
		}
		
	
	}
	
	public JComboBox gradovi()
	{
		JComboBox box;
		 Vector<String> podaci=new Vector<>();
		
		try {
			ResultSet result=ProcedureModel.getInstance().executeProcedure("{call st_AInputGradoviJedinice}");
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
	public JComboBox tipPrevoza()
	{
		JComboBox box;
		 Vector<String> podaci=new Vector<>();
		
		try {
			ResultSet result=ProcedureModel.getInstance().executeProcedure("{call st_AInputNazivTipPrevoza}");
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public JTextField gettID() {
		return tID;
	}
	public JTextField gettDržava() {
		return tDržava;
	}
	public JComboBox getGradoviBIH() {
		return gradoviBIH;
	}
	public JComboBox getNacinPrevoza() {
		return nacinPrevoza;
	}
	public JTextField gettNazivAgencijeJedinice() {
		return tNazivAgencijeJedinice;
	}
	public JTextField gettNazivVozila() {
		return tNazivVozila;
	}
	public JTextField gettPotrosnja() {
		return tPotrosnja;
	}
	public JButton getSubmitButton() {
		return submitButton;
	}
	
	
	

}
