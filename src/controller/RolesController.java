package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RolesController {
	public static void List(Connection con) {
		try {
			String query = "SELECT * FROM Roles";
			PreparedStatement prepStmt = con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1) + " Role: " + rs.getString(2) + " Resident id: " + rs.getInt(3)
						+ " Apartment id: " + rs.getInt(4));
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
			System.out.println("Enter role id for delete: ");
			int id = scan.nextInt();

			String query = ("DELETE Roles WHERE id=?");
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
			System.out.println("Enter role id for update: ");
			int id = scan.nextInt();
			System.out.println("Enter role: ");
			String role = scan2.next();
			System.out.println("Enter resident id: ");
			int residentId = scan.nextInt();
			System.out.println("Enter role apartment id: ");
			int apartmentId = scan.nextInt();

			String query = ("UPDATE Roles SET role=?,residentId=?, apartmentId=? WHERE id=?");
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setString(1, role);
			prepStmt.setInt(2, residentId);
			prepStmt.setInt(3, apartmentId);
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
		System.out.println("Enter role id: ");
		int id = scan.nextInt();
		System.out.println("Enter role name: ");
		String role = scan2.next();
		System.out.println("Enter resident id: ");
		int residentId = scan.nextInt();
		System.out.println("Enter apartment id: ");
		int apartmentId = scan.nextInt();
		try {
			String insert = "set identity_insert Roles on INSERT INTO Roles(id,role,residentId,apartmentId) VALUES(?,?,?,?)";
			PreparedStatement prepStmt = con.prepareStatement(insert);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, role);
			prepStmt.setInt(3, residentId);
			prepStmt.setInt(4, apartmentId);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Inserted!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
