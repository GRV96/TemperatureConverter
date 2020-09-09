package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conversion.ConversionController;
import conversion.TempScale;
import language.Language;

/**
 * The application's user interface
 * @author GRV96
 */
public class ConvFrame extends Observable {

	private static final long serialVersionUID = 251902842150196855L;

	// Interface dimensions
	private static final int FRAME_GREAT_HEIGHT = 650;
	private static final int FRAME_SMALL_HEIGHT = 250;
	private static final int FRAME_WIDTH = 520;
	private static final int PANEL_HEIGHT = 40;

	private JFrame frame = new JFrame();

	// Allows to select the language.
	private LanguagePanel languagePanel;

	// Receives the temperature to convert.
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
		frame.setSize(FRAME_WIDTH, FRAME_GREAT_HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildContentPane();
		frame.setVisible(true);
	}

	/**
	 * Assembles the interface's components:
	 * input and output fields, menus and buttons.
	 */
	private void buildContentPane() {
		// The JPanel that will become the content pane
		JPanel cp = new JPanel();
		cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));

		languagePanel = initLanguagePanel();
		cp.add(languagePanel);

		inputPanel = initInputPanel();
		cp.add(inputPanel);

		JPanel btnPanel = initBtnPanel();
		cp.add(btnPanel);

		outputPanel = initOutputPanel();
		cp.add(outputPanel);

		JPanel picturePanel = initPicturePanel();
		if(picturePanel == null) {
			frame.setSize(FRAME_WIDTH, FRAME_SMALL_HEIGHT);
		}
		else {
			cp.add(picturePanel);
		}

		Language selectedLang = languagePanel.getSelectedLanguage();
		setLanguage(selectedLang);

		frame.setContentPane(cp);
	}

	/**
	 * Sets the temperature to display in the output field.
	 * @param temperature - the temperature to display
	 */
	public void displayTemperature(double temperature) {
		outputPanel.displayTemperature(temperature);
	}

	/**
	 * Accessor of the scale from which the conversion will be performed.
	 * @return a TemperatureScale enumeration value
	 */
	public TempScale getInputScale() {
		return inputPanel.getScale();
	}

	/**
	 * Accessor of the temperature inputed by the user.
	 * @return the temperature to convert
	 * @throws NumberFormatException
	 */
	public double getInputTemperature() throws NumberFormatException {
		return inputPanel.getTemperature();
	}

	/**
	 * Accessor of the scale to which the conversion will be performed.
	 * @return a TemperatureScale enumeration value
	 */
	public TempScale getOutputScale() {
		return outputPanel.getScale();
	}

	private JPanel initBtnPanel() {
		// A button to launch the conversion
		convBtn = new JButton();
		convBtn.addActionListener(new ConversionBtnListener());
		convBtn.setFont(new AppFont());

		// A button to switch the input and output scales
		switchBtn = new JButton();
		switchBtn.addActionListener(new SwitchListener());
		switchBtn.setFont(new AppFont());

		// The panel that displays the buttons
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(convBtn);
		btnPanel.add(switchBtn);

		return btnPanel;
	}

	private InputPanel initInputPanel() {
		InputPanel inputPanel = new InputPanel();
		inputPanel.setSize(FRAME_WIDTH, PANEL_HEIGHT);
		inputPanel.ioField.addKeyListener(new ConversionKeyListener());
		return inputPanel;
	}

	private LanguagePanel initLanguagePanel() {
		LanguagePanel languagePanel = new LanguagePanel();
		languagePanel.setSize(FRAME_WIDTH, PANEL_HEIGHT);
		return languagePanel;
	}

	private OutputPanel initOutputPanel() {
		OutputPanel outputPanel = new OutputPanel();
		outputPanel.setSize(FRAME_WIDTH, PANEL_HEIGHT);
		return outputPanel;
	}

	private JPanel initPicturePanel() {
		String picPath = GuiElements.getInstance().getThermometerPicPath();
		File picFile = new File(picPath);
		if(!picFile.exists()) {
			return null;
		}

		ImageIcon thermometerImage = new ImageIcon(picPath);
		JLabel pictureLabel = new JLabel(thermometerImage);
		JPanel picturePanel = new JPanel();
		picturePanel.add(pictureLabel);
		return picturePanel;
	}

	/**
	 * Changes the language of the texts displayed in this frame.
	 * @param lang - a value of the enumeration Language
	 */
	public void setLanguage(Language lang) {
		GuiElements guiElems = GuiElements.getInstance();
		frame.setTitle(guiElems.getFrameTitle(lang));
		convBtn.setText(guiElems.getConvertBtnText(lang));
		switchBtn.setText(guiElems.getSwitchScalesText(lang));
	}

	/**
	 * Action listener for the conversion button
	 * @author GRV96
	 */
	private class ConversionBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setChanged();
			notifyObservers();
		}
	}

	private class ConversionKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == '\n') {
				setChanged();
				notifyObservers();
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}
	}

	/**
	 * A listener for the scale switching button
	 * @author GRV96
	 */
	private class SwitchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			IOPanel.switchScales(inputPanel, outputPanel);
		}
	}
}
