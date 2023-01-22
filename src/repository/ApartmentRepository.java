package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Apartment;
import utils.DbConnection;

public class ApartmentRepository implements IApartmentRepository{
	Connection con = DbConnection.createConnection();
	
	public List<Apartment> allApartments(){
		try {
			String query = "select * from Apartment";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("id: " + rs.getInt(1) + " Apartment Name: " + rs.getString(2) );
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All apartments error");
		}
		return null;
	}

	@Override
	public void addApartment(Apartment apartment) {
		// TODO Auto-generated method stub
		try {
			String insert="INSERT INTO Apartment(apartmantName) VALUES(?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setString(1, apartment.getApartmantName());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Apartment!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public void updateApartment(int id, Apartment apartment) {
		// TODO Auto-generated method stub
		try {
			String query=("UPDATE Apartment SET apartmantName=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setString(1, apartment.getApartmantName());
			prepStmt.setInt(2,id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Updated Apartment!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}

	@Override
	public void deleteApartment(int id) {
		// TODO Auto-generated method stub
		try {
			String query=("DELETE Apartment WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Deleted Apartment!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
	}

	@Override
	public ArrayList<String> getApartment(int id) {
		try {
			ArrayList<String> apartment = new ArrayList<>();
			String query=("select * from Apartment where id="+id);
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet result = prepStmt.executeQuery();
			while(result.next()) {
				apartment.add(result.getString("apartmantName"));
			}
			prepStmt.close();
			return apartment;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		return null;
	}

	@Override
	public ArrayList<String> getResidentInApartment() {
		try {
			ArrayList<String> residents = new ArrayList<>();
			String query = "select name, fullName from Apartment inner join Person on Person.apartment_id = Apartment.id";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet result = prepStmt.executeQuery(); 
			while(result.next()) {
				residents.add(result.getString(1) + " " + result.getString(2));
			}
			return residents;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		return null;
	}

	@Override
	public ArrayList<String> getMonthlyPaymentByApartment() {
		try {
			ArrayList<String> monthlyPayments = new ArrayList<>();
			String query = "select accountName, SUM(monthlyPayment) from Account group by accountName";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet result = prepStmt.executeQuery(); 
			while(result.next()) {
				monthlyPayments.add(result.getString(1) + " " + result.getString(2));
			}
			return monthlyPayments;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:" + e);
		}
		return null;
	}

	@Override
	public int getSumAllMonthlyPayments() {
		try {
			String query = "select SUM(monthlyPayment) from Account";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet result = prepStmt.executeQuery(); 
			int sum=0;
			while(result.next()) {
				sum = result.getInt(1);				
			}
			return sum;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:" + e);
		}
		return 0;
	}
}
