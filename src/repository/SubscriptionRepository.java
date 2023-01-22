package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Subscription;
import utils.DbConnection;

public class SubscriptionRepository implements ISubscriptionRepository {
	Connection con = DbConnection.createConnection();
	@Override
	public List<Subscription> allSubscriptions() {
		// TODO Auto-generated method stub
		try {
			String query = "select Subscription.id, Apartment.id, name, service, period, cost from Subscription inner join Apartment on Subscription.apartment_id = Apartment.id";
			PreparedStatement prepStmt=con.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			    System.out.println("Subscription id: " + rs.getInt("id") + " Apartment id: " + rs.getInt(2) + " name: " + rs.getString("name") + " Service: " + rs.getString("service") +" Period: " + rs.getString("period") + " Cost: " + rs.getDouble("cost") );
			}
			prepStmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("All expenses error");
		}
		return null;
	}

	@Override
    public ArrayList<String> getSubscriptionByApartmentId(int id) {
        try {
            ArrayList<String> subscriptions = new ArrayList<>();
            String query = "select name, service, period, cost from Subscription inner join Apartment on Subscription.apartment_id = Apartment.id where apartment_id = " + id;
            PreparedStatement prepStmt=con.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
            	subscriptions.add(rs.getString("name") + " " + rs.getString("service") + " " + rs.getString("period") + " " + Double.toString(rs.getDouble("cost")));
            }
            prepStmt.close();
            return subscriptions;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Get subscriptions error");
        }
        return null;
    }

	@Override
	public void addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		try {
			String insert="INSERT INTO Subscription(apartment_id, service, period, cost) VALUES(?, ?, ?, ?)";
			PreparedStatement prepStmt=con.prepareStatement(insert);
			prepStmt.setInt(1, subscription.getApartment_id());
			prepStmt.setString(2, subscription.getService());
			prepStmt.setString(3, subscription.getPeriod());
			prepStmt.setDouble(4, subscription.getCost());
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Inserted New Subscription!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error:" + e);
		}
		
	}

	@Override
	public void updateSubscription(int id, Subscription subscription) {
		// TODO Auto-generated method stub
		try {
			String query=("UPDATE Subscription SET service=?, period=?, cost=? WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			System.out.println("get description: " + subscription.getService() + " Period: " + subscription.getPeriod() + " cost: " + subscription.getCost() + " id: " + id);
			prepStmt.setString(1, subscription.getService());
			prepStmt.setString(2, subscription.getPeriod());
			prepStmt.setDouble(3, subscription.getCost());
			prepStmt.setInt(4,id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Updated Subscription!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}

	@Override
	public void deleteSubscription(int id) {
		// TODO Auto-generated method stub
		try {
			String query=("DELETE FROM Subscription WHERE id=?");
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			prepStmt.close();
			System.out.println("Deleted Subscription!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error update:" + e);
		}
		
	}

}
