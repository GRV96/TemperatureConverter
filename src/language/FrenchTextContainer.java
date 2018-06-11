package language;

/**
 * This class contains strings for the GUI in French.
 * @author GRV96
 *
 */
public class FrenchTextContainer extends TextContainer {
	
	/**
	 * Constructor
	 */
	public FrenchTextContainer() {
		
		super();
	}

	@Override
	protected void defineGuiText() {
		
		frameTitle = "Convertisseur de température";
		langSelectInstruction = "Choisissez une langue.";
		convBtnText = "Convertir";
	}
}
