package model;

public class Role {
	private int id;
	private String type;
	private int person_id;
	private int apartment_id;
	
	public Role(String type, int person_id, int apartment_id) {
		this.type = type;
		this.person_id = person_id;
		this.apartment_id = apartment_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public int getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}
	
	
}
