package conversion;

import java.util.HashSet;
import java.util.Set;

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

	private class ConversionMaterial {

		public final TempScale fromScale;
		public final TempScale toScale;
		public final TempConverter converter;

		public ConversionMaterial(TempScale fromScale, TempScale toScale) {
			this.fromScale = fromScale;
			this.toScale = toScale;
			this.converter = createConverter(fromScale, toScale);
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof ConversionMaterial)) {
				return false;
			}
			ConversionMaterial other = (ConversionMaterial) obj;
			return other.matches(fromScale, toScale);
		}

		public boolean matches(TempScale fromScale, TempScale toScale) {
			return this.fromScale.equals(fromScale)
					&& this.toScale.equals(toScale);
		}
	} // class ConversionMaterial

	private Set<ConversionMaterial> cmSet = null;

	public ConversionController() {
		cmSet = new HashSet<ConversionMaterial>();
	}

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
		TempConverter tc = getConverter(fromScale, toScale);
		return tc.convert(temperature);
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

	private TempConverter getConverter(TempScale fromScale, TempScale toScale) {
		for(ConversionMaterial cm: cmSet) {
			if(cm.matches(fromScale, toScale)) {
				return cm.converter;
			}
		}

		ConversionMaterial cm = new ConversionMaterial(fromScale, toScale);
		cmSet.add(cm);
		return cm.converter;
	}
}
