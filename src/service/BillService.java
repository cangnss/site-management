package service;

import java.util.ArrayList;

import model.Bill;
import repository.BillRepository;

public class BillService {
	private final BillRepository billRepository;
	
	public BillService(BillRepository billRepository) {
		this.billRepository = billRepository;
	}
	
	public ArrayList<String> allBills(){
		return billRepository.allBills();
	}
	
	public void addBill(Bill bill) {
		billRepository.addBill(bill);
	}
	
	public ArrayList<String> getBillFromByApartmentId(int id){
		return billRepository.getBillFromByApartmentId(id);
	}
}
