import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ApartmentController;
import controller.ExpenseController;
import controller.PersonController;
import controller.RoleController;
import controller.SubscriptionController;
import model.Apartment;
import model.Expense;
import model.Person;
import model.Role;
import model.Subscription;
import repository.ApartmentRepository;
import repository.ExpenseRepository;
import repository.PersonRepository;
import repository.RoleRepository;
import repository.SubscriptionRepository;
import service.ApartmentService;
import service.ExpenseService;
import service.PersonService;
import service.RoleService;
import service.SubscriptionService;
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
				case 2:{
					PersonRepository personRepository = new PersonRepository();
					PersonService personService = new PersonService(personRepository);
					PersonController pc = new PersonController(personService);
					
					int person1;
					Scanner person1s = new Scanner(System.in);
					do {
						Menu.createSubMenuPerson();
						System.out.println("Choose Person Process\n");
						person1 = person1s.nextInt();
						switch (person1) {
						case 1: {
							pc.allPerson();
							break;
						}
						case 2:{
							Scanner txtScan = new Scanner(System.in);
							System.out.println("Please enter first name:");
							String firstName = txtScan.nextLine();
							System.out.println("Please enter last name:");
							String lastName = txtScan.nextLine();
							System.out.println("Please enter birthday:");
							String birthday = txtScan.nextLine();
							//SimpleDateFormat formatter = new SimpleDateFormat();
							//Date birthday = (Date) formatter.parse(birthday2);
							System.out.println("Please enter gender:");
							String gender = txtScan.nextLine();
							System.out.println("Please enter gmail:");
							String gmail = txtScan.nextLine();
							System.out.println("Please enter apartment ID:");
							int apartment_id = txtScan.nextInt();
							Person person = new Person(firstName, lastName, birthday,gender, gmail,apartment_id); 
							pc.addPerson(person);
							break;
						}
						case 3:{
							pc.allPerson();
							int id, apartment_id;
							String firstName, lastName, gmail;
							Scanner idScan = new Scanner(System.in);
							Scanner txtScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							System.out.println("Please enter a new first name:");
							firstName = txtScan.nextLine();
							System.out.println("Please enter a new last name:");
							lastName = txtScan.nextLine();
							System.out.println("Please enter a new gmail:");
							gmail = txtScan.nextLine();
							System.out.println("Please enter a new apartment ID:");
							apartment_id = idScan.nextInt();
							Person person = new Person(firstName, lastName, gmail, apartment_id); 
							pc.updatePerson(id, person);
							pc.allPerson();
							break;
						}
						case 4:{
							pc.allPerson();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							pc.deletePerson(id);
							pc.allPerson();
							break;
						}
						case 5:{
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							ArrayList<String> person = pc.getPerson(id);
							if (person!= null) {
								for (String value : person) {
									System.out.println("Full Name: " + value );
								}								
							}else {
								System.out.println("Person is not found!");
							}
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + person1);
						}
					} while (person1 != 0);
				}
				case 3:{
					RoleRepository roleRepository = new RoleRepository();
					RoleService roleService = new RoleService(roleRepository);
					RoleController rc = new RoleController(roleService);
					
					int role1;
					Scanner role1s = new Scanner(System.in);
					do {
						Menu.createSubMenuRole();
						System.out.println("Choose Role Process\n");
						role1 = role1s.nextInt();
						switch (role1) {
						case 1: {
							rc.allRole();
							break;
						}
						case 2:{
							Scanner txtScan = new Scanner(System.in);
							System.out.println("Please enter type:");
							String type = txtScan.nextLine();
							System.out.println("Please enter person ID:");
							int person_id = txtScan.nextInt();
							System.out.println("Please enter apartment ID:");
							int apartment_id = txtScan.nextInt();
							Role role = new Role(type, person_id, apartment_id); 
							rc.addRole(role);
							break;
						}
						case 3:{
							rc.allRole();
							int id,person_id, apartment_id;
							String type;
							Scanner idScan = new Scanner(System.in);
							Scanner txtScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							System.out.println("Please enter a new type:");
							type = txtScan.nextLine();
							System.out.println("Please enter a new person ID:");
							person_id = txtScan.nextInt();
							System.out.println("Please enter a new apartment ID:");
							apartment_id = idScan.nextInt();
							Role role = new Role(type, person_id, apartment_id); 
							rc.updateRole(id, role);
							rc.allRole();
							break;
						}
						case 4:{
							rc.allRole();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							rc.deleteRole(id);
							rc.allRole();
							break;
						}
						case 5:{
							ArrayList<String> managers = rc.getManagerInApartment();
							for (int i=0; i<managers.size(); i++) {
								System.out.println(managers.get(i));
							}
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + role1);
						}
					} while (role1 != 0);
				}
				case 4:{
					SubscriptionRepository subscriptionRepository = new SubscriptionRepository();
					SubscriptionService subscriptionService = new SubscriptionService(subscriptionRepository);
					SubscriptionController subs = new SubscriptionController(subscriptionService);
					
					ApartmentRepository apartmentRepository = new ApartmentRepository();
					ApartmentService apartmentService = new ApartmentService(apartmentRepository);
					ApartmentController acc = new ApartmentController(apartmentService);
					
					int subs1;
					Scanner sub1s = new Scanner(System.in);
					do {
						Menu.createSubMenuExpense();
						System.out.println("Choose Expense Process\n");
						subs1 = sub1s.nextInt();
						switch (subs1) {
						case 1: {
							subs.allSubscriptions();
							break;
						}
						case 2:{
							acc.allApartments();
							
							Scanner sub21s = new Scanner(System.in);
							Scanner sub22s= new Scanner(System.in);
							
							int apartment_id;
							String service;
							String period;
							double cost;
							
							System.out.println("Which apartment would you like to add subscription to? Please enter apartment id!");
							apartment_id = sub21s.nextInt();
							
							System.out.println("Can you enter a service?");
							service = sub22s.nextLine();
							System.out.println("Can you enter a period?");
							period = sub22s.nextLine();
							
							System.out.println("Can you enter a cost?");
							cost = sub21s.nextDouble();
							
							System.out.println("test: apartment_id: " + apartment_id + " service: " + service + " period: " + period + " cost: " + cost + "\n");
							Subscription subscription = new Subscription(apartment_id, service, period, cost);
							subs.addSubscription (subscription );
							break;
							
						}
						case 3:{
							subs.allSubscriptions();
							int id;
							String service;
							String period;
							double cost;
							Scanner sub31s = new Scanner(System.in);
							Scanner sub32s = new Scanner(System.in);
							
							System.out.println("Please enter a id:");
							id = sub31s.nextInt();
							
							System.out.println("Please enter a service:");
							service = sub32s.nextLine();
							
							System.out.println("Please enter a period:");
							period = sub32s.nextLine();
					
							System.out.println("Please enter a new cost:");
							cost = sub31s.nextDouble();
							
							Subscription subscription = new Subscription(id,service,period, cost); 
							subs.updateSubscription(id, subscription);
							subs.allSubscriptions();
							break;
							
						}
						case 4:{
							subs.allSubscriptions();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							subs.deleteSubscription(id);
							subs.allSubscriptions();
							break;
						}
						case 5:{
							   int id;
	                            acc.allApartments();
	                            Scanner idScan = new Scanner(System.in);
	                            System.out.println("Please enter a apartment id");
	                            id = idScan.nextInt();
	                            ArrayList<String> subscriptions = subs.getSubscriptionByApartmentId(id);
	                            for (String subscription : subscriptions) {
	                                System.out.println(subscription);
	                            }
	                            break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + subs1);
						}
					} while (subs1 != 0);
				}
				case 5:{
					ExpenseRepository expenseRepository = new ExpenseRepository();
					ExpenseService expenseService = new ExpenseService(expenseRepository);
					ExpenseController exps = new ExpenseController(expenseService);
					
					ApartmentRepository apartmentRepository = new ApartmentRepository();
					ApartmentService apartmentService = new ApartmentService(apartmentRepository);
					ApartmentController acc = new ApartmentController(apartmentService);
					
					int exp1;
					Scanner exp1s = new Scanner(System.in);
					do {
						Menu.createSubMenuExpense();
						System.out.println("Choose Expense Process\n");
						exp1 = exp1s.nextInt();
						switch (exp1) {
						case 1: {
							exps.allExpenses();
							break;
						}
						case 2:{
							acc.allApartments();
							
							Scanner exp2s = new Scanner(System.in);
							Scanner exp3s = new Scanner(System.in);
							
							int apartment_id;
							String description;
							double cost;
							
							System.out.println("Which apartment would you like to add expense to? Please enter apartment id!");
							apartment_id = exp2s.nextInt();
							
							System.out.println("Can you enter a description?");
							description = exp3s.nextLine();
							
							System.out.println("Can you enter a cost?");
							cost = exp2s.nextDouble();
							
							System.out.println("test: apartment_id: " + apartment_id + " description: " + description + " cost: " + cost + "\n");
							Expense expense = new Expense(apartment_id, description, cost);
							exps.addExpense(expense);
							break;
							
						}
						case 3:{
							exps.allExpenses();
							int id;
							String description;
							double cost;
							Scanner exp31s = new Scanner(System.in);
							Scanner exp32s = new Scanner(System.in);
							
							System.out.println("Please enter a id:");
							id = exp31s.nextInt();
							
							System.out.println("Please enter a description:");
							description = exp32s.nextLine();
							
							System.out.println("Please enter a new cost:");
							cost = exp31s.nextDouble();
							
							Expense expense = new Expense(description, cost); 
							exps.updateExpense(id, expense);
							exps.allExpenses();
							break;
							
						}
						case 4:{
							exps.allExpenses();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							exps.deleteExpense(id);
							exps.allExpenses();
							break;
						}
						case 5:{
							int id;
							acc.allApartments();
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a apartment id");
							id = idScan.nextInt();
							ArrayList<String> expenses = exps.getExpenseByApartmentId(id);
							for (String expense : expenses) {
								System.out.println(expense);
							}
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + exp1);
						}
					} while (exp1 != 0);
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
