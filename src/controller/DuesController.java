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

}
