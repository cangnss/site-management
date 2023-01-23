package service;

import java.util.ArrayList;
import java.util.List;

import model.FlatNo;
import repository.FlatNoRepository;

public class FlatNoService {
	private final FlatNoRepository flatNoRepository;

	public FlatNoService(FlatNoRepository flatNoRepository) {
		this.flatNoRepository = flatNoRepository;
	}
	public List<String> allFlatNo(){
		return flatNoRepository.allFlatNo();
	}
	public ArrayList<String> getFlatNoByApartmentIdAndFlatId(int id, int flat_id){
		return flatNoRepository.getFlatNoByApartmentIdAndFlatId(id, flat_id);
	}
	public ArrayList<String> getFlatNoByNumber(int number){
		return flatNoRepository.getFlatNoByNumber(number);
	}
	public void addFlatNo(FlatNo flatNo) {
		flatNoRepository.addFlatNo(flatNo);
	}
	public void updateFlatNo(int id, FlatNo flatNo) {
		flatNoRepository.updateFlatNo(id, flatNo);
	}
	public void deleteFlatNo(int id) {
		flatNoRepository.deleteFlatNo(id);
	}
	
	
}
