package workshop.domain.meeting.model;

import java.time.LocalDateTime;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import workshop.domain.user.model.UserId;
import workshop.domain.user.model.UserName;

/**
 * 勉強会イベントのエンティティ
 * 
 * @author seike0311
 *
 */
public class WorkshopMeeting {

	@NotNull(message = "WorkshopMeetingId is required")
	private WorkshopMeetingId meetingId;

	@NotNull(message = "Title is required")
	private Title title;

	@NotNull(message = "Content is required")
	private Content content;

	@NotNull(message = "OpeningDateTime is required")
	private OpeningDateTime openingDateTime;

	@NotNull(message = "CreatedDateTime is required")
	private CreatedDateTime createdDateTime;

	public static WorkshopMeeting of(WorkshopMeetingId meetingId, Title title, Content content,
			OpeningDateTime openingDateTime, CreatedDateTime createdDateTime) {
		return new WorkshopMeeting(meetingId, title, content, openingDateTime, createdDateTime);
	}

	public static WorkshopMeeting of(String userName, String contentText, String titleText, String openingDateTime) {
		Title title = Title.of(titleText);
		Content content = Content.of(contentText);
		OpeningDateTime openingDates = OpeningDateTime.yyyyMMddHHmmssFormatOf(openingDateTime);
		UserName createdUsername = UserName.of(userName);
		UserId createdUserId = UserId.of(createdUsername);
		WorkshopMeetingId meetingId = WorkshopMeetingId.of(createdUserId, title, openingDates);
		CreatedDateTime createdDateTime = CreatedDateTime.of(LocalDateTime.now());
		return WorkshopMeeting.of(meetingId, title, content, openingDates, createdDateTime);

	}

	public WorkshopMeetingId id() {
		return this.meetingId;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof WorkshopMeeting)) {
			return false;
		}
		WorkshopMeeting meeting = (WorkshopMeeting) obj;
		return this.id().equals(meeting.id());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id() == null) ? 0 : this.id().hashCode());
		return result;
	}

	private void validate() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		validator.validate(this).forEach(result -> {
			throw new RuntimeException(result.getMessage());
		});
	}

	private WorkshopMeeting(WorkshopMeetingId meetingId, Title title, Content content, OpeningDateTime openingDateTime,
			CreatedDateTime createdDateTime) {
		this.meetingId = meetingId;
		this.title = title;
		this.content = content;
		this.openingDateTime = openingDateTime;
		this.createdDateTime = createdDateTime;
		validate();

	}
}
