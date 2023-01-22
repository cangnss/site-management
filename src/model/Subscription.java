package model;

public class Subscription {

	private int apartment_id;
	private String service;
	private String period;
	private double cost;
	
	public Subscription(int apartment_id, String service, String period, double cost) {
		super();
		this.apartment_id = apartment_id;
		this.service = service;
		this.period = period;
		this.cost = cost;
	}
	
	public int getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	
}
