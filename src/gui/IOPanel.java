package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import convcreators.TemperatureScale;

/**
 * This superclass is a template to build panels for
 * the input temperature and the output temperature.
 * It is not meant to be instantiated.
 * @author GRV96
 */
public abstract class IOPanel extends JPanel {

	private static final int SCALE_SELECTOR_WIDTH = 50;

	private static final long serialVersionUID = -2289247146811041138L;

	protected JTextField ioField = new JTextField();
	protected JComboBox<TemperatureScale> scaleSelector =
			new JComboBox<TemperatureScale>();

	protected IOPanel() {
		ioField.setFont(new AppFont());
		initScaleSelector();
		setLayout(new FlowLayout());
		add(ioField);
		add(scaleSelector);
	}

	/**
	 * Returns the temperature scale chosen by the user.
	 * @return a TemperatureScale enumeration value
	 */
	public TemperatureScale getScale() {
		return (TemperatureScale) scaleSelector.getSelectedItem();
	}

	private void initScaleSelector() {
		scaleSelector.setFont(new AppFont());
		scaleSelector.addItem(TemperatureScale.DEG_CELSIUS);
		scaleSelector.addItem(TemperatureScale.DEG_FAHRENHEIT);
		scaleSelector.addItem(TemperatureScale.KELVIN);
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		Dimension ioFieldDimension =
				new Dimension(width-SCALE_SELECTOR_WIDTH-40, height);
		ioField.setPreferredSize(ioFieldDimension);
		Dimension scaleSelectDimension =
				new Dimension(SCALE_SELECTOR_WIDTH, height);
		scaleSelector.setPreferredSize(scaleSelectDimension);
	}

	/**
	 * Switches the scales of the two given IO panels.
	 * @param iop1 an IO panel
	 * @param iop2 an IO panel
	 */
	public static void switchScales(IOPanel iop1, IOPanel iop2) {
		TemperatureScale scale1 =
				(TemperatureScale) iop1.scaleSelector.getSelectedItem();
		TemperatureScale scale2 =
				(TemperatureScale) iop2.scaleSelector.getSelectedItem();
		iop1.scaleSelector.setSelectedItem(scale2);
		iop2.scaleSelector.setSelectedItem(scale1);
	}
}
