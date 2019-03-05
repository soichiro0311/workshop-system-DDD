package workshop.domain.meeting.service;

import java.time.LocalDateTime;

import workshop.domain.meeting.infrastrcture.WorkshopMeetingRepository;
import workshop.domain.meeting.model.Content;
import workshop.domain.meeting.model.CreatedDateTime;
import workshop.domain.meeting.model.OpeningDateTime;
import workshop.domain.meeting.model.Title;
import workshop.domain.meeting.model.WorkshopMeeting;
import workshop.domain.meeting.model.WorkshopMeetingId;
import workshop.domain.user.model.UserId;
import workshop.domain.user.model.UserName;
import workshop.domain.user.model.UserNumber;
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

	public void createMeeting(String userName,String userNumber, String contentText, String titleText, String openingDateTime) {
		Title title = Title.of(titleText);
		Content content = Content.of(contentText);
		OpeningDateTime openingDates = OpeningDateTime.of(openingDateTime);
		UserName createdUsername = UserName.of(userName);
		UserNumber createdUserNumber = UserNumber.of(userNumber);
		UserId createdUserId = UserId.of(createdUsername,createdUserNumber);
		WorkshopMeetingId meetingId = WorkshopMeetingId.of(createdUserId, title, openingDates);
		CreatedDateTime createdDateTime = CreatedDateTime.of(LocalDateTime.now());
		WorkshopMeeting meeting = WorkshopMeeting.of(meetingId, title, content, openingDates, createdDateTime);
		repository.save(meeting);
	}

}
