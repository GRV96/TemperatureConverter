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
	private ScaleMenu scaleMenu;

	/**
	 * Constructor
	 * @param width
	 * @param height
	 */
	public IOPanel(int width, int height) {
		
		int scaleMenuWidth = 50;
		
		setLayout(new FlowLayout());
		setSize(width, height);
		ioField = new JTextField();
		ioField.setPreferredSize(new Dimension(width-scaleMenuWidth-40, height));
		scaleMenu = new ScaleMenu();
		scaleMenu.setPreferredSize(new Dimension(scaleMenuWidth, height));
		add(ioField);
		add(scaleMenu);
	}
	
	/**
	 * Gets the scale chosen by the user.
	 * @return a string that represents the scale
	 */
	public String getScale() {
		
		return (String) scaleMenu.getSelectedItem();
	}
}
