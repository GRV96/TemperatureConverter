import java.util.Observable;
import java.util.Observer;

import conversion.ConversionController;
import conversion.TempScale;
import gui.ConvFrame;
import language.Language;
import language.LanguageUpdater;

public final class ConvApp implements Observer {

	private ConversionController convController = new ConversionController();
	private ConvFrame convFrame = new ConvFrame();

	public ConvApp() {
		LanguageUpdater.getInstance().addObserver(this);
		convFrame.addObserver(this);
	}

	private void convert() {
		try {
			TempScale fromScale = convFrame.getInputScale();
			TempScale toScale = convFrame.getOutputScale();
			double inputTemp = convFrame.getInputTemperature();
			double outputTemp = convController.convert(inputTemp, fromScale, toScale);
			convFrame.displayTemperature(outputTemp);
		}
		catch(NumberFormatException nfe) {
			// Do nothing. Conversion is impossible.
		}
	}

	public static void main(String[] args) {
		new ConvApp();
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageUpdater) {
			LanguageUpdater langUpdater = (LanguageUpdater) o;
			Language selectedLang = langUpdater.getLanguage();
			convFrame.setLanguage(selectedLang);
		}
		else if(o == convFrame) {
			convert();
		}
	}
}
