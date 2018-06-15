package gui;

/**
 * This panel enables the user to enter the
 * temperature to be converted and to chose the
 * scale from which the conversion will be performed.
 * @author GRV96
 *
 */
public class InputPanel extends IOPanel {

	/**
	 * Constructor
	 */
	public InputPanel(int width, int height)
	{
		super(width, height);
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
