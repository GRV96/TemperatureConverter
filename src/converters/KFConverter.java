package converters;

public class KFConverter implements TemperatureConverter {

	@Override
	public double convert(double inputTemp) {
		
		return (inputTemp - 273.15) * 9/5 + 32;
	}

}
