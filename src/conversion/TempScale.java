package conversion;

/**
 * Represents temperature scales.
 * @author GRV96
 */
public enum TempScale {
	DEG_CELSIUS("°C"), DEG_FAHRENHEIT("°F"), KELVIN("K");
	
	private String symbol = null;
	
	private TempScale(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {return symbol;}
}
