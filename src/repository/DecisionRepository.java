package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Decision;
import utils.DbConnection;

public class DecisionRepository implements IDecisionRepository{
	Connection con = DbConnection.createConnection();
	
	@Override
	public ArrayList<String> allDecisions() {
		try {
			String query = "select * from Decision";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("id: " + rs.getInt(1) + " Meeting ID: " + rs.getInt(2) + " Person ID: " + rs.getInt(3) + 
			    		           " Description: " + rs.getString(4) + " Confirm_Rejcet: " + rs.getString(5));
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All decision error");
		}
		return null;
	}

	@Override
	public void addDecision(Decision decision) {
		try {
			String insert="INSERT INTO Decision(meeting_id, person_id, description, confirm_reject) VALUES(?,?,?,?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setInt(1, decision.getMeeting_id());
			prepStmt.setInt(2, decision.getPerson_id());
			prepStmt.setString(3, decision.getDescription());
			prepStmt.setString(4, decision.getConfirm_reject());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Decision!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public void updateDecision(int id, Decision decision) {
		try {
			String query=("UPDATE Decision SET meeting_id=?, person_id=?, description=?, confirm_reject=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, decision.getMeeting_id());
			prepStmt.setInt(2, decision.getPerson_id());
			prepStmt.setString(3, decision.getDescription());
			prepStmt.setString(4, decision.getConfirm_reject());
			prepStmt.setInt(5,id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Updated Decision!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}

	@Override
	public void deleteDecision(int id) {
		try {
			String query=("DELETE Decision WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Deleted Decision!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error delete:" + e);
		}
		
	}

	@Override
	public ArrayList<String> getTotalVotesConfirmed_Rejected() {
		try {
			ArrayList<String> totalConfirm_Reject = new ArrayList<>();
			String query = "SELECT Decision.meeting_id, Decision.description, SUM(CASE WHEN Decision.confirm_reject = 'confirm' THEN 1 ELSE 0 END) AS confirm_count\r\n"
					+ "    ,SUM(CASE WHEN Decision.confirm_reject = 'reject' THEN 1 ELSE 0 END) AS reject_count\r\n"
					+ "FROM Decision\r\n"
					+ "GROUP BY Decision.meeting_id, Decision.description\r\n"
					+ "ORDER BY Decision.meeting_id";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet result = prepStmt.executeQuery(); 
			while(result.next()) {
				totalConfirm_Reject.add("meeting_id: " +result.getInt(1) + " decsription: " + result.getString(2) + " confirm_count: " +result.getInt(3) + " reject_count: " +result.getInt(4));
			}
			return totalConfirm_Reject;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:" + e);
		}
		return null;
	}

	@Override
	public ArrayList<String> getVotesConfirmed_RejectedByPersons() {
		try {
			ArrayList<String> confirm_RejectByPersons = new ArrayList<>();
			String query = "SELECT Person.fullName, SUM(CASE WHEN Decision.confirm_reject = 'confirm' THEN 1 ELSE 0 END) AS confirm_count, \r\n"
					+ "SUM(CASE WHEN Decision.confirm_reject = 'reject' THEN 1 ELSE 0 END) AS reject_count\r\n"
					+ "FROM Decision\r\n"
					+ "JOIN Person ON Decision.person_id = Person.id\r\n"
					+ "GROUP BY Person.fullName";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet result = prepStmt.executeQuery(); 
			while(result.next()) {
				confirm_RejectByPersons.add("Full Name: " +result.getString(1) + " confirm_count: " + result.getInt(2) + " reject_count: " +result.getInt(3));
			}
			return confirm_RejectByPersons;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:" + e);
		}
		return null;
	}

}
