package converters;

public class FCConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {
		
		return (inputTemp - 32) * 5 / 9;
	}

}
