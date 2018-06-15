package language;

import java.util.HashMap;
import java.util.Map;

/**
 * The subclasses of this class contain strings to be displayed
 * in the GUI. Each subclass stores text for one language.
 * @author GRV96
 *
 */
public abstract class TextContainer {
	
	// Keys to access the strings
	public static final int TITLE_KEY = 0;
	public static final int LANGUAGE_MENU_KEY = 1;
	public static final int CONVERSION_BTN_KEY = 2;
	public static final int SWITCH_BTN_KEY = 3;
	
	// Strings to be put into the HashMap
	protected String frameTitle;
	protected String langSelectInstruction;
	protected String convBtnText;
	protected String switchBtnText;

	// Map that contains strings to be displayed in the GUI
	private Map<Integer, String> textMap;
	
	/**
	 * Constructor
	 */
	public TextContainer() {
		
		textMap = new HashMap<Integer, String>();
		defineGuiText();
		fillTextMap();
	}
	
	/**
	 * Defines the strings to be displayed for each language.
	 */
	protected abstract void defineGuiText();
	
	/**
	 * Instantiates the necessary entries for the map.
	 */
	private void fillTextMap() {
		
		textMap.put(TITLE_KEY, frameTitle);
		textMap.put(LANGUAGE_MENU_KEY, langSelectInstruction);
		textMap.put(CONVERSION_BTN_KEY, convBtnText);
		textMap.put(SWITCH_BTN_KEY, switchBtnText);
	}
	
	/**
	 * Accesses a string according to the given key.
	 * @param key
	 * 		A key to obtain the wanted text
	 * @return the string associated to the key
	 */
	public String getText(int key) {
		
		return textMap.get(key);
	}
}
