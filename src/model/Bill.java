package model;

public class Bill {
	private int subscription_id;
	private int expense_id;
	private String date;
	private double amount;
	
	public Bill(int subscription_id, int expense_id, String date, double amount) {
		this.subscription_id = subscription_id;
		this.expense_id = expense_id;
		this.date = date;
		this.amount = amount;
	}

	public int getSubscription_id() {
		return subscription_id;
	}

	public void setSubscription_id(int subscription_id) {
		this.subscription_id = subscription_id;
	}

	public int getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
