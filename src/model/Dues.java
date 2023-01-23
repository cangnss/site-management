package model;

public class Dues {
   private int number_id;
   private String month;
   private Double cost;
public Dues(int number_id, String month, Double cost) {
	super();
	this.number_id = number_id;
	this.month = month;
	this.cost = cost;
}
public int getNumber_id() {
	return number_id;
}
public void setNumber_id(int number_id) {
	this.number_id = number_id;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public Double getCost() {
	return cost;
}
public void setCost(Double cost) {
	this.cost = cost;
}
   
   
   

}
