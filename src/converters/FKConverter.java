package converters;

/**
 * Provides a method to convert degrees Fahrenheit to kelvins.
 * @author GRV96
 *
 */
public class FKConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {
		
		return (inputTemp + 459.67) * 5/9;
	}
}
