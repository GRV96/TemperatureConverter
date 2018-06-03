package gui;

import java.awt.Dimension;
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
	 */
	public IOPanel(int width, int height) {
		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setMaximumSize(new Dimension(width, height));
		ioField = new JTextField();
		menu = new ScaleMenu();
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
