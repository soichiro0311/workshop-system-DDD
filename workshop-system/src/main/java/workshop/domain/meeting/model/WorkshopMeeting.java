package workshop.domain.meeting.model;

public class WorkshopMeeting {

	private WorkshopMeetingId meetingId;
	private Title title;
	private Content content;
	private OpeningDateTime openingDateTime;
	private CreatedDateTime createdDateTime;

	public WorkshopMeeting(WorkshopMeetingId meetingId, Title title, Content content, OpeningDateTime openingDateTime,
			CreatedDateTime createdDateTime) {
		this.meetingId = meetingId;
		this.title = title;
		this.content = content;
		this.openingDateTime = openingDateTime;
		this.createdDateTime = createdDateTime;

	}

	public static WorkshopMeeting of(WorkshopMeetingId meetingId, Title title, Content content,
			OpeningDateTime openingDateTime, CreatedDateTime createdDateTime) {
		return new WorkshopMeeting(meetingId, title, content, openingDateTime, createdDateTime);
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

}
