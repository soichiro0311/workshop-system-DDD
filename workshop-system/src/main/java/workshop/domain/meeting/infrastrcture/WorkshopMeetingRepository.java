package workshop.domain.meeting.infrastrcture;

import workshop.domain.meeting.model.WorkshopMeeting;

/**
 * 勉強会イベントの永続化インターフェース
 * @author seike0311
 *
 */
public interface WorkshopMeetingRepository {

	public void save(WorkshopMeeting meeting);

	public WorkshopMeeting findById(String id);

}
