package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Dues;
import utils.DbConnection;

public class DuesRepository implements IDuesRepository{
	Connection con = DbConnection.createConnection();
	@Override
	public List<Dues> allDues() {
		// TODO Auto-generated method stub
		try {
			String query = "select fullName, month, amount from Dues inner join FlatNo on Dues.number_id= FlatNo.person_id inner join Person on FlatNo.person_id=Person.id";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("Fullname:  " + rs.getString("fullName") + " Month: " + rs.getString("month") + " amount: " + rs.getDouble("amount"));
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All Dues error");
		}
		
		return null;
	}

	@Override
	public ArrayList<String> getSumDuesbyApartmentAndMonth(int id, String date) {
		// TODO Auto-generated method stub
		try {
			//System.out.println("date : "+date);
			ArrayList<String> dues = new ArrayList<>();
			String query = "select name, SUM(amount) as TotalAidat, month from Dues inner join FlatNo on Dues.number_id = FlatNo.person_id inner join Apartment on FlatNo.apartment_id = Apartment.id group by Apartment.id,name, month having Apartment.id=? and month= ?";
			
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, date);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				dues.add(rs.getString("name") + " " + Double.toString(rs.getDouble("TotalAidat")) + " " + rs.getString("month"));
			}
			prepStmt.close();
			return dues;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Get dues error");
		}
		return null;
	}

}
