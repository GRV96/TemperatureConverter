package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conversion.ConversionController;
import conversion.TempScale;
import language.Language;
import language.LanguageUpdater;

/**
 * The application's user interface
 * @author GRV96
 */
public class ConvFrame extends JFrame implements Observer {

	private static final long serialVersionUID = 251902842150196855L;

	// Interface dimensions
	private static final int FRAME_HEIGHT = 650;
	private static final int FRAME_WIDTH = 520;

	private ConversionController convController;

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
		LanguageUpdater.getInstance().addObserver(this);
		convController = new ConversionController();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildContentPane();
		setVisible(true);
	}

	/**
	 * Assembles the interface's components: input and output fields, menus and buttons.
	 */
	private void buildContentPane() {
		int panelHeight = 40;

		// The JPanel that will become the content pane
		JPanel cp = new JPanel();
		cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));

		// A panel to choose the language
		languagePanel = new LanguagePanel();
		languagePanel.setSize(FRAME_WIDTH, panelHeight);
		cp.add(languagePanel);

		// A panel to enter the input temperature
		inputPanel = new InputPanel();
		inputPanel.setSize(FRAME_WIDTH, panelHeight);
		inputPanel.ioField.addKeyListener(new ConversionKeyListener());
		cp.add(inputPanel);

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
		cp.add(btnPanel);

		// A panel to display the result of the conversion
		outputPanel = new OutputPanel();
		outputPanel.setSize(FRAME_WIDTH, panelHeight);
		cp.add(outputPanel);

		// A thermometer picture is displayed.
		String thermometerPicPath = GuiElements.getInstance().getThermometerPicPath();
		ImageIcon thermometerImage = new ImageIcon(thermometerPicPath);
		JLabel imageLabel = new JLabel(thermometerImage);
		JPanel imagePanel = new JPanel();
		imagePanel.add(imageLabel);
		cp.add(imagePanel);

		// The interface's language is set.
		Language selectedLang = languagePanel.getSelectedLanguage();
		setLanguage(selectedLang);

		setContentPane(cp);
	}

	private void convert() {
		try {
			TempScale fromScale = inputPanel.getScale();
			TempScale toScale = outputPanel.getScale();
			double inputTemp = inputPanel.getTemperature();
			double outputTemp = convController.convert(inputTemp, fromScale, toScale);
			outputPanel.displayTemperature(outputTemp);
		}
		catch(NumberFormatException nfe) {
			// Do nothing. Conversion is impossible.
		}
	}

	private void setLanguage(Language lang) {
		GuiElements guiElems = GuiElements.getInstance();
		setTitle(guiElems.getFrameTitle(lang));
		convBtn.setText(guiElems.getConvertBtnText(lang));
		switchBtn.setText(guiElems.getSwitchScalesText(lang));
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LanguageUpdater) {
			LanguageUpdater langUpdater = (LanguageUpdater) o;
			Language selectedLang = langUpdater.getLanguage();
			setLanguage(selectedLang);
		}
	}

	/**
	 * Starts all the stuff.
	 */
	public static void main(String[] args) {
		new ConvFrame();
	}

	/**
	 * Action listener for the conversion button
	 * @author GRV96
	 */
	private class ConversionBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			convert();
		}
	}

	private class ConversionKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == '\n') {
				convert();
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
