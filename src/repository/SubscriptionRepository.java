package repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Subscription;
import utils.DbConnection;

public class SubscriptionRepository implements ISubscriptionRepository {
	Connection con = DbConnection.createConnection();
	@Override
	public List<Subscription> allSubscriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getSubscription(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getSubscriptionByApartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Subscription> getSubscriptionByApartmentId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSubscription(int id, Subscription subscription) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubscription(int id) {
		// TODO Auto-generated method stub
		
	}

}
