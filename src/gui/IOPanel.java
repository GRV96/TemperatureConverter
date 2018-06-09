package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Displays components allowing the user to enter the temperature to convert.
 * @author GRV96
 *
 */
public abstract class IOPanel extends JPanel {
	
	protected JTextField ioField;
	private ScaleMenu menu;

	/**
	 * Constructor
	 * @param width
	 * @param height
	 */
	public IOPanel(int width, int height) {
		
		int scaleMenuWidth = 50;
		
		setLayout(new FlowLayout());
		//setBackground(Color.BLUE);
		setSize(width, height);
		ioField = new JTextField();
		ioField.setPreferredSize(new Dimension(width-scaleMenuWidth-40, height));
		menu = new ScaleMenu();
		menu.setPreferredSize(new Dimension(scaleMenuWidth, height));
		add(ioField);
		add(menu);
	}
	
	/**
	 * Gets the scale chosen by the user.
	 * @return a string that represents the scale
	 */
	public String getScale() {
		
		return (String) menu.getSelectedItem();
	}
}
