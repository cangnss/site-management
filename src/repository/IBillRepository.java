package repository;

import java.util.ArrayList;

import model.Bill;

public interface IBillRepository {
	ArrayList<String> allBills();
	ArrayList<String> getBillFromByApartmentId(int id);
	void addBill(Bill bill);
}
