package conversion.converters;

/**
 * Provides a method to convert kelvins to degrees Fahrenheit.
 * @author GRV96
 */
public class KFConverter implements TempConverter {

	@Override
	public double convert(double temperature) {

		return temperature * 9/5 - 459.67;
	}
}
