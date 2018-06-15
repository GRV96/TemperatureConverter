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
	 * Instantiates a temperature converter according to the specified output scale.
	 * @param outputScale
	 * 		the scale to which conversion will be performed
	 * @return a temperature converter
	 */
	public final TemperatureConverter createConverter(String outputScale) {
		
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
