package workshop.domain.meeting.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * イベント開催日時のValueObject
 * @author seike0311
 *
 */
public class OpeningDateTime {

	private LocalDateTime openingDateTime;
	
	public static OpeningDateTime of(LocalDateTime openingDateTime) {
		return new OpeningDateTime(openingDateTime);
	}

	public static OpeningDateTime yyyyMMddHHmmssFormatOf(String openingDateTime) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(openingDateTime, f);
		return new OpeningDateTime(dateTime);
	}

	@Override
	public String toString() {
		return openingDateTime.toString();
	}

	private OpeningDateTime(LocalDateTime openingDateTime) {
		this.openingDateTime = openingDateTime;
	}
}
