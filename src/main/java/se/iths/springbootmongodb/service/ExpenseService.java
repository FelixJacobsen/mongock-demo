package se.iths.springbootmongodb.service;

import org.springframework.stereotype.Service;
import se.iths.springbootmongodb.model.Expense;
import se.iths.springbootmongodb.repository.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void addExpense(Expense expense) {
        repository.insert(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public void updateExpense() {
        //TODO Implement update expense method
    }

    public void getExpenseByName() {
        //TODO Implement a method to get all expenses by name
    }

    public void deleteExpense() {
        //TODO Implement method to delete a expense
    }
}
