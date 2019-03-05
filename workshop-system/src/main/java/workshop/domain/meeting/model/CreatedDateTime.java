package workshop.domain.meeting.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreatedDateTime {

	private LocalDateTime createdDateTime;

	public CreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public static CreatedDateTime of(String createdDateTime) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(createdDateTime, f);
		return new CreatedDateTime(dateTime);
	}

	@Override
	public String toString() {
		return createdDateTime.toString();
	}

	public static CreatedDateTime of(LocalDateTime createdDateTime) {
		return new CreatedDateTime(createdDateTime);
	}

}
