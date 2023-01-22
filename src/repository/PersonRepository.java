package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Person;
import utils.DbConnection;

public class PersonRepository implements IPersonRepository{
	Connection con = DbConnection.createConnection();

	
	public List<Person> allPerson() {
		try {
			String query = "select * from Person";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("id: " + rs.getInt(1) + " First Name: " + rs.getString(2) + " Last Name: " + rs.getString(3) + 
			    		           " Full Name: " + rs.getString(4) + " Birthday: " + rs.getDate(5) + " Age: " + rs.getInt(6) + 
			    		           " Gender: " + rs.getString(7) + " Email: "+ rs.getString(8) + " Apartment ID: " + rs.getInt(9));
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All person error");
		}
		return null;
	}

	@Override
	public void addPerson(Person person) {
		try {
			String insert="INSERT INTO Person(firstName, lastName, birthday, gender, email,apartment_id) VALUES(?,?,?,?,?,?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setString(1, person.getFirstName());
			prepStmt.setString(2, person.getLastName());
			//prepStmt.setString(3, person.getFullName());
			prepStmt.setString(3, person.getBirthday());
			//prepStmt.setInt(5, person.getAge());
			prepStmt.setString(4, person.getGender());
			prepStmt.setString(5, person.getEmail());
			prepStmt.setInt(6, person.getApartman_id());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Person!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public void updatePeson(int id, Person person) {
		try {
			String query=("UPDATE Person SET firstName=?, lastName=?, email=?, apartment_id=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setString(1, person.getFirstName());
			prepStmt.setString(2, person.getLastName());
			prepStmt.setString(3, person.getEmail());
			prepStmt.setInt(4, person.getApartman_id());
			prepStmt.setInt(5,id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Updated Person!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}

	@Override
	public void deletePerson(int id) {
		try {
			String query=("DELETE Person WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Deleted Person!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error delete:" + e);
		}
		
	}

	@Override
	public ArrayList<String> getPerson(int id) {
		try {
			ArrayList<String> person = new ArrayList<>();
			String query=("select * from Person where id="+id);
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet result = prepStmt.executeQuery();
			while(result.next()) {
				person.add(result.getString("fullName"));
			}
			prepStmt.close();
			return person;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		return null;
	}

}
