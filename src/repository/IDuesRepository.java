package repository;

import java.util.ArrayList;
import java.util.List;

import model.Dues;

public interface IDuesRepository {
	List<Dues> allDues();
	ArrayList<String> getSumDuesbyApartmentAndMonth(int id, String date);

}
