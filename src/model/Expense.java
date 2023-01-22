package model;

public class Expense {
	
	private int apartment_id;
	private String description;
	private double cost;
	
	public Expense(int apartment_id, String description, double cost) {
		this.apartment_id = apartment_id;
		this.description = description;
		this.cost = cost;
	}
	
	public Expense(String description, double cost) {
		this.description = description;
		this.cost = cost;
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
