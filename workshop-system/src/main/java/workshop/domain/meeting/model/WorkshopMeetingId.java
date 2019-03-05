package workshop.domain.meeting.model;

import workshop.domain.user.model.UserId;

/**
 * 勉強会イベントの一意な識別子のValueObject
 * @author seike0311
 *
 */
public class WorkshopMeetingId {

	private String id;

	public WorkshopMeetingId(String id) {
		this.id = id;
	}

	public static WorkshopMeetingId of(UserId createdUserId, Title title, OpeningDateTime openingDates) {
		return new WorkshopMeetingId(createdUserId.id() + title.toString() + openingDates.toString());
	}

	public String id() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof WorkshopMeetingId)) {
			return false;
		}
		WorkshopMeetingId id = (WorkshopMeetingId) obj;
		return this.id.equals(id.id());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

}
