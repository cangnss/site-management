package repository;

import java.util.ArrayList;
import java.util.Date;

import model.Meeting;

public interface IMeetingRepository {
	ArrayList<String> allMeetings();
	//ArrayList<String> getPastMeetings(Date startDate, Date finishDate);
	void addMeeting(Meeting meeting);
	void updateMeeting(int id, Meeting meeting);
	void deleteMeeting(int id);
}
