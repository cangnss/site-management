package service;

import java.util.ArrayList;
import java.util.List;

import model.Dues;
import repository.DuesRepository;

public class DuesService {
	private final DuesRepository duesRepository;

	public DuesService(DuesRepository duesRepository) {
		
		this.duesRepository = duesRepository;
	}
	public List<Dues> allDues(){
		return duesRepository.allDues();
	}
	public ArrayList<String> getSumDuesbyApartmentAndMonth(int id, String date){
		return duesRepository.getSumDuesbyApartmentAndMonth(id, date);
	}
	public void addDues(Dues dues) {
		duesRepository.addDues(dues);
	}
	public void updateDues(int id, Dues dues) {
		duesRepository.updateDues(id, dues);
	}
	public void deleteDues(int id) {
		duesRepository.deleteDues(id);
	}

    
}
