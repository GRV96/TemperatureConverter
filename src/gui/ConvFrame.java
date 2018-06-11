package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import convcreators.ConverterFactory;
import converters.TemperatureConverter;
import language.EnglishTextContainer;
import language.FrenchTextContainer;
import language.LanguageObserver;
import language.SpanishTextContainer;
import language.TextContainer;

/**
 * The application's user interface
 * @author GRV96
 *
 */
public class ConvFrame extends JFrame implements LanguageObserver {
	
	// Interface dimensions
	public static final int FRAME_HEIGHT = 650;
	public static final int FRAME_WIDTH = 500;
	
	// Allows to select the language.
	private LanguagePanel languagePanel;

	// Recieves the temperature to convert.
	private InputPanel inputPanel;

	// Displays the converted temperature.
	private OutputPanel outputPanel;

	// Button that launches the conversion
	private JButton convBtn;

	/**
	 * Constructor
	 */
	public ConvFrame() {

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildContentPane();
		setLanguage();
		setVisible(true);
	}

	/**
	 * Assembles the interface's components: input and output fields, menus and button.
	 */
	private void buildContentPane() {
		
		int panelHeight = 40;

		JPanel cp = new JPanel();
		cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));
		
		languagePanel = new LanguagePanel(FRAME_WIDTH, panelHeight);
		languagePanel.addItemListener(new LanguageItemListener());
		cp.add(languagePanel);

		inputPanel = new InputPanel(FRAME_WIDTH, panelHeight);
		cp.add(inputPanel);

		convBtn = new JButton();
		convBtn.addActionListener(new ConversionListener());
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(convBtn);
		cp.add(btnPanel);
		
		outputPanel = new OutputPanel(FRAME_WIDTH, panelHeight);
		cp.add(outputPanel);
		
		ImageIcon thermometerImage = new ImageIcon("thermometer.jpg");
		JLabel imageLabel = new JLabel(thermometerImage);
		JPanel imagePanel = new JPanel();
		imagePanel.add(imageLabel);
		cp.add(imagePanel);

		setContentPane(cp);
	}
	
	/**
	 * Detects the chosen language and applies the selection.
	 */
	private void setLanguage() {
		
		String language = languagePanel.getLanguage();
		TextContainer tc = null;
		
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
		}
		
		updateLanguage(tc);
	}

	@Override
	public void updateLanguage(TextContainer tc) {
		
		setTitle(tc.getText(TextContainer.TITLE_KEY));
		convBtn.setText(tc.getText(TextContainer.CONVERSION_BTN_KEY));
		languagePanel.updateLanguage(tc);
	}

	/**
	 * Starts all the stuff.
	 * @param args
	 * 		Who uses that?
	 */
	public static void main(String[] args) {

		new ConvFrame();
	}

	/**
	 * Action listener for the conversion button
	 * @author GRV96
	 *
	 */
	private class ConversionListener implements ActionListener{
		
		// Object that performs the conversion
		private TemperatureConverter tc;
		
		// Input temperatue scale
		private String inputScale = "";
		
		// Output temperature scale
		private String outputScale = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// Current input and output scales
			String iScale = inputPanel.getScale();
			String oScale = outputPanel.getScale();
			
			// If the input or output scale has changed, a new converter is instantiated.
			if(!inputScale.equals(iScale) || !outputScale.equals(oScale)) {
				
				inputScale = iScale;
				outputScale = oScale;
				tc = ConverterFactory.createConverter(inputScale, outputScale);
			}
			
			try {
				
			// The input temperature
			double inputTemp = inputPanel.getInputTemperature();
			
			// The output temperature
			double outputTemp = tc.convert(inputTemp);
			
			outputPanel.displayTemperature(outputTemp);
			}
			
			catch(java.lang.NumberFormatException nfe) {
				
				// Do nothing. Conversion is impossible.
			}
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
