package language;

import java.util.Observable;

/**
 * This class is a singleton for easier access to the instance.
 * It handles the language setting. A TextContainer object can
 * be obtained from it in order to access the character
 * strings to be displayed in a given language.
 * @author GRV96
 *
 */
public class LanguageManager extends Observable {
	
	/**
	 * The languages available in the application.
	 * @author GRV96
	 *
	 */
	public enum Language {FRENCH, ENGLISH, SPANISH;}

	/**
	 * The only instance of this class
	 */
	private static LanguageManager instance;
	
	/**
	 * An object that holds text to be displayed in the interface
	 */
	private TextContainer tc;
	
	/**
	 * Constructor
	 */
	private LanguageManager() {
		super();
		tc = null;
	}
	
	/**
	 * Accesses this class' only instance. It is a singleton.
	 * @return the only instance
	 */
	public static LanguageManager getInstance() {
		
		if(instance == null) {
			instance = new LanguageManager();
		}
		
		return instance;
	}
	
	/**
	 * Accesses the object that contains the strings to be displayed.
	 * @return the text container
	 */
	public TextContainer getTextContainer() {return tc;}
	
	/**
	 * Changes the application's language.
	 * @param language
	 * 		A value of the LanguageManager.Language public enumeration
	 */
	public void setLanguage(Language language) {
		
		switch(language) {
		case FRENCH:
			tc = new FrenchTextContainer();
			break;
		case ENGLISH:
			tc = new EnglishTextContainer();
			break;
		case SPANISH:
			tc = new SpanishTextContainer();
			break;
		}
		
		setChanged();
		notifyObservers();
	}
}
