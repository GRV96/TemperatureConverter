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
	private static final long serialVersionUID = -4221527112592370948L;

	/**
	 * Constructor
	 */
	public OutputPanel()
	{
		super();
		ioField.setEditable(false);
		scaleMenu.setSelectedItem(ScaleMenu.DEG_F);
	}
	
	/**
	 * Sets the temperature to display in the output field.
	 * @param temperature
	 * 		The temperature to display
	 */
	public void displayTemperature(double temperature)
	{
		ioField.setText("" + temperature);
	}
}
