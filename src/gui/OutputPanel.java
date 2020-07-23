package gui;

import conversion.TempScale;

/**
 * This panel enables the user to chose the
 * scale to which the conversion will be
 * performed and displays the converted temperature.
 * @author GRV96
 */
public class OutputPanel extends IOPanel {

	private static final long serialVersionUID = -4221527112592370948L;

	/**
	 * Constructor
	 */
	public OutputPanel() {
		super();
		ioField.setEditable(false);
		scaleSelector.setSelectedItem(TempScale.DEG_FAHRENHEIT);
	}

	/**
	 * Sets the temperature to display in the output field.
	 * @param temperature
	 * 		The temperature to display
	 */
	public void displayTemperature(double temperature) {
		ioField.setText("" + temperature);
	}
}
