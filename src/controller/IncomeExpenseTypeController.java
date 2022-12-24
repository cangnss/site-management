package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class IncomeExpenseTypeController {
	public static void List(Connection con) {
		try {
			String query = "SELECT * FROM Income_Expense_Type";
			PreparedStatement prepStmt = con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1) + " Type: " + rs.getString(2) + " Item id:: " + rs.getInt(3)
						+ " expense id: " + rs.getInt(4));
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
			System.out.println("Enter income expense type id for delete: ");
			int id = scan.nextInt();

			String query = ("DELETE Income_Expense_Type WHERE id=?");
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
			System.out.println("Enter income expense type id for update: ");
			int id = scan.nextInt();
			System.out.println("Enter type : ");
			String type = scan2.next();
			System.out.println("Enter item id : ");
			int itemId = scan.nextInt();
			System.out.println("Enter expenseid : ");
			int expenseId = scan.nextInt();

			String query = ("UPDATE Income_Expense_Type SET type=?, itemId=?, expenseId=? WHERE id=?");
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setString(1, type);
			prepStmt.setInt(2, itemId);
			prepStmt.setInt(3, expenseId);
			prepStmt.setInt(4, id);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Updated IncomeExpenseType!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void Insert(Connection con) {
		try {
			String insert = "INSERT INTO Income_Expense_Type(type, itemId, expenseId) VALUES(?,?,?)";
			PreparedStatement prepStmt = con.prepareStatement(insert);
			prepStmt.setInt(1, 0);
			prepStmt.setInt(2, 19);
			prepStmt.setInt(3, 2);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Inserted IncomeExpenseType!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
