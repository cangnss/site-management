package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import utils.DbConnection;

public class AccountRepository implements IAccountRepository{
	Connection con = DbConnection.createConnection();
	@Override
	public List<String> allAccounts() {
		// TODO Auto-generated method stub
		try {
			String query = "select balance, name, amount as expenseSubscription, date from Account inner join Apartment on Account.apartment_id=Apartment.id inner join Bill on Account.bill_id=Bill.id ";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("balance:  " + rs.getDouble("balance") + " Name: " + rs.getString("name") + " ExpenseSubscription: " + rs.getDouble("expenseSubscription") + " date: " + rs.getString("date"));
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All Account error");
		}
		return null;
	}

	@Override
	public ArrayList<String> getAvailableBalance(int id) {
		// TODO Auto-generated method stub
		try {
			ArrayList<String> account = new ArrayList<>();
			String query = "WITH DuesProcess AS("
					+ "	select name as apartmentName,SUM(amount) as TotalDues from Dues inner join FlatNo on FlatNo.person_id = Dues.number_id inner join Apartment on Apartment.id = FlatNo.apartment_id group by name, Apartment.id having Apartment.id = ?"
					+ "),"
					+ "ExSubProcess AS("
					+ "	select SUM(Expense.cost + Subscription.cost) as TotalBill from Bill inner join Expense on Bill.expense_id = Expense.id inner join Subscription on Subscription.id = Bill.subscription_id where Expense.apartment_id = ? and Subscription.apartment_id = ?"
					+ ")"
					+ "select  apartmentName, SUM(TotalDues - TotalBill) as availableBalance from DuesProcess, ExSubProcess group by apartmentName";
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.setInt(2, id);
			prepStmt.setInt(3, id);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				account.add("apartmentName: "+ rs.getString("apartmentName") + " availableBalance "+ Double.toString(rs.getInt("availableBalance")));
			}
			prepStmt.close();
			return account;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Get Account error");
		}
		return null;
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		try {
			String insert="INSERT INTO Account(balance, apartment_id, bill_id) VALUES(?, ?, ?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setDouble(1, account.getBalance());
			prepStmt.setInt(2, account.getApartment_id());
			prepStmt.setInt(3, account.getBill_id());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Account!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public void updateAccount(int id, Account account) {
		// TODO Auto-generated method stub
		try {
			String query=("UPDATE Account SET balance=?, apartment_id=?, bill_id=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			System.out.println( "balance: " + account.getBalance() + " apartment_id: " + account.getApartment_id() + " bill id: " + account.getBill_id());
			prepStmt.setDouble(1, account.getBalance());
			prepStmt.setInt(2, account.getApartment_id());
			prepStmt.setInt(3, account.getBill_id());
			prepStmt.setInt(4,id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Updated Account!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		try {
			String query=("DELETE FROM Account WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Deleted Account!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}

}
