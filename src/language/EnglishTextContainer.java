package language;

/**
 * This class contains strings for the GUI in English.
 * @author GRV96
 *
 */
public class EnglishTextContainer extends TextContainer {
	
	/**
	 * Constructor
	 */
	public EnglishTextContainer() {
		
		super();
	}

	@Override
	protected void defineGuiText() {
		
		frameTitle = "Temperature Converter";
		langSelectInstruction = "Choose a language.";
		convBtnText = "Convert";
	}
}
