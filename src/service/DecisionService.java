package service;

import java.util.ArrayList;

import model.Decision;
import repository.DecisionRepository;



public class DecisionService {
	private final DecisionRepository decisionRepository;

	public DecisionService(DecisionRepository decisionRepository) {
		super();
		this.decisionRepository = decisionRepository;
	}

	public ArrayList<String> allDecisions() {
		return decisionRepository.allDecisions();
	}

	public void addDecision(Decision decision) {
		decisionRepository.addDecision(decision);
	}

	public void updateDecision(int id, Decision decision) {
		decisionRepository.updateDecision(id, decision);
	}

	public void deleteDecision(int id) {
		decisionRepository.deleteDecision(id);
	}

	public ArrayList<String> getTotalVotesConfirmed_Rejected() {
		return decisionRepository.getTotalVotesConfirmed_Rejected();
	}

	public ArrayList<String> getVotesConfirmed_RejectedByPersons() {
		return decisionRepository.getVotesConfirmed_RejectedByPersons();
	}

	
	
	
}
