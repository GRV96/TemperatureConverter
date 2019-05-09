package gui;

import javax.swing.JComboBox;

/**
 * A menu to change the language of the application.
 * @author GRV96
 *
 */
public class LanguageMenu extends JComboBox<String> {
	
	private static final long serialVersionUID = -2515408722232669443L;
	
	public static final String FRENCH = "Fran�ais";
	public static final String ENGLISH = "English";
	public static final String SPANISH = "Espa�ol";
	private static final String[] LANGUAGES = {FRENCH, ENGLISH, SPANISH};
	
	/**
	 * Constructor
	 */
	public LanguageMenu() {
		
		super(LANGUAGES);
		setVisible(true);
	}
}
