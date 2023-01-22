package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Role;
import utils.DbConnection;

public class RoleRepository implements IRoleRepository{
	Connection con = DbConnection.createConnection();
	
	@Override
	public List<Role> allRole() {
		try {
			String query = "select * from Role";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("id: " + rs.getInt(1) + " Type: " + rs.getString(2) + " Person ID: " + rs.getInt(3) + " Apartment ID: " + rs.getInt(4));
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All role error");
		}
		return null;
	}
	
	@Override
	public void addRole(Role role) {
		try {
			String insert="INSERT INTO Role(type, person_id, apartment_id) VALUES(?,?,?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setString(1, role.getType());
			prepStmt.setInt(2, role.getPerson_id());
			prepStmt.setInt(3, role.getApartment_id());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Role!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public void updateRole(int id, Role role) {
		try {
			String query=("UPDATE Role SET type=?, person_id=?, apartment_id=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setString(1, role.getType());
			prepStmt.setInt(2, role.getPerson_id());
			prepStmt.setInt(3, role.getApartment_id());
			prepStmt.setInt(4,id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Updated Role!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}

	@Override
	public void deleteRole(int id) {
		try {
			String query=("DELETE Role WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Deleted Role!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error delete:" + e);
		}
		
		
	}

	@Override
	public ArrayList<String> getManagerInApartment() {
		try {
			ArrayList<String> residents = new ArrayList<>();
			String query = "select Role.apartment_id, Role.person_id, fullName FROM Role INNER JOIN Person ON Role.person_id= Person.id WHERE type='Manager'";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet result = prepStmt.executeQuery(); 
			while(result.next()) {
				residents.add("Apartment ID: " + result.getString(1) + "Person ID: " + result.getString(2) + " FullName: " + result.getString(3));
			}
			return residents;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		return null;
	}

}
