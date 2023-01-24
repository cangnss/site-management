package controller;

import java.util.ArrayList;
import java.util.List;

import model.Account;
import service.AccountService;

public class AccountController {
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		
		this.accountService = accountService;
	}
	public List<String> allAccounts() {
		return  accountService.allAccounts();
	}


	public ArrayList<String> getAvailableBalance(int id) {
		return  accountService.getAvailableBalance(id);
	}
	public void addAccount(Account account) {
		accountService.addAccount(account);
	}
	public void updateAccount(int id, Account account) {
		accountService.updateAccount(id, account);
	}
	public void deleteAccount(int id) {
		accountService.deleteAccount(id);
	}

}
