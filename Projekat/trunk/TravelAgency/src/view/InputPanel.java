package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import command.Command;
import command.DeleteCommand;
import model.TableModel;
import view.inputViews.PoslovniceInputView;
import view.inputViews.PutovanjaInputMenadzer;
import view.inputViews.RezervacijeInputMenadzer;
import view.inputViews.VozilaInputView;
import view.inputViews.ZaposleniInputView;

public class InputPanel extends JPanel { //ne treba ovako ovo je primjer preko actionlistenera

	TableModel tableModel = null;
	
	private JLabel label;
	private TableModel model;
	private JTextField inputField = new JTextField();
	private JButton submit = new JButton("Dodaj");
	private JButton remove = new JButton("Ukloni");
	
	
	public InputPanel() {
		setLayout(new BorderLayout());
		
		
		
	}
	
	public void setInputView(TableModel tableModel, String currentTableType, Boolean isAddAction) {
		switch (currentTableType) {
			case "Poslovnice":
				add(new PoslovniceInputView(tableModel, isAddAction), BorderLayout.NORTH);
			break;
			case "Zaposleni":
				add(new ZaposleniInputView(tableModel, isAddAction),BorderLayout.NORTH);
				break;
			case "Resursi":
				add(new VozilaInputView(tableModel, isAddAction),BorderLayout.NORTH);
				break;
			case "Putovanja":
				add(new PutovanjaInputMenadzer(tableModel, isAddAction),BorderLayout.NORTH);
				break;
			case "Rezervacije":
				add(new RezervacijeInputMenadzer(tableModel, false),BorderLayout.NORTH);
				break;
			case "Pregled rezervacija":
				
				break;
			case "Putovanjaa":
				
				break;
		}
	}
	
	
	
}
