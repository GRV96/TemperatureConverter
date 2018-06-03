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
	 * @param temp
	 * 		The temperature to display
	 */
	public void displayTemp(double temp) {
		
		ioField.setText("" + temp);
	}
}
