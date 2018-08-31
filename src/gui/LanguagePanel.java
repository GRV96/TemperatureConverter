package gui;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import language.LanguageManager;
import language.TextContainer;

/**
 * This panel enables the user to change the language of the application.
 * @author GRV96
 *
 */
public class LanguagePanel extends JPanel {
	
	/**
	 * A JLabel informing the user they can change the language
	 */
	private JLabel instruction;
	
	/**
	 * A JComboBox that enables the user to change the language
	 */
	private LanguageMenu languageMenu;
	
	/**
	 * The object that handles the language setting.
	 */
	private LanguageManager langManager;

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
		langManager = LanguageManager.getInstance();
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
	public void updateLanguage() {
		
		String language = getLanguage();
		
		switch(language) {
		case LanguageMenu.FRENCH:
			langManager.setLanguage(LanguageManager.Language.FRANCAIS);
			break;
		case LanguageMenu.ENGLISH:
			langManager.setLanguage(LanguageManager.Language.ENGLISH);
			break;
		case LanguageMenu.SPANISH:
			langManager.setLanguage(LanguageManager.Language.ESPANOL);
			break;
		default:
			// Not useful if the logic is correct.
		}
		
		instruction.setText(langManager.getTextContainer().getText(TextContainer.LANGUAGE_MENU_KEY));
	}
	
	/**
	 * This class changes the language of the user interface upon selction.
	 * @author GRV69
	 *
	 */
	private class LanguageItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			updateLanguage();
		}
	}
}
