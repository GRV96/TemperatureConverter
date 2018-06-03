package converters;

public class KCConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {

		return inputTemp - 273.15;
	}
}
