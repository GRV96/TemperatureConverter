package gui;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import language.EnglishTextContainer;
import language.FrenchTextContainer;
import language.LanguageObservable;
import language.LanguageObserver;
import language.SpanishTextContainer;
import language.TextContainer;

/**
 * This panel enables the user to change the language of the application.
 * @author GRV96
 *
 */
public class LanguagePanel extends JPanel implements LanguageObservable {
	
	// Components displayed on the panel
	private JLabel instruction;
	private LanguageMenu languageMenu;
	
	// Objects involved in the lanugage selection
	private ArrayList<LanguageObserver> languageObservers;
	private TextContainer tc;

	/**
	 * Constructor
	 * @param width
	 * @param height
	 */
	public LanguagePanel(int width, int height) {
		
		setLayout(new FlowLayout());
		setSize(width, height);
		instruction = new JLabel();
		languageMenu = new LanguageMenu();
		languageMenu.addItemListener(new LanguageItemListener());
		add(instruction);
		add(languageMenu);
		languageObservers = new ArrayList<LanguageObserver>();
	}

	/**
	 * Accesses the selected language
	 * @return a String representing the language selected by the user
	 */
	public String getLanguage() {
		
		return (String) languageMenu.getSelectedItem();
	}
	
	/**
	 * Detects the chosen language and applies the selection.
	 */
	public void setLanguage() {
		
		String language = getLanguage();
		
		switch(language) {
		case LanguageMenu.FRENCH:
			tc = new FrenchTextContainer();
			break;
		case LanguageMenu.ENGLISH:
			tc = new EnglishTextContainer();
			break;
		case LanguageMenu.SPANISH:
			tc = new SpanishTextContainer();
			break;
		default:
			// Not useful if the logic is correct.
		}
		
		instruction.setText(tc.getText(TextContainer.LANGUAGE_MENU_KEY));
		notifyLanguageObservers();
	}

	@Override
	public void addLanguageObserver(LanguageObserver lo) {
		
		// lo is added if it does not exist yet in the collection.
		if(!languageObservers.contains(lo)) {
			
			languageObservers.add(lo);
		}
	}

	@Override
	public void notifyLanguageObservers() {
		
		Iterator<LanguageObserver> langObsIterator = languageObservers.iterator();
		
		while(langObsIterator.hasNext()) {
			
			langObsIterator.next().updateLanguage(tc);
		}
	}
	
	/**
	 * This class changes the language of the user interface upon selction.
	 * @author GRV69
	 *
	 */
	private class LanguageItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			setLanguage();
		}
	}
}
