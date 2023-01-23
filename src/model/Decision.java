package model;

public class Decision {
	private int meeting_id;
	private int person_id;
	private String description;
	private String confirm_reject;
	
	public Decision(int meeting_id, int person_id, String description, String confirm_reject) {
		this.meeting_id = meeting_id;
		this.person_id = person_id;
		this.description = description;
		this.confirm_reject = confirm_reject;
	}

	public int getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConfirm_reject() {
		return confirm_reject;
	}

	public void setConfirm_reject(String confirm_reject) {
		this.confirm_reject = confirm_reject;
	}
	
	
}
