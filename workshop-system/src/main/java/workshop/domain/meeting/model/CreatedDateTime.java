package workshop.domain.meeting.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * イベント作成日時のValueObject
 * @author seike0311
 *
 */
public class CreatedDateTime {

	private LocalDateTime createdDateTime;

	public static CreatedDateTime of(LocalDateTime createdDateTime) {
		return new CreatedDateTime(createdDateTime);
	}

	public static CreatedDateTime yyyyMMddHHmmssFormatOf(String createdDateTime) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(createdDateTime, f);
		return new CreatedDateTime(dateTime);
	}

	@Override
	public String toString() {
		return createdDateTime.toString();
	}
	
	private CreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
}
