package converters;

/**
 * To be implemented by classes used for temperature conversion.
 * @author GRV96
 *
 */
public interface TemperatureConverter {

	/**
	 * Converts the temperature to another scale. The output
	 * scale is determined by the class implementing the method.
	 * @param inputTemp
	 * 		The temperature to be converted
	 * @return the converted temperature
	 */
	public double convert(double inputTemp);
}
