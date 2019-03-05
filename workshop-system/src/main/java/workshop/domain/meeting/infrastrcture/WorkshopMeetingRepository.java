package workshop.domain.meeting.infrastrcture;

import workshop.domain.meeting.model.WorkshopMeeting;

public interface WorkshopMeetingRepository {

	void save(WorkshopMeeting meeting);

	WorkshopMeeting findById(String id);

}
