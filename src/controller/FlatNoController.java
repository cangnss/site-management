package controller;

import java.util.ArrayList;
import java.util.List;

import model.FlatNo;
import service.FlatNoService;

public class FlatNoController {
	private final FlatNoService flatNoService;

	public FlatNoController(FlatNoService flatNoService) {
		this.flatNoService = flatNoService;
	}
	public List<String> allFlatNo(){
		return flatNoService.allFlatNo();
	}
	public ArrayList<String> getFlatNoByApartmentIdAndFlatId(int id , int flat_id){
		return flatNoService.getFlatNoByApartmentIdAndFlatId(id, flat_id);
	}
	public ArrayList<String> getFlatNoByNumber(int number){
		return flatNoService.getFlatNoByNumber(number);
	}
	public void addFlatNo(FlatNo flatNo) {
		flatNoService.addFlatNo(flatNo);
	}
	public void updateFlatNo(int id, FlatNo flatNo) {
		flatNoService.updateFlatNo(id, flatNo);
	}
	public void deleteFlatNo(int id) {
		flatNoService.deleteFlatNo(id);
	}
}
