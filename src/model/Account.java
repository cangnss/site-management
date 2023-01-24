package model;

public class Account {
	private Double balance;
	private int apartment_id;
	private int bill_id;
	public Account(Double balance, int apartment_id, int bill_id) {
		super();
		this.balance = balance;
		this.apartment_id = apartment_id;
		this.bill_id = bill_id;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	

}
