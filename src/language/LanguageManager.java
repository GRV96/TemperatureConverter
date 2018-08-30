package language;

import java.util.Observable;

/**
 * This class is a singleton for easier access to the instance.
 * It handles the language setting.
 * @author GRV96
 *
 */
public class LanguageManager extends Observable {
	
	/**
	 * The languages available in the application.
	 * @author GRV96
	 *
	 */
	public enum Language {FRANCAIS, ENGLISH, ESPANOL;}

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
	public TextContainer getTexts() {return tc;}
	
	/**
	 * Changes the application's language.
	 * @param language
	 * 		A value of the LanguageManager.Language public enumeration
	 */
	public void setLanguage(Language language) {
		
		switch(language) {
		case FRANCAIS:
			tc = new FrenchTextContainer();
			break;
		case ENGLISH:
			tc = new EnglishTextContainer();
			break;
		case ESPANOL:
			tc = new EnglishTextContainer();
			break;
		}
		
		notifyObservers();
	}
}
