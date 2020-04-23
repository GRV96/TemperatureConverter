package gui;

/**
 * This panel enables the user to enter the
 * temperature to be converted and to chose the
 * scale from which the conversion will be performed.
 * @author GRV96
 */
public class InputPanel extends IOPanel {

	private static final long serialVersionUID = -6080963751590679553L;

	/**
	 * Constructor
	 */
	public InputPanel() {
		super();
		ioField.setEditable(true);
	}
	
	/**
	 * Accesses the input temperature.
	 * @return the input temperature
	 */
	public double getInputTemperature() {
		return Double.parseDouble(ioField.getText());
	}
}
