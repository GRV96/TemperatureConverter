package gui;

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
		cp.add(convBtn);

		outputPanel = new OutputPanel(getWidth(), ioFieldHeight);
		cp.add(outputPanel);
		
		ImageIcon image = new ImageIcon("thermometer.jpg");
		JLabel imageLabel = new JLabel(image);
		cp.add(imageLabel);

		setContentPane(cp);
	}

	public static void main(String[] args) {

		JFrame f = new ConvFrame();
	}

	/**
	 * Action listener for the conversion button
	 * @author GRV96
	 *
	 */
	private class ConversionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			// Object that performs the conversion
			TemperatureConverter tc = ConverterFactory.
					createConverter(inputPanel.getScale(), outputPanel.getScale());
			
			// The input temperature
			double inputTemp = inputPanel.getInputTemperature();
			
			// The output Temperature
			double outputTemp = tc.convert(inputTemp);
			
			outputPanel.displayTemp(outputTemp);
		}
	}
}
