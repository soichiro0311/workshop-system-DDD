package workshop.domain.meeting.infrastrcture;

import workshop.domain.meeting.model.WorkshopMeeting;

/**
 * 勉強会イベントの永続化インターフェース
 * @author seike0311
 *
 */
public interface WorkshopMeetingRepository {

	void save(WorkshopMeeting meeting);

	WorkshopMeeting findById(String id);

}
