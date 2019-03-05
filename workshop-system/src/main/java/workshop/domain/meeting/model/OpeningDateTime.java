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

	private OpeningDateTime(LocalDateTime openingDateTime) {
		this.openingDateTime = openingDateTime;
	}

	public static OpeningDateTime of(String openingDateTime) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(openingDateTime, f);
		return new OpeningDateTime(dateTime);
	}

	@Override
	public String toString() {
		return openingDateTime.toString();
	}

}
