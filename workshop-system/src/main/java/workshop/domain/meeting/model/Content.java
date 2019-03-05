package workshop.domain.meeting.model;

public class Content {

	private String contentText;

	private Content(String contentText) {
		this.contentText = contentText;
	}

	public static Content of(String contentText) {
		return new Content(contentText);
	}
	
	@Override
	public String toString() {
		return contentText;
	}

}
