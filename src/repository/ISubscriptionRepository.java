package repository;

import java.util.ArrayList;
import java.util.List;

import model.Subscription;

public interface ISubscriptionRepository {
	List<Subscription> allSubscriptions();
	ArrayList<String> getSubscription(int id);
	ArrayList<String> getSubscriptionByApartment(); 
	ArrayList<Subscription> getSubscriptionByApartmentId(int id); // where apartment_id = 1
	void addSubscription(Subscription subscription);
	void updateSubscription(int id, Subscription subscription);
	void deleteSubscription(int id);
}
