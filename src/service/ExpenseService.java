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
}
