package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class IncomeExpenseController {
	public static void List(Connection con) {
		try {
			String query = "SELECT * FROM Income_Expense";
			PreparedStatement prepStmt = con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1) + " Apartment id: " + rs.getString(2) + " Available Balance: "
						+ rs.getInt(3));
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
			System.out.println("Enter income expense id for delete: ");
			int id = scan.nextInt();

			String query = ("DELETE Income_Expense WHERE id=?");
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Deleted Income Expense!");
			List(con);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void Update(Connection con) {
		Scanner scan = new Scanner(System.in);

		try {
			List(con);
			System.out.println("Enter income expense id for update: ");
			int id = scan.nextInt();
			System.out.println("Enter apartment id : ");
			int apartmentId = scan.nextInt();

			String query = ("UPDATE Income_Expense SET apartmentId=? WHERE id=?");
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setInt(1, apartmentId);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Updated Income Expense!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void Insert(Connection con) {
		try {
			String insert = "INSERT INTO Income_Expense(apartmentId,availableBalance) VALUES(?,?)";
			PreparedStatement prepStmt = con.prepareStatement(insert);
			prepStmt.setInt(1, 5);
			prepStmt.setInt(2, 0); // hesaplanacak
			prepStmt.executeUpdate();
			prepStmt.close();

			System.out.println("Inserted Income Expense!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void ShowAvailableBalance(Connection con) {
		try {
			String query = "WITH INCOME AS ("
					+ "		select Account.apartmentId, SUM(Account.monthlyPayment) as Income from Account group by Account.apartmentId"
					+ " ),"
					+ "EXPENSE AS ("
					+ "		select Item.apartmentId, SUM(Item.price) as Expense from Item group by Item.apartmentId"
					+ " ),"
					+ "INFO AS ("
					+ "	select Apartment.id, Apartment.apartmantName as ApartmanName from Apartment"
					+ ") select INFO.ApartmanName as apartmanName, INCOME.apartmentId as apartmentId, INCOME.Income - EXPENSE.Expense as AvailableBalance from INCOME inner join EXPENSE on INCOME.apartmentId = EXPENSE.apartmentId inner join INFO on INCOME.apartmentId = INFO.id";
			
			PreparedStatement prepStmt = con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			System.out.println("rs den sonrası");
			while (rs.next()) {
				System.out.print(rs.getString("apartmanName"));
				System.out.print(" ");
				System.out.print(rs.getInt("apartmentId"));
				System.out.print(" ");
				System.out.print(rs.getInt("AvailableBalance"));
				System.out.print("\n");
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void UpdateAvailableBalance(Connection con) {
		try {
			String query = "WITH INCOME AS ("
					+ "	  select Account.apartmentId, SUM(Account.monthlyPayment) as Income from Account group by Account.apartmentId"
					+ "),"
					+ "EXPENSE AS ("
					+ "	  select Item.apartmentId, SUM(Item.price) as Expense from Item group by Item.apartmentId"
					+ "),"
					+ "INFO AS ("
					+ "	  select Apartment.id, Apartment.apartmantName as ApartmanName from Apartment"
					+ ") update Income_Expense set availableBalance = INCOME.Income - EXPENSE.Expense from INCOME inner join EXPENSE on INCOME.apartmentId = EXPENSE.apartmentId inner join INFO on INCOME.apartmentId = INFO.id";
			PreparedStatement prepStmt = con.prepareStatement(query);
			System.out.println("Updatex Income_Expense Table's Available Balance");
			ShowAvailableBalance(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
