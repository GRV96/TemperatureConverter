package converters;

/**
 * Provides a method to convert degrees Fahrenheit to degrees Celsius.
 * @author GRV96
 *
 */
public class FCConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {
		
		return (inputTemp - 32) * 5 / 9;
	}

}
