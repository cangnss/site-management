package controller;

import java.util.ArrayList;

import model.Decision;
import service.DecisionService;


public class DecisionController {
	private final DecisionService decisionService;

	public DecisionController(DecisionService decisionService) {
		this.decisionService = decisionService;
	}

	public ArrayList<String> allDecisions() {
		return decisionService.allDecisions();
	}

	public void addDecision(Decision decision) {
		decisionService.addDecision(decision);
	}

	public void updateDecision(int id, Decision decision) {
		decisionService.updateDecision(id, decision);
	}

	public void deleteDecision(int id) {
		decisionService.deleteDecision(id);
	}

	public ArrayList<String> getTotalVotesConfirmed_Rejected() {
		return decisionService.getTotalVotesConfirmed_Rejected();
	}

	public ArrayList<String> getVotesConfirmed_RejectedByPersons() {
		return decisionService.getVotesConfirmed_RejectedByPersons();
	}
	
	
}
