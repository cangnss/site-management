package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.User;
import utils.DbConnection;

public class UserRepository implements IUserRepository{
	Connection con = DbConnection.createConnection();
	ArrayList<String> users = new ArrayList<>(); 
	@Override
	public boolean isManager(String username, String password) {
		try {
			String query = "select fullName, name, type from User inner join Role on User.role_id = Role.id inner join Person on Person.id = User.person_id inner join Apartment on Role.apartment_id = Apartment.id where username = ? and password = ?";
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setString(1, username);
			prepStmt.setString(2, password);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				System.out.println("geldi");
				users.add(rs.getString("fullName") + rs.getString("name") + rs.getString("type"));
			}
			
			
			for (String user : users) {
				System.out.println("user"+user);
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("user exception");
		}
		return false;
	}


}
