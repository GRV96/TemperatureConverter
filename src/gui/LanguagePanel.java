package gui;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import language.LanguageObserver;
import language.TextContainer;

/**
 * This panel enables the user to change the language of the application.
 * @author GRV96
 *
 */
public class LanguagePanel extends JPanel implements LanguageObserver {
	
	private JLabel instruction;
	private LanguageMenu languageMenu;

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
		add(instruction);
		add(languageMenu);
	}
	
	/**
	 * Adds an ItemListener for the language selection menu.
	 * @param il
	 * 		An ItemListener
	 */
	public void addItemListener(ItemListener il) {
		
		languageMenu.addItemListener(il);
	}

	/**
	 * Accesses the selected language
	 * @return a String representing the language selected by the user
	 */
	public String getLanguage() {
		
		return (String) languageMenu.getSelectedItem();
	}
	
	@Override
	public void updateLanguage(TextContainer tc) {
		
		instruction.setText(tc.getText(TextContainer.LANGUAGE_MENU_KEY));
	}
}
