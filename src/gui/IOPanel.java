package gui;

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
	public IOPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		ioField = new JTextField();
		ioField.setVisible(true);
		menu = new ScaleMenu();
		add(ioField);
		add(menu);
	}
}
