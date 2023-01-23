package repository;

import java.util.ArrayList;

import model.Decision;



public interface IDecisionRepository {
	ArrayList<String> allDecisions();
	void addDecision(Decision decision);
	void updateDecision(int id, Decision decision);
	void deleteDecision(int id);
	ArrayList<String> getTotalVotesConfirmed_Rejected();
	ArrayList<String> getVotesConfirmed_RejectedByPersons();
}
