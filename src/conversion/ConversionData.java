package conversion;

public class ConversionData {

	private double temperature;
	private TempScale inputScale;
	private TempScale outputScale;

	public ConversionData(double temperature, TempScale inputScale,
			TempScale outputScale) {
		this.temperature = temperature;
		this.inputScale = inputScale;
		this.outputScale = outputScale;
	}

	/**
	 * Creates a ConversionData instance with parameters as strings. If
	 * temperatureStr does not represent a valid real number or if inputScaleStr
	 * or outputScaleStr does not correspond to a temperature scale, this method
	 * returns null.
	 * @param temperatureStr - the temperature to convert. It is invalid if
	 * 		Double.parseDouble raises NumberFormatException.
	 * @param inputScaleStr - the scale from which conversion is needed. It is
	 * 		invalid if TempScale.fromString returns null.
	 * @param outputScaleStr - the scale to which conversion is needed It is
	 * 		invalid if TempScale.fromString returns null.
	 * @return a ConversionData instance or null if not all parameters are valid
	 */
	public static ConversionData createInstance(String temperatureStr,
			String inputScaleStr, String outputScaleStr) {
		double temperature = 0;
		try {
			temperature = Double.parseDouble(temperatureStr);
		}
		catch(NumberFormatException nfe) {
			return null;
		}

		TempScale inputScale = TempScale.fromString(inputScaleStr);
		TempScale outputScale = TempScale.fromString(outputScaleStr);
		if(inputScale == null || outputScale == null) {
			return null;
		}

		return new ConversionData(temperature, inputScale, outputScale);
	}

	/**
	 * Accessor of the temperature to be converted.
	 * @return
	 * 		the temperature to be converted
	 */
	public double getTemperature() {return temperature;}

	/**
	 * Accessor of the scale from which a conversion must be performed.
	 * @return
	 * 		a TempScale instance
	 */
	public TempScale getInputScale() {return inputScale;}

	/**
	 * Accessor of the scale to which a conversion must be performed.
	 * @return
	 * 		a TempScale instance
	 */
	public TempScale getOutputScale() {return outputScale;}
	
	@Override
	public String toString() {
		return "" + temperature + inputScale + " -> " + outputScale;
	}
}
