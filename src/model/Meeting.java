package model;

public class Meeting {
	private int apartment_id;
	private String date;

	public Meeting(int apartment_id, String date) {
		this.apartment_id = apartment_id;
		this.date = date;
	}


	public int getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
