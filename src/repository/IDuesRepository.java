package repository;

import java.util.ArrayList;
import java.util.List;

import model.Dues;

public interface IDuesRepository {
	List<Dues> allDues();
	ArrayList<String> getSumDuesbyApartmentAndMonth(int id, String date);
	void addDues(Dues dues);
	void updateDues(int id, Dues dues);
	void deleteDues(int id);

}
