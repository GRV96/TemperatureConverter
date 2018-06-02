package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import converters.CFConverter;
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
	
	// Object that performs the conversion
	private TemperatureConverter tc;
	
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
		
		JPanel cp = new JPanel();
		cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));
		
		inputPanel = new InputPanel();
		cp.add(inputPanel);
		
		convBtn = new JButton("Convert");
		convBtn.addActionListener(new ConversionListener());
		cp.add(convBtn);
		
		tc = new CFConverter();
		outputPanel = new OutputPanel();
		outputPanel.displayTemp(tc.convert(-40));
		cp.add(outputPanel);
		
		setContentPane(cp);
	}

	public static void main(String[] args) {
		
		JFrame f = new ConvFrame();
	}
	
	/**
	 * Action listner for the conversion button
	 * @author GRV96
	 *
	 */
	private class ConversionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//
		}
	}
}
