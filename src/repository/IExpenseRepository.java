package repository;

import java.util.ArrayList;
import java.util.List;

import model.Expense;


public interface IExpenseRepository {
	List<Expense> allExpenses();
	ArrayList<String> getExpenseByApartmentId(int id); // where apartment_id = 1
	void addExpense(Expense expense);
	void updateExpense(int id, Expense expense);
	void deleteExpense(int id);
}
