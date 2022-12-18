package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ItemController {
	public static void List(Connection con) {
		try {
			String query = "SELECT * FROM Item";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("id: " + rs.getInt(1) + " Item Name: " + rs.getString(2) + " Price: " + rs.getDouble(3) + " apartmentId: " + rs.getInt(4) );
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
			System.out.println("Enter Item id for delete: ");
			int id=scan.nextInt();
			
			String query=("DELETE Item WHERE id=?");
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
			System.out.println("Enter item id for update: ");
			int id=scan.nextInt();
			System.out.println("Enter new item name: ");
			String itemName=scan2.next();
			System.out.println("Enter price: ");
			double price=scan.nextDouble();
			System.out.println("Enter apartment id: ");
			int apartmentId=scan.nextInt();
			
			String query=("UPDATE Item SET itemName=?, price=?, apartmentId=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setString(1, itemName);
			prepStmt.setDouble(2, price);
			prepStmt.setInt(3, apartmentId);
			prepStmt.setInt(4, id);
			
			prepStmt.executeUpdate();
			prepStmt.close();
			
			System.out.println("Updated!");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void Insert(Connection con) {
		Scanner scan=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		System.out.println("Enter item id: ");
		int id=scan.nextInt();
		System.out.println("Item name: ");
		String itemName=scan2.next();
		System.out.println("Enter price: ");
		double price=scan.nextDouble();
		System.out.println("Enter apartment id: ");
		int apartmentId=scan.nextInt();
		try {
			String insert="set identity_insert Item on INSERT INTO Item(id,itemName,price,apartmentId) VALUES(?,?,?,?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setInt(1,id);
			prepStmt.setString(2, itemName);
			prepStmt.setDouble(3,price);
			prepStmt.setInt(4,apartmentId);
			prepStmt.executeUpdate();
			prepStmt.close();
			
			System.out.println("Inserted!");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
