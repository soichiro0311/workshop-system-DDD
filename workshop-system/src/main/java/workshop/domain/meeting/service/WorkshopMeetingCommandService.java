package workshop.domain.meeting.service;

import workshop.domain.meeting.infrastrcture.WorkshopMeetingRepository;
import workshop.domain.meeting.model.WorkshopMeeting;
/**
 * 勉強会イベントのコマンドドメインサービス
 * @author seike0311
 *
 */
public class WorkshopMeetingCommandService {

	private WorkshopMeetingRepository repository;

	public WorkshopMeetingCommandService(WorkshopMeetingRepository repository) {
		this.repository = repository;
	}

	public void createMeeting(String userName, String contentText, String titleText, String openingDateTime) {
		repository.save(WorkshopMeeting.of(userName, contentText, titleText, openingDateTime));
	}

}
