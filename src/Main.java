import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import controller.AccountController;
import controller.ApartmentController;
import controller.ItemController;
import controller.ResidentController;
import controller.RolesController;

public class Main {

	public static void main(String[] args) {
		try {
			Connection con = null;
			String conUrl = "jdbc:sqlserver://localhost:50674; databaseName=Project; integratedSecurity=true;";
			
			ApartmentController apartmentController = new ApartmentController();
			AccountController accountController = new AccountController();
			ResidentController residentController = new ResidentController();
			ItemController itemController = new ItemController();
			RolesController rolesController = new RolesController();
			con = DriverManager.getConnection(conUrl);

			Scanner scan = new Scanner(System.in);
			int choose=0;
			
			do {
				System.out.println("MENU\n1-Apartment Process\n2-Resident Process\n3-Account Process\n4-Item Process\n5-Roles");
				System.out.println("Please enter a choose:");
				choose = scan.nextInt();
				switch (choose) {
				case 1: {
					int ap1=0;
					Scanner apScan = new Scanner(System.in);
					do {
						System.out.println("1.List");
						System.out.println("2.Insert");
						System.out.println("3.Update");
						System.out.println("4.Delete");
						System.out.println("5.Exit");
						System.out.println("Select ");
						ap1 = apScan.nextInt();
						switch (ap1) {
						case 1: {
							apartmentController.List(con);
							break;
						}
						case 2: {
							apartmentController.Insert(con);
							break;
						}
						case 3:{
							apartmentController.Update(con);
							break;
						}
						case 4:{
							apartmentController.Delete(con);
							break;
						}
						case 5: {
							System.exit(1);
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + ap1);
						}
					} while (ap1 != 5);
				}
				case 2: { // Resident
					int rs1=0;
					Scanner rsScan = new Scanner(System.in);
					do {
						System.out.println("1.List");
						System.out.println("2.Insert");
						System.out.println("3.Update");
						System.out.println("4.Delete");
						System.out.println("5.Exit");
						System.out.println("Select ");
						rs1 = rsScan.nextInt();
						switch (rs1) {
						case 1: {
							residentController.List(con);
							break;
						}
						case 2: {
							residentController.Insert(con);
							break;
						}
						case 3:{
							residentController.Update(con);
							break;
						}
						case 4:{
							residentController.Delete(con);
							break;
						}
						case 5: {
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + rs1);
						}
					} while (rs1 != 5);
				}
				case 3: { // Account
					int acc1=0;
					Scanner accScan = new Scanner(System.in);
					do {
						System.out.println("1.List");
						System.out.println("2.Insert");
						System.out.println("3.Update");
						System.out.println("4.Delete");
						System.out.println("5.Exit");
						System.out.println("Select ");
						acc1 = accScan.nextInt();
						switch (acc1) {
						case 1: {
							accountController.List(con);
							break;
						}
						case 2: {
							accountController.Insert(con);
							break;
						}
						case 3:{
							accountController.Update(con);
							break;
						}
						case 4:{
							accountController.Delete(con);
							break;
						}
						case 5: {
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + acc1);
						}
					} while (acc1 != 5);
				}
				case 4: { // Item
					int it1=0;
					Scanner itScan = new Scanner(System.in);
					do {
						System.out.println("1.List");
						System.out.println("2.Insert");
						System.out.println("3.Update");
						System.out.println("4.Delete");
						System.out.println("5.Exit");
						System.out.println("Select ");
						it1 = itScan.nextInt();
						switch (it1) {
						case 1: {
							itemController.List(con);
							break;
						}
						case 2: {
							itemController.Insert(con);
							break;
						}
						case 3:{
							itemController.Update(con);
							break;
						}
						case 4:{
							itemController.Delete(con);
							break;
						}
						case 5: {
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + it1);
						}
					} while (it1 != 5);
				}
				case 5: { // Roles
					int rl1=0;
					Scanner rlScan = new Scanner(System.in);
					do {
						System.out.println("1.List");
						System.out.println("2.Insert");
						System.out.println("3.Update");
						System.out.println("4.Delete");
						System.out.println("5.Exit");
						System.out.println("Select ");
						rl1 = rlScan.nextInt();
						switch (rl1) {
						case 1: {
							rolesController.List(con);
							break;
						}
						case 2: {
							rolesController.Insert(con);
							break;
						}
						case 3:{
							rolesController.Update(con);
							break;
						}
						case 4:{
							rolesController.Delete(con);
							break;
						}
						case 5: {
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + rl1);
						}
					} while (rl1 != 5);
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + scan);
				}
			} while (choose != 0);
			

		} catch (Exception e) {
			System.out.println("Failed...");
			e.printStackTrace();
		}
	}

}
