import java.util.Observable;
import java.util.Observer;

import conversion.ConversionController;
import conversion.ConversionData;
import conversion.TempScale;
import gui.ConvGui;
import language.Language;
import language.LanguageUpdater;

public class GuiConvApp implements Observer {

	private ConversionController convController = new ConversionController();
	private ConvGui convGui = new ConvGui();

	private GuiConvApp() {
		LanguageUpdater.getInstance().addObserver(this);
		convGui.addObserver(this);
	}

	private void convertInUi() {
		ConversionData convData = getConvDataFromUi();
		if(convData != null) {
			double outputTemp = convController.convert(convData);
			convGui.displayTemperature(outputTemp);
		}
	}

	private ConversionData getConvDataFromUi() {
		try {
			double inputTemp = convGui.getInputTemperature(); // Can throw the exception.
			TempScale inputScale = convGui.getInputScale();
			TempScale fromScale = convGui.getOutputScale();
			return new ConversionData(inputTemp, inputScale, fromScale);
		}
		catch(NumberFormatException nfe) {
			return null;
		}
	}

	public static void main(String[] args) {
		new GuiConvApp();
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageUpdater) {
			LanguageUpdater langUpdater = (LanguageUpdater) o;
			Language selectedLang = langUpdater.getLanguage();
			convGui.setLanguage(selectedLang);
		}
		else if(o == convGui) {
			convertInUi();
		}
	}
}
