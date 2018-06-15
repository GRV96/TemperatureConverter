package language;

/**
 * This interface is implemented by classes
 * that must be observed by a LanguageObserver.
 * @author GRV96
 *
 */
public interface LanguageObservable {

	/**
	 * Adds a language observer to the object upon which the method is called.
	 * @param lo
	 * 		An instance of a class implementing LanugageObserver
	 */
	public void addLanguageObserver(LanguageObserver lo);
	
	/**
	 * Updates the language of all the known language observers.
	 */
	public void notifyLanguageObservers();
}
