package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conversion.TempScale;

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
	protected JComboBox<TempScale> scaleSelector =
			new JComboBox<TempScale>();

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
	public TempScale getScale() {
		return (TempScale) scaleSelector.getSelectedItem();
	}

	private void initScaleSelector() {
		scaleSelector.setFont(new AppFont());
		scaleSelector.addItem(TempScale.DEG_CELSIUS);
		scaleSelector.addItem(TempScale.DEG_FAHRENHEIT);
		scaleSelector.addItem(TempScale.KELVIN);
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
		TempScale scale1 =
				(TempScale) iop1.scaleSelector.getSelectedItem();
		TempScale scale2 =
				(TempScale) iop2.scaleSelector.getSelectedItem();
		iop1.scaleSelector.setSelectedItem(scale2);
		iop2.scaleSelector.setSelectedItem(scale1);
	}
}
