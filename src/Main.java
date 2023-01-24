import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import controller.AccountController;
import controller.ApartmentController;
import controller.BillController;
import controller.DecisionController;
import controller.DuesController;
import controller.ExpenseController;
import controller.FlatNoController;
import controller.MeetingController;
import controller.PersonController;
import controller.RoleController;
import controller.SubscriptionController;
import controller.UserController;
import model.Account;
import model.Apartment;
import model.Decision;
import model.Dues;
import model.Expense;
import model.FlatNo;
import model.Meeting;
import model.Person;
import model.Role;
import model.Subscription;
import repository.AccountRepository;
import repository.ApartmentRepository;
import repository.BillRepository;
import repository.DecisionRepository;
import repository.DuesRepository;
import repository.ExpenseRepository;
import repository.FlatNoRepository;
import repository.MeetingRepository;
import repository.PersonRepository;
import repository.RoleRepository;
import repository.SubscriptionRepository;
import repository.UserRepository;
import service.AccountService;
import service.ApartmentService;
import service.BillService;
import service.DecisionService;
import service.DuesService;
import service.ExpenseService;
import service.FlatNoService;
import service.MeetingService;
import service.PersonService;
import service.RoleService;
import service.SubscriptionService;
import service.UserService;
import utils.Menu;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserRepository userRepository = new UserRepository();
		UserService userService = new UserService(userRepository);
		UserController userController = new UserController(userService);
		
		
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
						Menu.createSubMenuSubscription();
						System.out.println("Choose Expense Process\n");
						subs1 = sub1s.nextInt();
						switch (subs1) {
						case 1: {
							String username, password;
							Scanner uScan = new Scanner(System.in);
							System.out.println("Please enter a username: ");
							username = uScan.nextLine();
							System.out.println("Please enter a password: ");
							password = uScan.nextLine();
							boolean result = userController.isManager(username, password);
							if(result) {
								subs.allSubscriptions();
								break;
							}else {
								System.out.println("Username or password is not correct!");
								break;
							}
						}
						case 2:{
							String username, password;
							Scanner uScan = new Scanner(System.in);
							System.out.println("Please enter a username: ");
							username = uScan.nextLine();
							System.out.println("Please enter a password: ");
							password = uScan.nextLine();
							
							boolean result = userController.isManager(username, password);
							System.out.println("result: " + result);
							if(result) {
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
							}else {
								System.out.println("Username or password is not correct!");
								break;
							}
						}
						case 3:{
							String username, password;
							Scanner uScan = new Scanner(System.in);
							System.out.println("Please enter a username: ");
							username = uScan.nextLine();
							System.out.println("Please enter a password: ");
							password = uScan.nextLine();
							boolean result = userController.isManager(username, password);
							if(result) {
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
							}else {
								System.out.println("username or password is not correct");
								break;
							}
						}
						case 4:{
							String username, password;
							Scanner uScan = new Scanner(System.in);
							System.out.println("Please enter a username: ");
							username = uScan.nextLine();
							System.out.println("Please enter a password: ");
							password = uScan.nextLine();
							boolean result = userController.isManager(username, password);
							if(result) {
								subs.allSubscriptions();
								int id;
								Scanner idScan = new Scanner(System.in);
								System.out.println("Please enter a id:");
								id = idScan.nextInt();
								subs.deleteSubscription(id);
								subs.allSubscriptions();
								break;
							}else {
								System.out.println("username or password is not correct");
								break;
							}
							
						}
						case 5:{
							String username, password;
							Scanner uScan = new Scanner(System.in);
							System.out.println("Please enter a username: ");
							username = uScan.nextLine();
							System.out.println("Please enter a password: ");
							password = uScan.nextLine();
							boolean result = userController.isManager(username, password);
							if(result) {
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
							}else {
								System.out.println("username or password is not correct");
								break;
							}
							   
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
				case 6:{

					MeetingRepository meetingRepository = new MeetingRepository();
					MeetingService meetingService = new MeetingService(meetingRepository);
					MeetingController mc = new MeetingController(meetingService);
					
					int meeting1;
					Scanner meeting1s = new Scanner(System.in);
					do {
						Menu.createSubMenuMeeting();
						System.out.println("Choose Meeting Process\n");
						meeting1 = meeting1s.nextInt();
						switch (meeting1) {
						case 1: {
							mc.allMeetings();
							break;
						}
						case 2:{
							Scanner txtScan = new Scanner(System.in);
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter apartment ID:");
							int apartment_id = idScan.nextInt();
							System.out.println("Please enter date:");
							String date=txtScan.next();
							Meeting meeting = new Meeting(apartment_id, date); 
							mc.addMeeting(meeting);
							break;
						}
						case 3:{
							mc.allMeetings();
							int id,apartment_id;
							String date;
							Scanner idScan = new Scanner(System.in);
							Scanner txtScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							System.out.println("Please enter a new apartment ID:");
							apartment_id = txtScan.nextInt();
							System.out.println("Please enter a new date:");
							date=txtScan.next();
							
							Meeting meeting = new Meeting(apartment_id, date); 
							mc.updateMeeting(id, meeting);
							mc.allMeetings();
							break;
						}
						case 4:{
							mc.allMeetings();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							mc.deleteMeeting(id);
							mc.allMeetings();
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + meeting1);
						}
					} while (meeting1 != 0);
				
				}
				case 7: {

					DecisionRepository decisionRepository = new DecisionRepository();
					DecisionService decisionService = new DecisionService(decisionRepository);
					DecisionController dc = new DecisionController(decisionService);
					
					int dsc1;
					Scanner dsc1s = new Scanner(System.in);
					do {
						Menu.createSubMenuDesicion();
						System.out.println("Choose Decision Process\n");
						dsc1 = dsc1s.nextInt();
						switch (dsc1) {
						case 1: {
							dc.allDecisions();
							break;
						}
						case 2:{
							Scanner txtScan = new Scanner(System.in);
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter meeting ID:");
							int meeting_id = idScan.nextInt();
							System.out.println("Please enter person ID:");
							int person_id= idScan.nextInt();
							System.out.println("Please enter description:");
							String description = txtScan.nextLine();
							System.out.println("Please enter confirm_reject:");
							String confirm_reject = txtScan.nextLine();
							Decision decision = new Decision(meeting_id, person_id, description, confirm_reject); 
							dc.addDecision(decision);
							break;
						}
						case 3:{
							dc.allDecisions();
							int id,meeting_id, person_id;
							String description, confirm_reject;
							Scanner idScan = new Scanner(System.in);
							Scanner txtScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							System.out.println("Please enter a new meeting ID:");
							meeting_id = idScan.nextInt();
							System.out.println("Please enter a new person ID:");
							person_id = idScan.nextInt();
							System.out.println("Please enter a new description:");
							description=txtScan.nextLine();
							System.out.println("Please enter a new confirm_reject:");
							confirm_reject=txtScan.nextLine();
							
							Decision decision= new Decision(meeting_id, person_id,description,confirm_reject); 
							dc.updateDecision(id, decision);
							dc.allDecisions();
							break;
						}
						case 4:{
							dc.allDecisions();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							dc.deleteDecision(id);
							dc.allDecisions();
							break;
						}
						case 5: {
							ArrayList<String> total = dc.getTotalVotesConfirmed_Rejected();
							for (int i=0; i<total.size(); i++) {
								System.out.println(total.get(i));
							}
							break;
						}
						case 6: {
							ArrayList<String> confirm_rejectedByPersons = dc.getVotesConfirmed_RejectedByPersons();
							for (int i=0; i<confirm_rejectedByPersons.size(); i++) {
								System.out.println(confirm_rejectedByPersons.get(i));
							}
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + dsc1);
						}
					} while (dsc1 != 0);
				
				
				}
				case 8:{
					FlatNoRepository flatNoRepository = new FlatNoRepository();
					FlatNoService flatNoService = new FlatNoService(flatNoRepository);
					FlatNoController flts = new FlatNoController(flatNoService);
					
					ApartmentRepository apartmentRepository = new ApartmentRepository();
					ApartmentService apartmentService = new ApartmentService(apartmentRepository);
					ApartmentController acc = new ApartmentController(apartmentService);
					int flt1;
					Scanner flt1s = new Scanner(System.in);
					do {
						Menu.createSubMenuFlatNo();
						System.out.println("Choose Expense Process\n");
						flt1 = flt1s.nextInt();
						switch (flt1) {
						case 1: {
							flts.allFlatNo();
							break;
						}
						case 2:{
							acc.allApartments();
							
							Scanner flt2s = new Scanner(System.in);
							
							int apartment_id;
							int number;
							int person_id;
							int flat_id;
							
							System.out.println("Which apartment would you like to add flatNo to? Please enter apartment id!");
							apartment_id = flt2s.nextInt();
							
							System.out.println("Can you enter a number?");
							number = flt2s.nextInt();
							
							System.out.println("Can you enter a person_id?");
							person_id = flt2s.nextInt();
							
							System.out.println("Can you enter a flat_id?");
							flat_id = flt2s.nextInt();
							
							System.out.println("test: apartment_id: " + apartment_id + " number: " + number + " person_id: " + person_id + " flat_id: " + flat_id + "\n");
							FlatNo flatNo = new FlatNo(apartment_id, number, person_id, flat_id);
							flts.addFlatNo(flatNo);
							break;
							
						}
						case 3:{
							flts.allFlatNo();
							
							int id;
							int apartment_id;
							int number;
							int person_id;
							int flat_id;
							
							Scanner flt3s = new Scanner(System.in);
							
							System.out.println("Please enter a id:");
							id = flt3s.nextInt();
							
							System.out.println("Please enter a apartment_id?");
							apartment_id = flt3s.nextInt();
							System.out.println("Please enter a number?");
							number = flt3s.nextInt();
							
							System.out.println("Please enter a person_id?");
							person_id = flt3s.nextInt();
							
							System.out.println("Please enter a flat_id?");
							flat_id = flt3s.nextInt();
							
							FlatNo flatNo = new FlatNo(apartment_id, number, person_id, flat_id); 
							flts.updateFlatNo(id, flatNo);
							flts.allFlatNo();
							break;
							
						}
						case 4:{
							flts.allFlatNo();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							flts.deleteFlatNo(id);
							flts.allFlatNo();
							break;
						}
						case 5:{
							   int id;
							   int flat_id;
	                            acc.allApartments();
	                            Scanner idScan = new Scanner(System.in);
	                            System.out.println("Please enter a apartment id");
	                            id = idScan.nextInt();
	                            System.out.println("Please enter a flat id");
	                            flat_id = idScan.nextInt();
	                            ArrayList<String> flatNo1 = flts.getFlatNoByApartmentIdAndFlatId(id, flat_id);
	                            for (String flatNo : flatNo1) {
	                                System.out.println(flatNo);
	                            }
	                            break;
						}
						case 6:{
							  
							   int number;
	                            Scanner idScan = new Scanner(System.in);
	                            System.out.println("Please enter a number");
	                            number= idScan.nextInt();
	                            
	                            ArrayList<String> flatNo1 = flts.getFlatNoByNumber(number);
	                            for (String flatNo : flatNo1) {
	                                System.out.println(flatNo);
	                            }
	                            break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + flt1);
						}
					} while (flt1 != 0);
				}
				case 9:{
					BillRepository billRepository = new BillRepository();
					BillService billService = new BillService(billRepository);
					BillController billc = new BillController(billService);
					
					ApartmentRepository apartmentRepository = new ApartmentRepository();
					ApartmentService apartmentService = new ApartmentService(apartmentRepository);
					ApartmentController acc = new ApartmentController(apartmentService);
					int bl1;
					Scanner flt1s = new Scanner(System.in);
					do {
						Menu.createSubMenuBill();;
						System.out.println("Choose Bill Process\n");
						bl1 = flt1s.nextInt();
						switch (bl1) {
						case 1: {
							ArrayList<String> bills = billc.allBills();
							for (String bill : bills) {
								System.out.println(bill);
							}
							break;
						}
						case 2:{
							
							break;
						}
						case 3:{
							acc.allApartments();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please choose a apartment");
							id = idScan.nextInt();
							ArrayList<String> bills = billc.getBillFromByApartmentId(id);
							for (String bill : bills) {
								System.out.println(bill);
							}
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + bl1);
						}
					} while (bl1 != 0);
				}
				case 10:{
					DuesRepository duesRepository = new DuesRepository();
					DuesService duesService = new DuesService(duesRepository);
					DuesController dues = new DuesController(duesService);
					
					ApartmentRepository apartmentRepository = new ApartmentRepository();
					ApartmentService apartmentService = new ApartmentService(apartmentRepository);
					ApartmentController acc = new ApartmentController(apartmentService);
					
					int dues1;
					Scanner dues1s = new Scanner(System.in);
					do {
						Menu.createSubMenuDues();
						System.out.println("Choose Expense Process\n");
						dues1 = dues1s.nextInt();
						switch (dues1) {
						case 1: {
							dues.allDues();
							break;
						}
						case 2:{
							Scanner txtScan = new Scanner(System.in);
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter number ID:");
							int number_id = idScan.nextInt();
							System.out.println("Please enter month:");
							String month= txtScan.nextLine();
							System.out.println("Please enter amount:");
							double cost = txtScan.nextDouble();
							Dues duess = new Dues(number_id, month, cost); 
							dues.addDues(duess);
							break;
						}
						case 3:{
							dues.allDues();
							Scanner idScan = new Scanner(System.in);
							Scanner txtScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							int id = idScan.nextInt();
							System.out.println("Please enter a new month:");
							String month= txtScan.nextLine();
							System.out.println("Please enter a new amount:");
							double cost = txtScan.nextDouble();
							
							Dues duess= new Dues( month, cost); 
							dues.updateDues(id, duess);
							dues.allDues();
							break;
						}
						case 4:{
							dues.allDues();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							dues.deleteDues(id);
							dues.allDues();
							break;
						}
						case 5:{
							    int id;
							    String month;
							    acc.allApartments();
	                            Scanner idScan = new Scanner(System.in);
	                            Scanner monthScan = new Scanner(System.in);
	                            System.out.println("Please enter a apartment id");
	                            id = idScan.nextInt();
	                            System.out.println("Please enter a date");
	                            month = monthScan.nextLine();
	                            ArrayList<String> duess = dues.getSumDuesbyApartmentAndMonth(id, month);
	                            for (String duess1 : duess) {
	                                System.out.println(duess1);
	                            }
	                            break;
						}
						
						default:
							throw new IllegalArgumentException("Unexpected value: " + dues1);
						}
					} while (dues1 != 0);
				}
				case 11:{
					AccountRepository accountRepository = new AccountRepository();
					AccountService accountService = new AccountService(accountRepository);
					AccountController account = new AccountController(accountService);
					
					ApartmentRepository apartmentRepository = new ApartmentRepository();
					ApartmentService apartmentService = new ApartmentService(apartmentRepository);
					ApartmentController acc = new ApartmentController(apartmentService);
					
					int accnt1;
					Scanner accnt1s = new Scanner(System.in);
					do {
						Menu.createSubMenuAccount();
						System.out.println("Choose Expense Process\n");
						accnt1 = accnt1s.nextInt();
						switch (accnt1) {
						case 1: {
							account.allAccounts();
							break;
						}
						case 2:{
							acc.allApartments();
							
							Scanner accnt2s = new Scanner(System.in);
						
							Double balance;
							int apartment_id;
							int bill_id;
							
							
							System.out.println("Can you enter a balance?");
							balance= accnt2s.nextDouble();
							
							System.out.println("Can you enter a apartment id?");
							apartment_id = accnt2s.nextInt();
							
							System.out.println("Can you enter a bill id?");
							bill_id = accnt2s.nextInt();
							
							System.out.println("test: balance: " + balance + " apartment_id: " + apartment_id + " bill_id: " + bill_id +"\n");
							Account account1 = new Account(balance, apartment_id, bill_id);
							account.addAccount(account1);
							break;
							
						}
						case 3:{
							account.allAccounts();
							
							int id;
							Double balance;
							int apartment_id;
							int bill_id;
							
							Scanner accnt3s = new Scanner(System.in);
							
							System.out.println("Please enter a id:");
							id =  accnt3s.nextInt();
							
							System.out.println("Please enter a balance?");
							balance =  accnt3s.nextDouble();
							
							System.out.println("Please enter a apartment_id?");
							apartment_id =  accnt3s.nextInt();
				
							System.out.println("Please enter a bill_id?");
							bill_id =  accnt3s.nextInt();
			
							Account account2 = new Account(balance, apartment_id, bill_id); 
							account.updateAccount(id, account2);
							account.allAccounts();
							break;
							
						}
						case 4:{
							account.allAccounts();
							int id;
							Scanner idScan = new Scanner(System.in);
							System.out.println("Please enter a id:");
							id = idScan.nextInt();
							account.deleteAccount(id);
							account.allAccounts();
							break;
						}
						
						case 5:{
							    int id;
							    acc.allApartments();
	                            Scanner intScan = new Scanner(System.in);
	                            System.out.println("Please enter a apartment id");
	                            id= intScan.nextInt();
	                            ArrayList<String> accounts = account.getAvailableBalance(id);
	                            for (String accounts1 : accounts) {
	                                System.out.println(accounts1);
	                            }
	                            break;
						}
						
						default:
							throw new IllegalArgumentException("Unexpected value: " + accnt1);
						}
					} while (accnt1 != 0);
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
