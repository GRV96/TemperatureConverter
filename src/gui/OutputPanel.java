package gui;

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
