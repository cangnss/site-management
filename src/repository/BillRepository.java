package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Bill;
import utils.DbConnection;

public class BillRepository implements IBillRepository{
	Connection con = DbConnection.createConnection();

	@Override
	public ArrayList<String> allBills() {
		try {
			String query = "select name, description, cost from Expense inner join Apartment on Apartment.id = Expense.apartment_id inner join Bill on Bill.expense_id = Expense.id";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("Name: " + rs.getString("name") + " Description: " + rs.getString("description") + " cost: " + rs.getDouble("cost"));
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All bills error");
		}
		return null;
	}

	@Override
	public void addBill(Bill bill) {
		try {
			String insert="INSERT INTO Bill(subscription_id, expense_id, date, amount) VALUES(?, ?, ?, ?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setInt(1, bill.getSubscription_id());
			prepStmt.setInt(2, bill.getExpense_id());
			prepStmt.setString(3, bill.getDate());
			prepStmt.setDouble(3, bill.getAmount());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Bill!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public ArrayList<String> getBillFromByApartmentId(int id) {
		try {
			ArrayList<String> bills = new ArrayList<>();
			String query=("select SUM(Expense.cost + Subscription.cost) as TotalBill from Bill inner join Expense on Bill.expense_id = Expense.id inner join Subscription on Subscription.id = Bill.subscription_id where Expense.apartment_id = ? and Subscription.apartment_id = ?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.setInt(2, id);
			ResultSet result = prepStmt.executeQuery();
			while(result.next()) {
				bills.add(result.getString("TotalBill"));
			}
			prepStmt.close();
			return bills;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		return null;
	}

}
