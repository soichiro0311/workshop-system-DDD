package workshop.application.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkshopMeetingForm {
	private String title;
	
	private String content;
	
	private String openingDateTime;
}
