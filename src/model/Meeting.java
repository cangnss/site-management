package model;

import java.util.Date;

public class Meeting {
	private int apartment_id;
	private Date date;
	
	public Meeting(int apartment_id, Date date) {
		this.apartment_id = apartment_id;
		this.date = date;
	}

	
	public int getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
