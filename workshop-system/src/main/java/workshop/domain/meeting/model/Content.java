package workshop.domain.meeting.model;
/**
 * イベント内容のValueObject
 * @author seike0311
 *
 */
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
