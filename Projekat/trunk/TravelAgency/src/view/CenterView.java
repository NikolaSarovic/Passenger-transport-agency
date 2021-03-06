package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.Observer;

public class CenterView extends JPanel implements Observer {
	
	DataView dataView = null;
	InputPanel inputView = null;
	
	public CenterView(ApplicationView appView) {
		setBackground(Color.decode("#98B4D4"));
		Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#d8edf0"));
		setBorder(border);
		
		setLayout(new BorderLayout());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image;
		try {
			image = ImageIO.read(new File("./img/travel-wallpaper2.png"));
			Image newImage = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
			g.drawImage(newImage, 0, 0, this); // see javadoc for more info on the parameters

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public DataView getDataView() {
		return dataView;
	}

	public void setDataView(ApplicationView appView) {
		this.removeAll();
		if(dataView == null)
		{
			dataView = new DataView(appView);
		}
		add(new JScrollPane(dataView), BorderLayout.CENTER);
	}
	
	public void setDataAndInputView()
	{
		this.removeAll();
		add(new JScrollPane(dataView), BorderLayout.NORTH);
		add(new JScrollPane(inputView), BorderLayout.CENTER);
	}

	public InputPanel getInputView() {
		return inputView;
	}

	public void setInputView(InputPanel inputView) {
		this.inputView = inputView;
	}

	@Override
	public void update() {
		AbstractTableModel dm=(AbstractTableModel)this.dataView.getTableModel();
		dm.fireTableDataChanged();
		dataView.updateUI();
		dataView.repaint();
	}
}
