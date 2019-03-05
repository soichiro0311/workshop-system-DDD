package workshop.domain.meeting.model;

public class Title {
	private String titleText;

	private Title(String titleText) {
		this.titleText = titleText;
	}

	public static Title of(String titleText) {
		return new Title(titleText);
	}
	
	@Override
	public String toString() {
		return this.titleText;
	}

}
