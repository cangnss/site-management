package controller;

import java.util.ArrayList;
import java.util.List;

import model.Apartment;
import service.ApartmentService;

public class ApartmentController {
	private final ApartmentService apartmentService;
	
	public ApartmentController(ApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}
	
	public List<Apartment> allApartments(){
		return apartmentService.allApartments();
	}
	
	public void addApartment(Apartment apartment) {
		apartmentService.addApartment(apartment);
	}
	
	public void updateApartment(int id, Apartment apartment) {
		apartmentService.updateApartment(id, apartment);
	}
	
	public void deleteApartment(int id) {
		apartmentService.deleteApartment(id);
	}
	
	public ArrayList<String> getApartment(int id){
		return apartmentService.getApartment(id);
	}
	
	public ArrayList<String> getResidentsInApartment(){
		return apartmentService.getResidentsInApartment();
	}
	
	public ArrayList<String> getMonthlyPaymentByApartment(){
		return apartmentService.getMonthlyPaymentByApartment();
	}
	
	public int getSumAllMonthlyPayments(){
		return apartmentService.getSumAllMonthlyPayments();
	}
}
