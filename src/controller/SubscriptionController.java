package controller;

import java.util.ArrayList;
import java.util.List;

import model.Subscription;
import service.SubscriptionService;

public class SubscriptionController {
private final SubscriptionService subscriptionService;
	
	public SubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	
	public List<Subscription> allSubscriptions(){
		return subscriptionService.allSubscriptions();
	}
	public ArrayList<String> getSubscriptionByApartmentId(int id) {
		return subscriptionService.getSubscriptionByApartmentId(id);
	}
	
	public void addSubscription(Subscription subscription) {
		subscriptionService.addSubscription(subscription);
	}
	public void updateSubscription(int id,Subscription subscription) {
		subscriptionService.updateSubscription(id, subscription);
	}
	public void deleteSubscription(int id) {
		subscriptionService.deleteSubscription(id);
	}
}
