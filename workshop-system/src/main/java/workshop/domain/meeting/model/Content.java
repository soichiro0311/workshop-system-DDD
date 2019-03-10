package workshop.domain.meeting.model;
/**
 * イベント内容のValueObject
 * @author seike0311
 *
 */
public class Content {

	private String contentText;

	public static Content of(String contentText) {
		return new Content(contentText);
	}
	
	@Override
	public String toString() {
		return contentText;
	}

	private Content(String contentText) {
		this.contentText = contentText;
	}
}
