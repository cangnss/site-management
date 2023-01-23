package repository;

import java.util.ArrayList;
import java.util.List;

import model.FlatNo;

public interface IFlatNoRepository {
	List<String> allFlatNo();
	ArrayList<String> getFlatNoByApartmentIdAndFlatId(int id, int flat_id);
	ArrayList<String> getFlatNoByNumber(int number);
	void addFlatNo(FlatNo flatNo);
	void updateFlatNo(int id, FlatNo flatNo);
	void deleteFlatNo(int id);
}
