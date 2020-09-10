package conversion;

import conversion.converters.CFConverter;
import conversion.converters.CKConverter;
import conversion.converters.FCConverter;
import conversion.converters.FKConverter;
import conversion.converters.KCConverter;
import conversion.converters.KFConverter;
import conversion.converters.NonConverter;
import conversion.converters.TempConverter;

/**
 * Performs the operations involved in the conversion
 * of a temperature from a scale to another.
 * @author GRV96
 */
public class ConversionController {

	private TempConverter converter = null;
	private TempScale prevInputScale = null;
	private TempScale prevOutputScale = null;

	public ConversionController() {}

	/**
	 * Performs the temperature conversion defined by parameter cd.
	 * @param cd - a ConversionData instance
	 * @return
	 * 		the converted temperature
	 */
	public double convert(ConversionData cd) {
		return convert(cd.getTemperature(),
				cd.getInputScale(), cd.getOutputScale());
	}

	/**
	 * Converts the given temperature.
	 * @param temperature - the temperature to be converted
	 * @param inputScale - the scale from which conversion is performed
	 * @param outputScale - the scale to which conversion is performed
	 * @return
	 * 		the converted temperature
	 */
	public double convert(double temperature, TempScale inputScale,
			TempScale outputScale) {
		if(!prevScalesAreUpToDate(inputScale, outputScale) || converter == null) {
			updatePrevScales(inputScale, outputScale);
			converter = createConverter(inputScale, outputScale);
		}
		return converter.convert(temperature);
	}

	private static TempConverter createConverter(TempScale inputScale,
			TempScale outputScale) {
		TempConverter tc = null;
		switch(inputScale) {
		case DEG_CELSIUS:
			switch(outputScale) {
			case DEG_CELSIUS:
				tc = new NonConverter();
				break;
			case DEG_FAHRENHEIT:
				tc = new CFConverter();
				break;
			case KELVIN:
				tc = new CKConverter();
				break;
			}
			break;
		case DEG_FAHRENHEIT:
			switch(outputScale) {
			case DEG_CELSIUS:
				tc = new FCConverter();
				break;
			case DEG_FAHRENHEIT:
				tc = new NonConverter();
				break;
			case KELVIN:
				tc = new FKConverter();
				break;
			}
			break;
		case KELVIN:
			switch(outputScale) {
			case DEG_CELSIUS:
				tc = new KCConverter();
				break;
			case DEG_FAHRENHEIT:
				tc = new KFConverter();
				break;
			case KELVIN:
				tc = new NonConverter();
				break;
			}
		}
		return tc;
	}

	private boolean prevScalesAreUpToDate(TempScale inputScale, TempScale outputScale) {
		return inputScale.equals(prevInputScale) && outputScale.equals(prevOutputScale);
	}

	private void updatePrevScales(TempScale inputScale, TempScale outputScale) {
		prevInputScale = inputScale;
		prevOutputScale = outputScale;
	}
}
