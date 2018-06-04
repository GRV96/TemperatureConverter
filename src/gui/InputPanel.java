package gui;

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
