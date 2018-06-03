package converters;

/**
 * Converts degrees Celsius to kelvins.
 * @author GRV96
 *
 */
public class CKConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {

		return inputTemp + 273.15;
	}
}
