package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import convcreators.ConverterFactory;
import converters.TemperatureConverter;
import language.LanguageObserver;
import language.TextContainer;

/**
 * The application's user interface
 * @author GRV96
 *
 */
public class ConvFrame extends JFrame implements LanguageObserver {
	
	// Interface dimensions
	public static final int FRAME_HEIGHT = 650;
	public static final int FRAME_WIDTH = 520;
	
	// Allows to select the language.
	private LanguagePanel languagePanel;

	// Recieves the temperature to convert.
	private InputPanel inputPanel;

	// Displays the converted temperature.
	private OutputPanel outputPanel;

	// The button that launches the conversion
	private JButton convBtn;
	
	// The button that switches the input and output scales
	private JButton switchBtn;

	/**
	 * Constructor
	 */
	public ConvFrame() {

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildContentPane();
		setVisible(true);
	}

	/**
	 * Assembles the interface's components: input and output fields, menus and button.
	 */
	private void buildContentPane() {
		
		int panelHeight = 40;

		// The JPanel that will become the content pane
		JPanel cp = new JPanel();
		cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));
		
		// A panel to chose the language
		languagePanel = new LanguagePanel(FRAME_WIDTH, panelHeight);
		languagePanel.addLanguageObserver(this);
		cp.add(languagePanel);

		// A panel to enter the input temperature
		inputPanel = new InputPanel(FRAME_WIDTH, panelHeight);
		cp.add(inputPanel);

		// A button to launch the conversion
		convBtn = new JButton();
		convBtn.addActionListener(new ConversionListener());
		
		// A button to switch the input and output scales
		switchBtn = new JButton();
		switchBtn.addActionListener(new SwitchListener());
		
		// The panel that displays the conversion button
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(convBtn);
		btnPanel.add(switchBtn);
		cp.add(btnPanel);
		
		// A panel to display the result of the conversion
		outputPanel = new OutputPanel(FRAME_WIDTH, panelHeight);
		cp.add(outputPanel);
		
		// A thermometer picture is displayed.
		ImageIcon thermometerImage = new ImageIcon("thermometer.jpg");
		JLabel imageLabel = new JLabel(thermometerImage);
		JPanel imagePanel = new JPanel();
		imagePanel.add(imageLabel);
		cp.add(imagePanel);
		
		// All texts in the interface are set.
		languagePanel.setLanguage();

		setContentPane(cp);
	}

	@Override
	public void updateLanguage(TextContainer tc) {
		
		setTitle(tc.getText(TextContainer.TITLE_KEY));
		convBtn.setText(tc.getText(TextContainer.CONVERSION_BTN_KEY));
		switchBtn.setText(tc.getText(TextContainer.SWITCH_BTN_KEY));
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
	private class ConversionListener implements ActionListener {
		
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
	 * A listener for the scale switching button
	 * @author GRV96
	 *
	 */
	private class SwitchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			IOPanel.switchScales(inputPanel, outputPanel);
		}
	}
}
