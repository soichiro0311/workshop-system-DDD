package workshop.domain.meeting.service;

import workshop.domain.meeting.infrastrcture.WorkshopMeetingRepository;
import workshop.domain.meeting.model.WorkshopMeeting;
import workshop.domain.meeting.model.WorkshopMeetingId;

public class WorkshopMeetingQueryService {

	private WorkshopMeetingRepository repository;

	public WorkshopMeetingQueryService(WorkshopMeetingRepository repository) {
		this.repository = repository;
	}
	public WorkshopMeeting meeting(WorkshopMeetingId meetingId) {
		return repository.findById(meetingId.id());
	}

}
