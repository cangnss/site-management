package service;

import java.util.List;

import model.Expense;
import repository.ExpenseRepository;


public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepository.allExpenses();
	}
	
	public void addExpense(Expense expense) {
		expenseRepository.addExpense(expense);
	}
	public void updateExpense(int id,Expense expense) {
		expenseRepository.updateExpense(id, expense);
	}
	public void deleteExpense(int id) {
		expenseRepository.deleteExpense(id);
	}
}
