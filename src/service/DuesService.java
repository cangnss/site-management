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

    
}
