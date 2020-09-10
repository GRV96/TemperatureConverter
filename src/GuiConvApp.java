import java.util.Observable;
import java.util.Observer;

import conversion.ConversionController;
import conversion.ConversionData;
import conversion.TempScale;
import gui.ConvFrame;
import language.Language;
import language.LanguageUpdater;

public class GuiConvApp implements Observer {

	private ConversionController convController = new ConversionController();
	private ConvFrame convFrame = new ConvFrame();

	public GuiConvApp() {
		LanguageUpdater.getInstance().addObserver(this);
		convFrame.addObserver(this);
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

	private ConversionData getConvDataFromUI() throws NumberFormatException {
		double inputTemp = convFrame.getInputTemperature(); // Can throw the exception.
		TempScale inputScale = convFrame.getInputScale();
		TempScale fromScale = convFrame.getOutputScale();
		return new ConversionData(inputTemp, inputScale, fromScale);
	}

	public static void main(String[] args) {
		new GuiConvApp();
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
