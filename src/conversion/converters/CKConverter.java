package conversion.converters;

/**
 * Provides a method to convert degrees Celsius to kelvins.
 * @author GRV96
 */
public class CKConverter implements TempConverter {

	@Override
	public double convert(double temperature) {
		return temperature + 273.15;
	}
}
