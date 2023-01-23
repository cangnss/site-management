package controller;

import java.util.ArrayList;

import model.Bill;
import repository.BillRepository;
import service.BillService;

public class BillController {
	private final BillService billService;
	public BillController(BillService billService) {
		this.billService = billService;
	}
	
	public ArrayList<String> allBills(){
		return billService.allBills();
	}
	
	public void addBill(Bill bill) {
		billService.addBill(bill);
	}
	
	public ArrayList<String> getBillFromByApartmentId(int id){
		return billService.getBillFromByApartmentId(id);
	}
}
