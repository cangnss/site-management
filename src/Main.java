import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ApartmentController;
import model.Apartment;
import repository.ApartmentRepository;
import service.ApartmentService;
import utils.Menu;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			
			int choose;
			do {
				Scanner sc1 = new Scanner(System.in);
				Menu.createMainMenu();
				System.out.println("Enter a process:");
				choose = sc1.nextInt();
				switch (choose) {
				case 1: {
					ApartmentRepository apartmentRepository = new ApartmentRepository();
					ApartmentService apartmentService = new ApartmentService(apartmentRepository);
					ApartmentController acc = new ApartmentController(apartmentService);
					
					int apt1;
					Scanner apt1s = new Scanner(System.in);
					do {
						Menu.createSubMenuApartment();
						System.out.println("Choose Apartment Process\n");
						apt1 = apt1s.nextInt();
						switch (apt1) {
						case 1: {
							acc.allApartments();
							break;
						}
						case 2:{
							Scanner txtScan = new Scanner(System.in);
							String apartmantName = txtScan.nextLine();
							Apartment apartment = new Apartment(apartmantName); 
							acc.addApartment(apartment);
							break;
						}
						case 3:{
							acc.allApartments();
							int id;
							String apartmantName;
							Scanner idScan = new Scanner(System.in);
							Scanner txtScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							System.out.println("Please enter a new apartment name:");
							apartmantName = txtScan.nextLine();
							Apartment apartment = new Apartment(apartmantName); 
							acc.updateApartment(id, apartment);
							acc.allApartments();
							break;
						}
						case 4:{
							acc.allApartments();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							acc.deleteApartment(id);
							acc.allApartments();
							break;
						}
						case 5:{
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							ArrayList<String> apartment = acc.getApartment(id);
							if (apartment != null) {
								for (String value : apartment) {
									System.out.println("Apartment name: " + value );
								}								
							}else {
								System.out.println("Apartment is not found!");
							}
							break;
						}
						case 6:{
							ArrayList<String> residents = acc.getResidentsInApartment();
							for (String resident : residents) {
								System.out.println(resident);
							}
							break;
						}
						case 7:{
							ArrayList<String> monthlyPayments = acc.getMonthlyPaymentByApartment();
							for (String payment : monthlyPayments) {
								System.out.println(payment);
							}
							break;
						}
						case 8:{
							int sum = acc.getSumAllMonthlyPayments();
							System.out.println("Total income from apartments: " + sum);
							break;
						}
						case 9:{
							
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + apt1);
						}
					} while (apt1 != 0);
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choose);
				}
				
			} while (choose != 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("hata");
		}
		
	}

}
