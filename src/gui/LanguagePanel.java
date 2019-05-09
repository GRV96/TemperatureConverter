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
	
	private static final long serialVersionUID = -4605260424700093571L;

	/**
	 * A JLabel informing the user they can change the language
	 */
	private JLabel instruction;
	
	/**
	 * The object that handles the language setting.
	 */
	private LanguageManager langManager;
	
	/**
	 * A JComboBox that enables the user to change the language
	 */
	private LanguageMenu languageMenu;

	/**
	 * Constructor
	 * @param width
	 * @param height
	 */
	public LanguagePanel() {
		
		setLayout(new FlowLayout());
		instruction = new JLabel();
		instruction.setFont(new AppFont());
		langManager = LanguageManager.getInstance();
		languageMenu = new LanguageMenu();
		languageMenu.addItemListener(new LanguageItemListener());
		languageMenu.setFont(new AppFont());
		add(instruction);
		add(languageMenu);
	}

	/**
	 * Detects the chosen language and applies the selection.
	 */
	public void updateLanguage() {
		
		String language = (String) languageMenu.getSelectedItem();
		
		switch(language) {
		case LanguageMenu.FRENCH:
			langManager.setLanguage(LanguageManager.Language.FRENCH);
			break;
		case LanguageMenu.ENGLISH:
			langManager.setLanguage(LanguageManager.Language.ENGLISH);
			break;
		case LanguageMenu.SPANISH:
			langManager.setLanguage(LanguageManager.Language.SPANISH);
			break;
		default:
			// Not useful.
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
