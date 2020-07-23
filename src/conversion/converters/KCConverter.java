package conversion.converters;

/**
 * Provides a method to convert kelvins to degrees Celsius.
 * @author GRV96
 */
public class KCConverter implements TempConverter {

	@Override
	public double convert(double temperature) {

		return temperature - 273.15;
	}
}
