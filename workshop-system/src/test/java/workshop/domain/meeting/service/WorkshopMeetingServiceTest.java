package workshop.domain.meeting.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import workshop.domain.meeting.infrastrcture.WorkshopMeetingRepository;
import workshop.domain.meeting.infrastructure.WorkshopMeetingRepositoryMockImpl;
import workshop.domain.meeting.model.Content;
import workshop.domain.meeting.model.CreatedDateTime;
import workshop.domain.meeting.model.OpeningDateTime;
import workshop.domain.meeting.model.Title;
import workshop.domain.meeting.model.WorkshopMeeting;
import workshop.domain.meeting.model.WorkshopMeetingId;
import workshop.domain.user.model.UserId;
import workshop.domain.user.model.UserName;

public class WorkshopMeetingServiceTest {
	private WorkshopMeetingRepository repositoryMockImpl;
	private WorkshopMeetingCommandService commandService;
	private WorkshopMeetingQueryService queryService;

	@Before
	public void init() {
		repositoryMockImpl = new WorkshopMeetingRepositoryMockImpl();
		commandService = new WorkshopMeetingCommandService(repositoryMockImpl);
		queryService = new WorkshopMeetingQueryService(repositoryMockImpl);
	}

	@Test
	public void ユーザが登録することによって_勉強会イベントが作成されること() {
		Title expectedTitle = Title.of("TEST-TITLE");
		Content expectedContent = Content.of("TEST-CONTENT");
		OpeningDateTime expectedOpeningDates = OpeningDateTime.yyyyMMddHHmmssFormatOf("2019/03/20 10:00:00");
		UserName userName = UserName.of("TESTUSER100065");
		UserId createdUserId = UserId.of(userName);
		CreatedDateTime createdDateTime = CreatedDateTime.yyyyMMddHHmmssFormatOf("2019/03/06 10:00:00");
		WorkshopMeetingId meetingId = WorkshopMeetingId.of(createdUserId, expectedTitle, expectedOpeningDates);
		WorkshopMeeting expectedWorkshopMeeting = WorkshopMeeting.of(meetingId, expectedTitle, expectedContent,
				expectedOpeningDates, createdDateTime);

		// execute
		commandService.createMeeting("TESTUSER100065", "TEST-CONTENT", "TEST-TITLE", "2019/03/20 10:00:00");
		assertEquals(expectedWorkshopMeeting, queryService.meeting(meetingId));
	}

}
