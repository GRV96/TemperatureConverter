package gui;

import javax.swing.JComboBox;

/**
 * Displays the temperature scales between which conversion is possible.
 * @author GRV96
 */
public class ScaleMenu extends JComboBox<String> {

	private static final long serialVersionUID = -8651974994424339137L;
	
	public static final String DEG_C = "°C";
	public static final String DEG_F = "°F";
	public static final String KELVIN = "K";
	private static final String[] SCALES = {DEG_C, DEG_F, KELVIN};
	
	/**
	 * Constructor
	 */
	public ScaleMenu() {
		
		super(SCALES);
		setVisible(true);
	}
}
