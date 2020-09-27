package conversion;

/**
 * This enumeration represents temperature scales.
 * @author GRV96
 */
public enum TempScale {
	DEG_CELSIUS("°C"), DEG_FAHRENHEIT("°F"), KELVIN("K");

	private static final String DEG_C_SYMBOL = TempScale.DEG_CELSIUS.toString();
	private static final String DEG_F_SYMBOL = TempScale.DEG_FAHRENHEIT.toString();
	private static final String KELVIN_SYMBOL = TempScale.KELVIN.toString();

	private String symbol = null;

	private TempScale(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Provides a TempScale value corresponding to the given character.
	 * <p>c/C: DEG_CELSIUS
	 * <p>f/F: DEG_FAHRENHEIT
	 * <p>k/K: KELVIN
	 * @param c - a character corresponding to a temperature scale
	 * @return a TempScale value or null if no value corresponds to c
	 */
	public static TempScale fromChar(char c) {
		switch(c) {
		case 'c':
		case 'C':
			return DEG_CELSIUS;
		case 'f':
		case 'F':
			return DEG_FAHRENHEIT;
		case 'k':
		case 'K':
			return KELVIN;
		default:
			return null;
		}
	}

	/**
	 * Provides a TempScale value corresponding to the given string. If the
	 * string is none of the ones below, the returned value is determined by
	 * method fromChar according to the string's first character.
	 * <p>"°C": DEG_CELSIUS
	 * <p>"°F": DEG_FAHRENHEIT
	 * <p>"K": KELVIN
	 * @param s - a string corresponding to a temperature scale
	 * @return a TempScale value or null if no value corresponds to s
	 */
	public static TempScale fromString(String s) {
		if(s.equals(DEG_C_SYMBOL)) {
			return DEG_CELSIUS;
		}
		else if(s.equals(DEG_F_SYMBOL)) {
			return DEG_FAHRENHEIT;
		}
		else if(s.equals(KELVIN_SYMBOL)) {
			return KELVIN;
		}
		else if(s.length() > 0) {
			return fromChar(s.charAt(0));
		}
		return null;
	}

	@Override
	public String toString() {return symbol;}
}
