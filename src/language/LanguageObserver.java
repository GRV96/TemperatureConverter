package language;

/**
 * This interface provides a method to update de language in GUI components.
 * @author GRV96
 *
 */
public interface LanguageObserver {

	/**
	 * The object on which the method is called
	 * changes its language with the provided data.
	 * @param tc
	 * 		This objects contains the new strings to be displayed.
	 */
	public void updateLanguage(TextContainer tc);
}
