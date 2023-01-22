package controller;

import java.util.List;

import model.Expense;
import service.ExpenseService;

public class ExpenseController {
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	public List<Expense> allExpenses(){
		return expenseService.allExpenses();
	}
	
	public void addExpense(Expense expense) {
		expenseService.addExpense(expense);
	}
}
