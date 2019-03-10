package workshop.domain.meeting.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import workshop.domain.user.model.UserId;
import workshop.domain.user.model.UserName;

public class WorkshopMeetingTest {

	@Test
	public void 勉強会イベントが作成できること() {
		String titleText = "TEST-TILE";
		String userName = "TESTUSER100065";
		String contentText = "TEST-CONTENT";
		String openingDateTime = "2018/11/23 23:32:11";
		assertNotNull(WorkshopMeeting.of(userName, contentText, titleText, openingDateTime));
	}

	@Test
	public void 勉強会イベントが値オブジェクトから作成できること() {
		Title expectedTitle = Title.of("TEST-TITLE");
		Content expectedContent = Content.of("TEST-CONTENT");
		OpeningDateTime expectedOpeningDates = OpeningDateTime.yyyyMMddHHmmssFormatOf("2019/03/20 10:00:00");
		UserName userName = UserName.of("TESTUSER100065");
		UserId createdUserId = UserId.of(userName);
		CreatedDateTime createdDateTime = CreatedDateTime.yyyyMMddHHmmssFormatOf("2019/03/06 10:00:00");
		WorkshopMeetingId meetingId = WorkshopMeetingId.of(createdUserId, expectedTitle, expectedOpeningDates);
		assertNotNull(
				WorkshopMeeting.of(meetingId, expectedTitle, expectedContent, expectedOpeningDates, createdDateTime));
	}

	@Test
	public void 入力値がnullで勉強会イベントを作成したとき_エラーが発生すること() {
		Title expectedTitle = Title.of("TEST-TITLE");
		Content expectedContent = Content.of("TEST-CONTENT");
		OpeningDateTime expectedOpeningDates = OpeningDateTime.yyyyMMddHHmmssFormatOf("2019/03/20 10:00:00");
		UserName userName = UserName.of("TESTUSER100065");
		UserId createdUserId = UserId.of(userName);
		CreatedDateTime createdDateTime = CreatedDateTime.yyyyMMddHHmmssFormatOf("2019/03/06 10:00:00");
		WorkshopMeetingId meetingId = WorkshopMeetingId.of(createdUserId, expectedTitle, expectedOpeningDates);
		try {
			WorkshopMeeting.of(null, expectedTitle, expectedContent, expectedOpeningDates, createdDateTime);
		} catch (Exception e) {
			assertEquals("WorkshopMeetingId is required", e.getMessage());
		}

		try {
			WorkshopMeeting.of(meetingId, null, expectedContent, expectedOpeningDates, createdDateTime);
		} catch (Exception e) {
			assertEquals("Title is required", e.getMessage());
		}

		try {
			WorkshopMeeting.of(meetingId, expectedTitle, null, expectedOpeningDates, createdDateTime);
		} catch (Exception e) {
			assertEquals("Content is required", e.getMessage());
		}
		
		try {
			WorkshopMeeting.of(meetingId, expectedTitle, expectedContent, null, createdDateTime);
		} catch (Exception e) {
			assertEquals("OpeningDateTime is required", e.getMessage());
		}
		
		try {
			WorkshopMeeting.of(meetingId, expectedTitle, expectedContent, expectedOpeningDates, null);
		} catch (Exception e) {
			assertEquals("CreatedDateTime is required", e.getMessage());
		}
	}
}
