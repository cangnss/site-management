package service;

import java.util.ArrayList;
import java.util.List;

import model.Subscription;
import repository.SubscriptionRepository;

public class SubscriptionService {
private final SubscriptionRepository subscriptionRepository;
	
	public SubscriptionService(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}
	
	public List<Subscription> allSubscriptions(){
		return subscriptionRepository.allSubscriptions();
	}
	public ArrayList<String> getSubscriptionByApartmentId(int id) {
		return subscriptionRepository.getSubscriptionByApartmentId(id);
	}
	public void addSubscription(Subscription subscription) {
		subscriptionRepository.addSubscription(subscription);
	}
	public void updateSubscription(int id,Subscription subscription) {
		subscriptionRepository.updateSubscription(id, subscription);
	}
	public void deleteSubscription(int id) {
		subscriptionRepository.deleteSubscription(id);
	}
}
