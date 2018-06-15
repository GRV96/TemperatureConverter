package converters;

/**
 * Provides a method to convert kelvins to degrees Celsius.
 * @author GRV96
 *
 */
public class KCConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {

		return inputTemp - 273.15;
	}
}
