package convcreators;

import converters.TemperatureConverter;
import gui.ScaleMenu;

/**
 * This class is used to instantiate temperature converters.
 * @author GRV96
 *
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
	public static TemperatureConverter create(String inputScale, String outputScale) {
		
		TemperatureConverter converter = null;
		ConverterCreator creator = null;
		
		if(inputScale.equals(ScaleMenu.DEG_C)) {
			
			creator = new ConvFromCCreator();
		}
		else if(inputScale.equals(ScaleMenu.DEG_F)) {
			
			creator = new ConvFromFCreator();
		}
		else if(inputScale.equals(ScaleMenu.KELVIN)) {
			
			creator = new ConvFromKCreator();
		}
		
		converter = creator.createConverter(outputScale);
		
		return converter;
	}

	/**
	 * Instantiates a temperature converter according to the specified output scale.
	 * @param outputScale
	 * 		the scale to which conversion will be performed
	 * @return a temperature converter
	 */
	private TemperatureConverter createConverter(String outputScale) {
		
		TemperatureConverter converter = null;
		
		if(outputScale.equals(ScaleMenu.DEG_C)) {
			
			converter = createConvToCelsisus();
		}
		else if(outputScale.equals(ScaleMenu.DEG_F)) {
			
			converter = createConvToFahrenheit();
		}
		else if(outputScale.equals(ScaleMenu.KELVIN)) {
			
			converter = createConvToKelvins();
		}
		
		return converter;
	}
	
	protected abstract TemperatureConverter createConvToCelsisus();
	
	protected abstract TemperatureConverter createConvToFahrenheit();
	
	protected abstract TemperatureConverter createConvToKelvins();
}
