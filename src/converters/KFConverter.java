package converters;

/**
 * Provides a method to convert kelvins to degrees Fahrenheit.
 * @author GRV96
 *
 */
public class KFConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {
		
		return inputTemp * 9/5 - 459.67;
	}

}
