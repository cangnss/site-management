package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ApartmentController {
	
	public static void List(Connection con) {
		try {
			String query = "SELECT * FROM Apartment";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("id: " + rs.getInt(1) + " Apartment Name: " + rs.getString(2) );
			}
			prepStmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void Delete(Connection con) {
		Scanner scan=new Scanner(System.in);
		try {
			List(con);
			System.out.println("Enter apartment id for delete: ");
			int id=scan.nextInt();
			
			String query=("DELETE Apartment WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			
			System.out.println("Deleted!");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void Update(Connection con) {
		Scanner scan=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		try {
			List(con);
			System.out.println("Enter apartment id for update: ");
			int id=scan.nextInt();
			//System.out.println("Enter new apartment id : ");
			//int newId=scan.nextInt();
			System.out.println("Enter new apartment name: ");
			String apartmantName=scan2.next();
			
			String query=("UPDATE Apartment SET apartmantName=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setString(1, apartmantName);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			
			System.out.println("Updated!");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void Insert(Connection con) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter apartment id: ");
		int id=scan.nextInt();
		System.out.println("Enter apartmnet name: ");
		String apartmantName=scan.next();
		try {
			String insert="set identity_insert Apartment on INSERT INTO Apartment(id,apartmantName) VALUES(?,?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setInt(1,id);
			prepStmt.setString(2, apartmantName);
			prepStmt.executeUpdate();
			prepStmt.close();
			
			System.out.println("Inserted!");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
