import java.util.Observable;
import java.util.Observer;

import conversion.ConversionController;
import conversion.ConversionData;
import conversion.TempScale;
import gui.ConvFrame;
import language.Language;
import language.LanguageUpdater;

public final class ConvApp implements Observer {

	private ConversionController convController = new ConversionController();
	private ConvFrame convFrame = null;

	public ConvApp(boolean createGui) {
		if(createGui) {
			LanguageUpdater.getInstance().addObserver(this);
			convFrame = new ConvFrame();
			convFrame.addObserver(this);
		}
	}

	private void convertInUI() {
		try {
			ConversionData convData = getConvDataFromUI();
			double outputTemp = convController.convert(convData);
			convFrame.displayTemperature(outputTemp);
		}
		catch(NumberFormatException nfe) {
			// Do nothing. Conversion is impossible.
		}
	}

	private static ConversionData getConvDataFromCmdLine(String[] args) {
		if(args.length < 3) {
			return null;
		}
		// Returns null if args are invalid.
		return ConversionData.createInstance(args[0], args[1], args[2]);
	}

	private ConversionData getConvDataFromUI() throws NumberFormatException {
		double inputTemp = convFrame.getInputTemperature(); // Can throw the exception.
		TempScale inputScale = convFrame.getInputScale();
		TempScale fromScale = convFrame.getOutputScale();
		return new ConversionData(inputTemp, inputScale, fromScale);
	}

	public static void main(String[] args) {
		ConversionData convData = getConvDataFromCmdLine(args);
		ConvApp ca = null;
		if(convData == null) { // Args are invalid.
			ca = new ConvApp(true);
		}
		else {
			ca = new ConvApp(false);
			double outputTemp = ca.convController.convert(convData);
			System.out.println(outputTemp);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageUpdater) {
			LanguageUpdater langUpdater = (LanguageUpdater) o;
			Language selectedLang = langUpdater.getLanguage();
			convFrame.setLanguage(selectedLang);
		}
		else if(o == convFrame) {
			try {
				convertInUI();
			}
			catch(NumberFormatException nfe) {
				// Do nothing. Conversion is impossible.
			}
		}
	}
}
