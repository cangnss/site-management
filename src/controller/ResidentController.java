package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ResidentController {
	public static void List(Connection con) {
		try {
			String query = "SELECT * FROM Resident";
			PreparedStatement prepStmt = con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1) + " firstName: " + rs.getString(2) + " lastName: "
						+ rs.getString(3) + " birthday: " + rs.getDate(4) + " age: " + rs.getInt(5) + " fullName: "
						+ rs.getString(6) + " gender: " + rs.getString(7) + " apartmentId: " + rs.getInt(8));
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
			System.out.println("Enter resident id for delete: ");
			int id = scan.nextInt();

			String query = ("DELETE Resident WHERE id=?");
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
			System.out.println("Enter resident id for update: ");
			int id = scan.nextInt();
			System.out.println("Enter first name : ");
			String firstName = scan2.next();
			System.out.println("Enter last name : ");
			String lastName = scan2.next();
			System.out.println("Enter birthday : ");
			String birthday = scan2.next();

			String query = ("UPDATE Resident SET firstName=?, lastName=?, birthday=? WHERE id=?");
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setString(1, firstName);
			prepStmt.setString(2, lastName);
			prepStmt.setString(3, birthday);
			prepStmt.setInt(4, id);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Updated!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void Insert(Connection con) {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Enter resident id: ");
		int id = scan.nextInt();
		System.out.println("Enter first name: ");
		String firstName = scan2.next();
		System.out.println("Enter lastname name: ");
		String lastName = scan2.next();
		System.out.println("Enter birthday: ");
		String birthday = scan2.next();
		System.out.println("Enter gender: ");
		String gender = scan2.next();
		System.out.println("Enter apartment id: ");
		int apartmentId = scan.nextInt();

		try {
			String insert = "set identity_insert Resident on INSERT INTO Resident(id,firstName,lastName,birthday,gender,apartmentId) VALUES(?,?,?,?,?,?)";
			PreparedStatement prepStmt = con.prepareStatement(insert);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, firstName);
			prepStmt.setString(3, lastName);
			prepStmt.setString(4, birthday);
			prepStmt.setString(5, gender);
			prepStmt.setInt(6, apartmentId);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Inserted!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
