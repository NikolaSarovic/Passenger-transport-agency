package view.inputViews;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import controller.OfficeControler;
import controller.TransportationController;
import model.ProcedureModel;
import model.TableModel;
import view.inputViews.component.InputComponent;

public class PutovanjaInputMenadzer extends JPanel {
	
	private JFormattedTextField ftVrijemePolaska;
	private JFormattedTextField ftVrijemeDolaska;	
	private JTextField tID;
    private JTextField tDrzava;
    private JComboBox LokacijaPolaska;
    private JComboBox LokacijaDolaska;
    private JTextField tNapomena;
    private JComboBox TipPrevoza;
    private JComboBox TipPutovanja;
    private JButton submitButton;
 
	
	public PutovanjaInputMenadzer(TableModel tableModel,Boolean isAddAction) {
		GridLayout gridLayout=new GridLayout(3,4);
		setLayout(gridLayout);
		gridLayout.setHgap(4);
		setLayout(gridLayout);
		setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ftVrijemePolaska = new JFormattedTextField(formatter);
        ftVrijemePolaska.setColumns(20);
       ftVrijemePolaska.setText("yyyy-MM-dd hh:mm:ss");
       
       SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       ftVrijemeDolaska = new JFormattedTextField(formatter2);
       ftVrijemeDolaska.setColumns(20);
      ftVrijemeDolaska.setText("yyyy-MM-dd hh:mm:ss");
      
      LokacijaPolaska=gradoviOrgJedinica();
      LokacijaDolaska=sviGradovi();
      TipPrevoza=tipPrevoza();
      TipPutovanja=tipPutovanja();
      submitButton=new JButton();
      
      
      if(isAddAction)
     {

    	  tNapomena=new JTextField();
    	  
    	  
    add(new InputComponent(tableModel.getColumnName(2),LokacijaPolaska,"",true));
    add(new InputComponent(tableModel.getColumnName(3),LokacijaDolaska,"",true));
    add(new InputComponent(tableModel.getColumnName(4),ftVrijemePolaska));
    add(new InputComponent(tableModel.getColumnName(5),ftVrijemeDolaska));
    add(new InputComponent(tableModel.getColumnName(6), tNapomena, true));
    add(new InputComponent(tableModel.getColumnName(7),TipPrevoza,"",true));	  	  
    add(new InputComponent(tableModel.getColumnName(8),TipPutovanja,"",true));	
    
    submitButton.setText("Dodaj");
    submitButton.setActionCommand("add");
    submitButton.addActionListener(new TransportationController(this));
    
    add(new InputComponent(submitButton)); 
    	  
     }
      else
      {
    	  tID=new JFormattedTextField(tableModel.getValueAt(tableModel.getSelectRow(),0));
    	  tDrzava=new JFormattedTextField(tableModel.getValueAt(tableModel.getSelectRow(),1));
    	  tNapomena=new JFormattedTextField(tableModel.getValueAt(tableModel.getSelectRow(),6));
    	  ftVrijemePolaska.setText(tableModel.getValueAt(tableModel.getSelectRow(),4).toString());
    	  ftVrijemeDolaska.setText(tableModel.getValueAt(tableModel.getSelectRow(),5).toString());
    	 
    	  add(new InputComponent(tableModel.getColumnName(0), tID, false));
    	  add(new InputComponent(tableModel.getColumnName(1), tDrzava, false));
    	 
    	  
    	  add(new InputComponent(tableModel.getColumnName(2),LokacijaPolaska,tableModel.getValueAt(tableModel.getSelectRow(),2).toString(),false));
    	  add(new InputComponent(tableModel.getColumnName(3),LokacijaDolaska,tableModel.getValueAt(tableModel.getSelectRow(),3).toString(),false));
    	  
    	  add(new InputComponent(tableModel.getColumnName(4),ftVrijemePolaska));
    	    add(new InputComponent(tableModel.getColumnName(5),ftVrijemeDolaska));
    	  
    	    add(new InputComponent(tableModel.getColumnName(6), tNapomena, true));
    	    
    	    add(new InputComponent(tableModel.getColumnName(7), TipPrevoza,(tableModel.getValueAt(tableModel.getSelectRow(),7).toString()),false));  	  
    	   add(new InputComponent(tableModel.getColumnName(8),TipPutovanja,tableModel.getValueAt(tableModel.getSelectRow(),8).toString(),false));	
    	  
    	   submitButton.setText("Izmjeni");
           submitButton.setActionCommand("edit");
           submitButton.addActionListener(new TransportationController(this));
               
           add(new InputComponent(submitButton));
    	  
      }
            	        
	        
		
	}
	public JComboBox gradoviOrgJedinica()
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
	public JComboBox sviGradovi()
	{
		JComboBox box;
		 Vector<String> podaci=new Vector<>();
		
		try {
			ResultSet result=ProcedureModel.getInstance().executeProcedure("{call st_AInputGradoviSvi}");
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
	public JComboBox tipPutovanja()
	{
		JComboBox box;
		 Vector<String> podaci=new Vector<>();
		
		try {
			ResultSet result=ProcedureModel.getInstance().executeProcedure("{call st_AIntputNazivTipPutovanja}");
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
	public JFormattedTextField getFtVrijemePolaska() {
		return ftVrijemePolaska;
	}
	public JFormattedTextField getFtVrijemeDolaska() {
		return ftVrijemeDolaska;
	}
	public JTextField gettID() {
		return tID;
	}
	public JTextField gettDrzava() {
		return tDrzava;
	}
	public JComboBox getLokacijaPolaska() {
		return LokacijaPolaska;
	}
	public JComboBox getLokacijaDolaska() {
		return LokacijaDolaska;
	}
	public JTextField gettNapomena() {
		return tNapomena;
	}
	public JComboBox getTipPrevoza() {
		return TipPrevoza;
	}
	public JComboBox getTipPutovanja() {
		return TipPutovanja;
	}
	public JButton getSubmitButton() {
		return submitButton;
	}
	
	

}
