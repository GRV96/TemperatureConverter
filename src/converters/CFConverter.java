package converters;

/**
 * Converts degrees Celsius to degrees Farenheit.
 * @author GRV96
 *
 */
public class CFConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {
		
		return 9 * inputTemp / 5 + 32;
	}
}
