package convcreators;

public enum TemperatureScale {
	DEG_CELSIUS("°C"), DEG_FAHRENHEIT("°F"), KELVIN("K");
	
	private String symbol = null;
	
	private TemperatureScale(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {return symbol;}
}
