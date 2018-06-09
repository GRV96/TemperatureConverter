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

/**
 * The application's user interface
 * @author GRV96
 *
 */
public class ConvFrame extends JFrame {

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

		setTitle("Temperature Converter");
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildContentPane();
		setVisible(true);
	}

	/**
	 * Assembles the interface's components: input and output fields, menus and button.
	 */
	private void buildContentPane() {
		
		int ioFieldHeight = 40;

		JPanel cp = new JPanel();
		cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));

		inputPanel = new InputPanel(getWidth(), ioFieldHeight);
		cp.add(inputPanel);

		convBtn = new JButton("Convert");
		convBtn.addActionListener(new ConversionListener());
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(convBtn);
		cp.add(btnPanel);
		
		outputPanel = new OutputPanel(getWidth(), ioFieldHeight);
		cp.add(outputPanel);
		
		ImageIcon thermometerImage = new ImageIcon("thermometer.jpg");
		JLabel imageLabel = new JLabel(thermometerImage);
		cp.add(imageLabel);

		setContentPane(cp);
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
}
