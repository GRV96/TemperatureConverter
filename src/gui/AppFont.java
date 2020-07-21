package gui;

import java.awt.Font;

/**
 * Defines a font for every text in the user interface.
 * @author GRV96
 *
 */
class AppFont extends Font {

	private static final long serialVersionUID = -5745748651688084392L;
	private static final String APP_FONT_NAME = "Dialog.plain";
	private static final int APP_FONT_SIZE = 20;

	public AppFont() {
		super(APP_FONT_NAME, Font.PLAIN, APP_FONT_SIZE);
	}
}
