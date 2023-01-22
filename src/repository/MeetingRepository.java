package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

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
			    System.out.println("id: " + rs.getInt(1) + " Apartment Name: " + rs.getString(2) );
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
			prepStmt.setDate(2, new Date(meeting.getDate()));
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Apartment!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public void updateMeeting(int id, Meeting meeting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMeeting(int id) {
		// TODO Auto-generated method stub
		
	}

}
