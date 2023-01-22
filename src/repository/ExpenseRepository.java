package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Expense;
import utils.DbConnection;

public class ExpenseRepository implements IExpenseRepository{
	Connection con = DbConnection.createConnection();

	@Override
	public List<Expense> allExpenses() {
		try {
			String query = "select name, description, cost from Expense inner join Apartment on Expense.apartment_id = Apartment.id";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("name: " + rs.getString("name") + " Description: " + rs.getString("description") + " Cost: " + rs.getDouble("cost") );
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All expenses error");
		}
		return null;
	}

	@Override
	public ArrayList<String> getExpense(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getExpenseByApartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Expense> getExpenseByApartmentId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addExpense(Expense expense) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateExpense(int id, Expense expense) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExpense(int id) {
		// TODO Auto-generated method stub
		
	}

}
