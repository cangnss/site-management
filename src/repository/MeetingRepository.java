package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Meeting;
import utils.DbConnection;

public class MeetingRepository implements IMeetingRepository{
	Connection con = DbConnection.createConnection();

	@Override
	public ArrayList<String> allMeetings() {
		try {
			String query = "select * from Meeting";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("id: " + rs.getInt(1) + " Apartment ID: " + rs.getString(2) + " Date: " + rs.getDate(3));
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All meetings error");
		}
		return null;
	}

	@Override
	public void addMeeting(Meeting meeting) {
		try {
			String insert="INSERT INTO Meeting(apartment_id, date) VALUES(?,?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setInt(1, meeting.getApartment_id());
			prepStmt.setString(2, meeting.getDate());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Meeting!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}

	}

	@Override
	public void updateMeeting(int id, Meeting meeting) {
		try {
			String query=("UPDATE Meeting SET apartment_id=?, date=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, meeting.getApartment_id());
			prepStmt.setString(2, meeting.getDate());
			prepStmt.setInt(3,id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Updated Meeting!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}

	}

	@Override
	public void deleteMeeting(int id) {
		try {
			String query=("DELETE Meeting WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Deleted Meeting!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error delete:" + e);
		}

	}

}	

	