package utils;

public class Menu {
	
	public static void createMainMenu() {
		System.out.println("---------------");
		System.out.println("1 - Apartment Process");
		System.out.println("2 - Resident Process");
		System.out.println("3 - Account Process");
		System.out.println("4 - Item Process");
		System.out.println("5 - Expense Process");
		System.out.println("6 - Roles Process");
		System.out.println("0 - Exit");
		System.out.println("---------------");
	}
	
	public static void createSubMenuApartment() {
		System.out.println("---------------");
		System.out.println("1 - List");
		System.out.println("2 - Add");
		System.out.println("3 - Update");
		System.out.println("4 - Delete");
		System.out.println("5 - Get Apartment");
		System.out.println("6 - Get Resident In Apartment");
		System.out.println("7 - Get Monthly Payment From Apartment");
		System.out.println("8 - Total Income From Apartments");
		System.out.println("0 - Exit");
		System.out.println("---------------");
	}
	
	
	public static void createSubMenuExpense() {
		System.out.println("---------------");
		System.out.println("1 - List");
		System.out.println("2 - Add");
		System.out.println("3 - Update");
		System.out.println("4 - Delete");
		System.out.println("5 - Get Expense");
		System.out.println("0 - Exit");
		System.out.println("---------------");
	}
	
	public static void createSubMenuAccount() {
		System.out.println("---------------");
		System.out.println("1 - List");
		System.out.println("2 - Add");
		System.out.println("3 - Update");
		System.out.println("4 - Delete");
		System.out.println("5 - List");
	}
}
