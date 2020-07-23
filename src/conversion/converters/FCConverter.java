package conversion.converters;

/**
 * Provides a method to convert degrees Fahrenheit to degrees Celsius.
 * @author GRV96
 */
public class FCConverter implements TempConverter {

	@Override
	public double convert(double temperature) {
		return (temperature - 32) * 5 / 9;
	}

}
