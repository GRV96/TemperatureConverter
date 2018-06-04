package convcreators;

import converters.KCConverter;
import converters.KFConverter;
import converters.NonConverter;
import converters.TemperatureConverter;

/**
 * This class can instantiate converters that
 * convert temperatures from kelvins.
 * @author GRV96
 *
 */
public class ConvFromKCreator extends ConverterCreator {

	/**
	 * Creates a converter from kelvins to Celsius.
	 * @return an instance of KCConverter
	 */
	@Override
	protected TemperatureConverter createConvToCelsisus() {
		
		return new KCConverter();
	}
	
	/**
	 * Creates a converter from kelvins to Farenheit.
	 * @return an instance of KFConverter
	 */
	@Override
	protected TemperatureConverter createConvToFarenheit() {
		
		return new KFConverter();
	}

	/**
	 * Creates a converter that does not perform a conversion.
	 * @return an instance of NonConverter
	 */
	@Override
	protected TemperatureConverter createConvToKelvins() {
		
		return new NonConverter();
	}
}
