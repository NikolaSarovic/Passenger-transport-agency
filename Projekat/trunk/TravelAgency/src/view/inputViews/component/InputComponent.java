package view.inputViews.component;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.OfficeControler;
import view.inputViews.PoslovniceInputView;
import view.style.StyledButtonUI;

public class InputComponent extends JPanel {
	private JLabel label;
	
	public InputComponent(String labelText, JTextField jTextField, Boolean setEnable) {
		label = new JLabel(String.format("%s:", labelText));
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		add(label, BorderLayout.NORTH);
		
		if(!setEnable)
		{
			jTextField.setEnabled(false);
		}
		jTextField.setPreferredSize(new Dimension(80,20));
		add(jTextField, BorderLayout.SOUTH);
	}

public InputComponent(String labelText,JComboBox podaci,String selectedRow,Boolean isUpdate)
{
	label = new JLabel(String.format("%s:", labelText));
	label.setFont(new Font("Arial", Font.PLAIN, 14));
	add(label,BorderLayout.NORTH);
	
	podaci.setPreferredSize(new Dimension(150,20));

	
	if(isUpdate==false)
	{
		
		podaci.setSelectedItem(selectedRow);
	}
	
	add(podaci,BorderLayout.NORTH);
	
	

}
	
	public InputComponent(String labelText, ButtonGroup btng,JRadioButton rdb1,JRadioButton rdb2) {
		label = new JLabel(String.format("%s:", labelText));
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		add(label,BorderLayout.NORTH);
		
		
		/*for (JRadioButton jRadioButton :( Enumeration<AbstractButton>) btng.getElements()) {
			add(jRadioButton,BorderLayout.SOUTH);
			
		}*/
		add(rdb1,BorderLayout.SOUTH);
		add(rdb2,BorderLayout.SOUTH);
				
		
	}
	
	public InputComponent(String labelText, JFormattedTextField formatTextField) {
		label=new JLabel(labelText);
		add(label,BorderLayout.NORTH);
		
		
		//formatTextField.setText(ftf.getText());
		
		add(formatTextField,BorderLayout.SOUTH);
	}
	
	
	public InputComponent(JButton button) {
		
		button.setFont(new Font("Arial", Font.PLAIN, 10));
		button.setBackground(Color.decode("#D0D3D4"));
		add(button, BorderLayout.NORTH);
	}
	
	

		   		
			
	
	
}
