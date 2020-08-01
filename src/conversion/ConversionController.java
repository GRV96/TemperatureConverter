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
	private TempScale prevFromScale = null;
	private TempScale prevToScale = null;

	public ConversionController() {}

	/**
	 * Converts the given temperature.
	 * @param temperature
	 * 		The temperature to be converted
	 * @param fromScale
	 * 		The scale from which conversion is performed
	 * @param toScale
	 * 		The scale to which conversion is performed
	 * @return
	 * 		The converted temperature
	 */
	public double convert(double temperature, TempScale fromScale,
			TempScale toScale) {
		if(!prevScalesAreUpToDate(fromScale, toScale) || converter == null) {
			updatePrevScales(fromScale, toScale);
			converter = createConverter(fromScale, toScale);
		}
		return converter.convert(temperature);
	}

	private static TempConverter createConverter(TempScale fromScale,
			TempScale toScale) {
		TempConverter tc = null;
		switch(fromScale) {
		case DEG_CELSIUS:
			switch(toScale) {
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
			switch(toScale) {
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
			switch(toScale) {
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

	private boolean prevScalesAreUpToDate(TempScale fromScale, TempScale toScale) {
		return fromScale.equals(prevFromScale) && toScale.equals(prevToScale);
	}

	private void updatePrevScales(TempScale fromScale, TempScale toScale) {
		prevFromScale = fromScale;
		prevToScale = toScale;
	}
}
