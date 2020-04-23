package language;

public enum Language {
	ENGLISH("English"), FRENCH("Français"), SPANISH("Español");

	private String nativeName = null;

	private Language(String nativeName) {
		this.nativeName = nativeName;
	}

	@Override
	public String toString() {return nativeName;}
}
