package controller;

import java.util.ArrayList;

import model.Meeting;
import service.MeetingService;

public class MeetingController {
	private final MeetingService meetingService;

	public MeetingController(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public ArrayList<String> allMeetings() {
		return meetingService.allMeetings();
	}

	public void addMeeting(Meeting meeting) {
		meetingService.addMeeting(meeting);
	}

	public void updateMeeting(int id, Meeting meeting) {
		meetingService.updateMeeting(id, meeting);
	}

	public void deleteMeeting(int id) {
		meetingService.deleteMeeting(id);
	}
	
	
	
	
}
