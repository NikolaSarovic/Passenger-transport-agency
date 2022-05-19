package view.style;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRenderer extends DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		Component component= super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		
		if(component instanceof JLabel)
		{
			JLabel label=(JLabel)component;
			Font font = label.getFont();
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			
			if(row%2!=0)
				label.setBackground(Color.LIGHT_GRAY);
			else
				label.setBackground(Color.WHITE);
			

			if(isSelected)
			{
				label.setForeground(Color.BLACK);
				label.setBackground(hex2Rgb("#3399FF"));
				label.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
			}
			if(column==0)
				label.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
			
			
			
			
			
		}
		
		return component;
		
		
	
	}
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}

}
