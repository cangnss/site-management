package repository;

import java.util.ArrayList;
import java.util.List;

import model.Apartment;

public interface IApartmentRepository {
	List<Apartment> allApartments();
	ArrayList<String> getApartment(int id);
	ArrayList<String> getResidentInApartment();
	ArrayList<String> getMonthlyPaymentByApartment();
	int getSumAllMonthlyPayments();
	void addApartment(Apartment apartment);
	void updateApartment(int id, Apartment apartment);
	void deleteApartment(int id);
	
}
