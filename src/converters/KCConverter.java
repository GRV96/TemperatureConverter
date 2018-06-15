package converters;

/**
 * Provides a method to convert kelvins to degrees Celsisus.
 * @author UGRV96
 *
 */
public class KCConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {

		return inputTemp - 273.15;
	}
}
