package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This superclass is a template to build panels for
 * the input temperature and the output temperature.
 * It is not meant to be instantiated.
 * @author GRV96
 *
 */
public abstract class IOPanel extends JPanel {
	
	private static final long serialVersionUID = -2289247146811041138L;
	
	protected JTextField ioField;
	protected ScaleMenu scaleMenu;

	/**
	 * The constructor is protected to prevent the instantiation.
	 * @param width
	 * @param height
	 */
	protected IOPanel(int width, int height) {
		
		int scaleMenuWidth = 50;
		
		setLayout(new FlowLayout());
		setSize(width, height);
		ioField = new JTextField();
		ioField.setPreferredSize(new Dimension(width-scaleMenuWidth-40, height));
		scaleMenu = new ScaleMenu();
		scaleMenu.setPreferredSize(new Dimension(scaleMenuWidth, height));
		add(ioField);
		add(scaleMenu);
	}
	
	/**
	 * Gets the scale chosen by the user.
	 * @return a string that represents the scale
	 */
	public String getScale() {
		
		return (String) scaleMenu.getSelectedItem();
	}
	
	/**
	 * Switches the scales of the two given IO panels.
	 * @param iop1
	 * 		An IO panel
	 * @param iop2
	 * 		An IO panel
	 */
	public static void switchScales(IOPanel iop1, IOPanel iop2) {
		
		String scale1 = (String) iop1.scaleMenu.getSelectedItem();
		String scale2 = (String) iop2.scaleMenu.getSelectedItem();
		
		iop1.scaleMenu.setSelectedItem(scale2);
		iop2.scaleMenu.setSelectedItem(scale1);
	}
}
