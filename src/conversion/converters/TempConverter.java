package conversion.converters;

/**
 * To be implemented by classes meant to convert
 * a temperature from a scale to another.
 * @author GRV96
 */
public interface TempConverter {

	/**
	 * Converts the temperature to another scale. The output
	 * scale is determined by the class implementing the method.
	 * @param temperature
	 * 		The temperature to be converted
	 * @return the converted temperature
	 */
	public double convert(double temperature);
}
