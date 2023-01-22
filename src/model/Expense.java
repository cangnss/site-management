package model;

public class Expense {
	private int id;
	private int apartment_id;
	private String description;
	private double cost;
	
	public Expense(int id, int apartment_id, String description, double cost) {
		this.id = id;
		this.apartment_id = apartment_id;
		this.description = description;
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
