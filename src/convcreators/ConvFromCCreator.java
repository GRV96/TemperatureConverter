package convcreators;

import converters.CFConverter;
import converters.CKConverter;
import converters.NonConverter;
import converters.TemperatureConverter;

/**
 * This class can instantiate converters that
 * convert temperatures from degrees Celsius.
 * @author GRV96
 */
public class ConvFromCCreator extends ConverterCreator {

	/**
	 * Creates a converter that does not perform a conversion.
	 * @return an instance of NonConverter
	 */
	@Override
	protected TemperatureConverter createConvToCelsisus() {
		return new NonConverter();
	}

	/**
	 * Creates a converter from Celsius to Fahrenheit.
	 * @return an instance of CFConverter
	 */
	@Override
	protected TemperatureConverter createConvToFahrenheit() {
		return new CFConverter();
	}

	/**
	 * Creates a converter form Celsius to kelvins.
	 * @return an instance of CKConverter
	 */
	@Override
	protected TemperatureConverter createConvToKelvins() {
		return new CKConverter();
	}
}
