package workshop.domain.meeting.infrastructure;

import java.util.HashMap;
import java.util.Map;

import workshop.domain.meeting.infrastrcture.WorkshopMeetingRepository;
import workshop.domain.meeting.model.WorkshopMeeting;

public class WorkshopMeetingRepositoryMockImpl implements WorkshopMeetingRepository {

	private Map<String,WorkshopMeeting> inMemoryMap = new HashMap<>();

	@Override
	public void save(WorkshopMeeting meeting) {
		inMemoryMap.put(meeting.id().id(),meeting);
	}

	@Override
	public WorkshopMeeting findById(String id) {
		return inMemoryMap.get(id);
	}

}
