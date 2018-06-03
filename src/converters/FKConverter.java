package converters;

public class FKConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {
		
		return (inputTemp - 32) * 5/9 +273.15;
	}
}
