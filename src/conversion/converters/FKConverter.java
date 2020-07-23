package conversion.converters;

/**
 * Provides a method to convert degrees Fahrenheit to kelvins.
 * @author GRV96
 */
public class FKConverter implements TempConverter {

	@Override
	public double convert(double temperature) {
		return (temperature + 459.67) * 5/9;
	}
}
