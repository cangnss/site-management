package model;

public class Apartment {

	private int id;
	private String apartmantName;
	
	public Apartment(String apartmantName) {
		this.apartmantName = apartmantName;
	}

	public String getApartmantName() {
		return apartmantName;
	}

	public void setApartmantName(String apartmantName) {
		this.apartmantName = apartmantName;
	}
}
