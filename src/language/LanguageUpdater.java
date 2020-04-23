package language;

import java.util.Observable;

/**
 * This singleton notifies its observers when the application's
 * language changes. They then have the responsibility to
 * update any text that they display in the user interface.
 * @author GRV96
 */
public class LanguageUpdater extends Observable {

	private Language selectedLang = null;
	private static LanguageUpdater instance = null;

	/**
	 * Constructor
	 */
	private LanguageUpdater() {
		super();
	}

	/**
	 * Accesses this class' only instance. It is a singleton.
	 * @return the only instance
	 */
	public static LanguageUpdater getInstance() {
		if(instance == null) {
			instance = new LanguageUpdater();
		}
		return instance;
	}

	/**
	 * Returns the language selected for the application.
	 * @return an instance of the Language enumeration
	 */
	public Language getLanguage() {return selectedLang;}

	/**
	 * Changes the application's language and notifies this instance's observers.
	 * @param language A value of the Language enumeration
	 */
	public void setLanguage(Language language) {
		selectedLang = language;
		setChanged();
		notifyObservers();
	}
}
