package model;

public class FlatNo {
private int apartment_id;
private int number;
private int person_id;
private int flat_id;


public FlatNo(int apartment_id, int number, int person_id, int flat_id) {
	super();
	this.apartment_id = apartment_id;
	this.number = number;
	this.person_id = person_id;
	this.flat_id = flat_id;
}
public int getApartment_id() {
	return apartment_id;
}
public void setApartment_id(int apartment_id) {
	this.apartment_id = apartment_id;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public int getPerson_id() {
	return person_id;
}
public void setPerson_id(int person_id) {
	this.person_id = person_id;
}
public int getFlat_id() {
	return flat_id;
}
public void setFlat_id(int flat_id) {
	this.flat_id = flat_id;
}



}
