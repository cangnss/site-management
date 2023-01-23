package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.FlatNo;
import utils.DbConnection;

public class FlatNoRepository implements IFlatNoRepository{
	Connection con = DbConnection.createConnection();
	@Override
	public List<String> allFlatNo() {
		// TODO Auto-generated method stub
		try {
			String query = "select name, number, fullName, flatName from FlatNo inner join Apartment on FlatNo.apartment_id = Apartment.id inner join Person on Person.id=FlatNo.person_id inner join Flat on FlatNo.flat_id=Flat.id  ";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("name:  " + rs.getString("name") + " Number: " + rs.getInt("number") + " Fullname: " + rs.getString("fullname") + " Flatname: " + rs.getString("flatName"));
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All FlatNo error");
		}
		return null;
		
	}
	@Override
	public ArrayList<String> getFlatNoByApartmentIdAndFlatId(int id, int flat_id) {
		try {
			ArrayList<String> flatNo = new ArrayList<>();
			String query = "select name, number, fullName, flatname from FlatNo inner join Apartment as ap on FlatNo.apartment_id = ap.id inner join Person on Person.id=FlatNo.person_id inner join Flat on FlatNo.flat_id=Flat.id where ap.id= " +id + " and flat_id= " + flat_id;
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				flatNo.add(rs.getString("name") + " " + Integer.toString(rs.getInt("number")) + " " + rs.getString("fullName") + " " + rs.getString("flatName"));
			}
			prepStmt.close();
			return flatNo;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Get flatNo error");
		}
		return null;
	}
	public ArrayList<String> getFlatNoByNumber(int number) {
		try {
			ArrayList<String> flatNo = new ArrayList<>();
			String query = "select name,fullname from FlatNo inner join Apartment on flatNo.apartment_id=Apartment.id inner join Person on person.id=FlatNo.person_id where flatNo.number=" + number;
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				flatNo.add(rs.getString("name") + " " + " " + rs.getString("fullName"));
			}
			prepStmt.close();
			return flatNo;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Get expenses error");
		}
		return null;
	}

	@Override
	public void addFlatNo(FlatNo flatNo) {
		// TODO Auto-generated method stub
		try {
			String insert="INSERT INTO FlatNo(apartment_id, number, person_id, flat_id) VALUES(?, ?, ?, ?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setInt(1, flatNo.getApartment_id());
			prepStmt.setInt(2, flatNo.getNumber());
			prepStmt.setInt(3, flatNo.getPerson_id());
			prepStmt.setInt(4, flatNo.getFlat_id());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New FlatNo!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public void updateFlatNo(int id, FlatNo flatNo) {
		// TODO Auto-generated method stub
		try {
			String query=("UPDATE FlatNo SET apartment_id=?, number=?, person_id=?, flat_id=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			System.out.println("get apartment_id: " + flatNo.getApartment_id() + " number: " + flatNo.getNumber() + " person_id: " + flatNo.getPerson_id() + " flat_id: " + flatNo.getFlat_id() + " id: " + id);
			prepStmt.setInt(1, flatNo.getApartment_id());
			prepStmt.setInt(2, flatNo.getNumber());
			prepStmt.setInt(3, flatNo.getPerson_id());
			prepStmt.setInt(4, flatNo.getFlat_id());
			prepStmt.setInt(5,id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Updated FlatNo!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
	}

	@Override
	public void deleteFlatNo(int id) {
		// TODO Auto-generated method stub
		try {
			String query=("DELETE FROM FlatNo WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Deleted FlatNo!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}
		
	}


