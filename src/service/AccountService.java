package service;

import java.util.ArrayList;
import java.util.List;

import model.Account;
import repository.AccountRepository;

public class AccountService {
	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {

		this.accountRepository = accountRepository;
	}
	public List<String> allAccounts() {
		return accountRepository.allAccounts();
	}


	public ArrayList<String> getAvailableBalance(int id) {
		return accountRepository.getAvailableBalance(id);
	}
	
	public void addAccount(Account account) {
		accountRepository.addAccount(account);
	}
	public void updateAccount(int id, Account account) {
		accountRepository.updateAccount(id, account);
	}
	public void deleteAccount(int id) {
		accountRepository.deleteAccount(id);
	}
 
}
