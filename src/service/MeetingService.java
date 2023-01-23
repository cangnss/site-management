package service;

import java.util.ArrayList;

import model.Meeting;
import repository.MeetingRepository;

public class MeetingService {
	private final MeetingRepository meetingRepository;

	public MeetingService(MeetingRepository meetingRepository) {
		this.meetingRepository = meetingRepository;
	}

	public ArrayList<String> allMeetings() {
		return meetingRepository.allMeetings();
	}

	public void addMeeting(Meeting meeting) {
		meetingRepository.addMeeting(meeting);
	}

	public void updateMeeting(int id, Meeting meeting) {
		meetingRepository.updateMeeting(id, meeting);
	}

	public void deleteMeeting(int id) {
		meetingRepository.deleteMeeting(id);
	}
	
	
}
