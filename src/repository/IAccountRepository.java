package repository;

import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.FlatNo;

public interface IAccountRepository {
	List<String> allAccounts();
    ArrayList<String> getAvailableBalance(int id);
    public void addAccount(Account account);
	public void updateAccount(int id, Account account);
	public void deleteAccount(int id);
}
