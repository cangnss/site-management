package controller;

import java.util.ArrayList;
import java.util.List;

import model.Dues;

import service.DuesService;

public class DuesController {
	private final DuesService duesService;

	public DuesController(DuesService duesService) {
		this.duesService = duesService;
	}
	public List<Dues> allDues(){
		return duesService.allDues();
	}
	public ArrayList<String> getSumDuesbyApartmentAndMonth(int id, String date){
		return duesService.getSumDuesbyApartmentAndMonth(id, date);
	}
	public void addDues(Dues dues) {
		duesService.addDues(dues);
	}
	public void updateDues(int id, Dues dues) {
		duesService.updateDues(id, dues);
	}
	public void deleteDues(int id) {
		duesService.deleteDues(id);
	}

}
