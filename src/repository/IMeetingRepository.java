package repository;

import java.util.ArrayList;

import model.Meeting;

public interface IMeetingRepository {
	ArrayList<String> allMeetings();
	void addMeeting(Meeting meeting);
	void updateMeeting(int id, Meeting meeting);
	void deleteMeeting(int id);
}
