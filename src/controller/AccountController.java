package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AccountController {
	public static void List(Connection con) {
		try {
			String query = "SELECT * FROM Account";
			PreparedStatement prepStmt = con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1) + " Account Name: " + rs.getString(2) + " Apartment id: "
						+ rs.getInt(3) + " Resident id: " + rs.getInt(4) + " Montly payment: " + rs.getDouble(5));
			}
			prepStmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void Delete(Connection con) {
		Scanner scan = new Scanner(System.in);
		try {
			List(con);
			System.out.println("Enter account id for delete: ");
			int id = scan.nextInt();

			String query = ("DELETE Account WHERE id=?");
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Deleted!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void Update(Connection con) {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		try {
			List(con);
			System.out.println("Enter Account id for update: ");
			int id = scan.nextInt();
			System.out.println("Enter account name: ");
			String accountName = scan2.next();
			System.out.println("Enter apartment id: ");
			int apartmentId = scan.nextInt();
			System.out.println("Enter resident id: ");
			int residentId = scan.nextInt();
			System.out.println("Enter monthly payment: ");
			double monthlyPayment = scan.nextDouble();

			String query = ("UPDATE Account SET accountName=?, apartmentId=?, residentId=?,monthlyPayment=? WHERE id=?");
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setString(1, accountName);
			prepStmt.setInt(2, apartmentId);
			prepStmt.setInt(3, residentId);
			prepStmt.setDouble(4, monthlyPayment);
			prepStmt.setInt(5, id);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Updated Account!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void Insert(Connection con) {
		try {
			String insert = "INSERT INTO Account(accountName,apartmentId,residentId,monthlyPayment) VALUES(?,?,?,?,?)";
			PreparedStatement prepStmt = con.prepareStatement(insert);
			prepStmt.setString(1, "K Apartment's Account");
			prepStmt.setInt(2, 7);
			prepStmt.setInt(3, 27);
			prepStmt.setDouble(4, 325.50);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Inserted Account!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
