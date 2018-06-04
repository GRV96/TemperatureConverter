package converters;

/**
 * This class does not perform a conversion. The
 * convert method returns the given temperature.
 * @author GRV96
 *
 */
public class NonConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {
		
		return inputTemp;
	}

}
