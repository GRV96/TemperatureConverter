package gui;

/**
 * This panel enables the user to chose the
 * scale to which the conversion will be
 * performed and displays the converted temperature.
 * @author GRV96
 *
 */
public class OutputPanel extends IOPanel
{
	/**
	 * Constructor
	 */
	public OutputPanel(int width, int height)
	{
		super(width, height);
		ioField.setEditable(false);
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
