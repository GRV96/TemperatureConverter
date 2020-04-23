package gui;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import language.Language;
import language.LanguageUpdater;

/**
 * This panel enables the user to change the language of the application.
 * @author GRV96
 */
public class LanguagePanel extends JPanel {

	private static final long serialVersionUID = -4605260424700093571L;

	/**
	 * A JLabel informing the user they can change the language
	 */
	private JLabel instruction = new JLabel();

	/**
	 * A JComboBox containing the available languages
	 */
	private JComboBox<Language> langSelector = new JComboBox<Language>();

	/**
	 * Constructor
	 */
	public LanguagePanel() {
		setLayout(new FlowLayout());
		instruction.setFont(new AppFont());
		initLangSelector();
		add(instruction);
		add(langSelector);
		setInstructionText();
	}

	public Language getSelectedLanguage() {
		return (Language) langSelector.getSelectedItem();
	}

	private void initLangSelector() {
		langSelector.addItem(Language.FRENCH);
		langSelector.addItem(Language.ENGLISH);
		langSelector.addItem(Language.SPANISH);
		langSelector.setFont(new AppFont());

		langSelector.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setInstructionText();
				LanguageUpdater.getInstance().setLanguage(getSelectedLanguage());
			}});
	}

	private void setInstructionText() {
		Language selectedLang = getSelectedLanguage();
		GuiElements guiElems = GuiElements.getInstance();
		instruction.setText(guiElems.getChooseLangText(selectedLang));
	}
}
