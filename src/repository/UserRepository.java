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
			String query = "SELECT * from Users WHERE username='" + username + "' and password='" + password + "'";;
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			if( rs.next()){
				prepStmt.close();
		        return true;
		   } else {
				prepStmt.close();
		       return false;
		   }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("user exception");
		}
		return false;
	}


}
