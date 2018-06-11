package language;

/**
 * This class contains strings for the GUI in Spanish.
 * @author GRV96
 *
 */
public class SpanishTextContainer extends TextContainer {
	
	/**
	 * Constructor
	 */
	public SpanishTextContainer() {
		
		super();
	}

	@Override
	protected void defineGuiText() {
		
		frameTitle = "Convertidor de temperatura";
		langSelectInstruction = "Escoja un idioma.";
		convBtnText = "Convertir";
	}
}
