package service;

import java.util.ArrayList;
import java.util.List;

import model.Apartment;
import repository.ApartmentRepository;

public class ApartmentService {
	private final ApartmentRepository apartmentRepository;
	
	public ApartmentService(ApartmentRepository apartmentRepository) {
		this.apartmentRepository = apartmentRepository;
	}
	
	public List<Apartment> allApartments(){
		return apartmentRepository.allApartments();
	}
	
	public void addApartment(Apartment apartment) {
		apartmentRepository.addApartment(apartment);
	}
	
	public void updateApartment(int id, Apartment apartment) {
		apartmentRepository.updateApartment(id, apartment);
	}
	
	public void deleteApartment(int id) {
		apartmentRepository.deleteApartment(id);
	}
	
	public ArrayList<String> getApartment(int id){
		return apartmentRepository.getApartment(id);
	}
	
	public ArrayList<String> getResidentsInApartment(){
		return apartmentRepository.getResidentInApartment();
	}
	
	public ArrayList<String> getMonthlyPaymentByApartment(){
		return apartmentRepository.getMonthlyPaymentByApartment();
	}
	
	public int getSumAllMonthlyPayments(){
		return apartmentRepository.getSumAllMonthlyPayments();
	}
	
}
