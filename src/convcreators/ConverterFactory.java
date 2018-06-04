package convcreators;

import converters.TemperatureConverter;
import gui.ScaleMenu;

/**
 * A class that instantiates subclasses of ConverterCreator.
 * @author GRV96
 *
 */
public class ConverterFactory {

	/**
	 * Instantiates a class implementing TemperatureConverter.
	 * @param inputScale
	 * 		The scale from which a conversion must be performed
	 * @param outputScale
	 * 		The scale to which a conversion must be performed
	 * @return the created instance
	 */
	public static TemperatureConverter
			createConverter(String inputScale, String outputScale) {
		
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
}
