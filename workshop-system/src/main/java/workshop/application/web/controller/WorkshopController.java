package workshop.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import workshop.application.web.form.WorkshopMeetingForm;

@Controller
public class WorkshopController {
	@RequestMapping(value="/workshop/meeting/form" , method=RequestMethod.GET)
	public String workshopMeetingForm(@ModelAttribute("workshopMeetingForm") WorkshopMeetingForm workshopMeetingForm) {
		System.out.println("AAA");
		return "workshopMeetingForm";
	}
	
	@RequestMapping(value="/workshop/meeting/register" , method=RequestMethod.POST)
    public String registerWorkshopMeeting(@ModelAttribute("workshopMeetingForm") WorkshopMeetingForm workshopMeetingForm) {
        return "workshopMeetingForm";
    }

}
