package gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import language.Language;

/**
 * This singleton parses the XML file that defines elements displayed in
 * the user interface, namely texts available in different languages.
 * @author GRV96
 */
public class GuiElements {

	private static final GuiElements uniqueInstance = new GuiElements();

	private static final String GUI_ELEMENTS_FILE_PATH = "src/gui/gui_elements.xml";

	private static final String ENGLISH_TAG = "english";
	private static final String FRENCH_TAG = "french";
	private static final String SPANISH_TAG = "spanish";

	private static final String PICTURES_TAG = "pictures";
	private static final String THERMOMETER_PIC_TAG = "thermometer_pic";

	private static final String TEXTS_TAG = "texts";
	private static final String CHOOSE_LANGUAGE_TAG = "choose_language";
	private static final String CONVERT_BTN_TAG = "convert_btn";
	private static final String FRAME_TITLE_TAG = "frame_title";
	private static final String SWITCH_SCALES_TAG = "switch_scales";

	private Map<Language, String> chooseLangText = new HashMap<Language, String>();
	private Map<Language, String> convertBtnText = new HashMap<Language, String>();
	private Map<Language, String> frameTitle = new HashMap<Language, String>();
	private Map<Language, String> switchScalesText = new HashMap<Language, String>();

	private String thermometerPicPath = null;

	private GuiElements() {
		parseGuiElemFile();
	}

	private static Element generateRootElement() {
		Element rootElement = null;
		File configFile = new File(GUI_ELEMENTS_FILE_PATH);
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(configFile);
			rootElement = document.getDocumentElement();
			rootElement.normalize();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
			System.exit(1);
		}
		catch (SAXException saxE) {
			saxE.printStackTrace();
			System.exit(1);
		}
		return rootElement;
	}

	public String getChooseLangText(Language lang) {return chooseLangText.get(lang);}

	public String getConvertBtnText(Language lang) {return convertBtnText.get(lang);}

	/**
	 * Collects all the children of the given
	 * DOM element node whose type is Element.
	 * @param element a DOM element node
	 * @return the element children of the given element
	 */
	private static List<Element> getElementChildrenOf(Element element) {
		List<Element> elemChildren = new ArrayList<Element>();
		NodeList children = element.getChildNodes();
		int childCount = children.getLength();
		for(int i=0; i<childCount; i++) {
			Node child = children.item(i);
			if(child instanceof Element) {
				elemChildren.add((Element) child);
			}
		}
		return elemChildren;
	}

	public String getFrameTitle(Language lang) {return frameTitle.get(lang);}

	public static GuiElements getInstance() {return uniqueInstance;}

	public String getSwitchScalesText(Language lang) {return switchScalesText.get(lang);}

	public String getThermometerPicPath() {return thermometerPicPath;}

	private void parseGuiElemFile() {
		Element rootElement = generateRootElement();
		List<Element> childrenOfRoot = getElementChildrenOf(rootElement);
		for(Element child: childrenOfRoot) {
			switch(child.getTagName()) {
			case PICTURES_TAG:
				parsePicElement(child);
				break;
			case TEXTS_TAG:
				parseTextElement(child);
				break;
			}
		}
	}

	private static void parseMultilangElement
	(Element multilangElement, Map<Language, String> multilangMap) {
		List<Element> children = getElementChildrenOf(multilangElement);
		for(Element child: children) {
			switch(child.getTagName()) {
			case ENGLISH_TAG:
				multilangMap.put(Language.ENGLISH, child.getTextContent());
				break;
			case FRENCH_TAG:
				multilangMap.put(Language.FRENCH, child.getTextContent());
				break;
			case SPANISH_TAG:
				multilangMap.put(Language.SPANISH, child.getTextContent());
				break;
			}
		}
	}

	private void parsePicElement(Element pictureElement) {
		List<Element> picChildren = getElementChildrenOf(pictureElement);
		for(Element child: picChildren) {
			switch(child.getTagName()) {
			case THERMOMETER_PIC_TAG:
				thermometerPicPath = child.getTextContent();
				break;
			}
		}
	}

	private void parseTextElement(Element textElement) {
		List<Element> textChildren = getElementChildrenOf(textElement);
		for(Element child: textChildren) {
			switch(child.getTagName()) {
			case CHOOSE_LANGUAGE_TAG:
				parseMultilangElement(child, chooseLangText);
				break;
			case CONVERT_BTN_TAG:
				parseMultilangElement(child, convertBtnText);
				break;
			case FRAME_TITLE_TAG:
				parseMultilangElement(child, frameTitle);
				break;
			case SWITCH_SCALES_TAG:
				parseMultilangElement(child, switchScalesText);
				break;
			}
		}
	}
}
