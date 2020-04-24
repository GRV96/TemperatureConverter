package convcreators;

import converters.TemperatureConverter;

/**
 * This class is used to instantiate temperature converters.
 * @author GRV96
 */
public abstract class ConverterCreator {

	/**
	 * Instantiates a class implementing TemperatureConverter.
	 * @param inputScale
	 * 		The scale from which a conversion must be performed
	 * @param outputScale
	 * 		The scale to which a conversion must be performed
	 * @return the created instance
	 */
	public static TemperatureConverter create(TemperatureScale inputScale,
			TemperatureScale outputScale) {
		TemperatureConverter converter = null;
		ConverterCreator creator = null;

		switch(inputScale) {
		case DEG_CELSIUS:
			creator = new ConvFromCCreator();
			break;
		case DEG_FAHRENHEIT:
			creator = new ConvFromFCreator();
			break;
		case KELVIN:
			creator = new ConvFromKCreator();
			break;
		}

		converter = creator.createConverter(outputScale);

		return converter;
	}

	/**
	 * Instantiates a temperature converter
	 * according to the specified output scale.
	 * @param outputScale
	 * 		the scale to which conversion will be performed
	 * @return a temperature converter
	 */
	private TemperatureConverter createConverter(TemperatureScale outputScale) {
		TemperatureConverter converter = null;

		switch(outputScale) {
		case DEG_CELSIUS:
			converter = createConvToCelsisus();
			break;
		case DEG_FAHRENHEIT:
			converter = createConvToFahrenheit();
			break;
		case KELVIN:
			converter = createConvToKelvins();
			break;
		}

		return converter;
	}

	protected abstract TemperatureConverter createConvToCelsisus();

	protected abstract TemperatureConverter createConvToFahrenheit();

	protected abstract TemperatureConverter createConvToKelvins();
}
