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

    public void updateExpense(Expense expense) {
        Expense foundExpense = repository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense with id" + expense.getId())
                ));
        foundExpense.setExpenseName(expense.getExpenseName());
        foundExpense.setExpenseAmount(expense.getExpenseAmount());
        foundExpense.setExpenseCategory(expense.getExpenseCategory());

        repository.save(foundExpense);
    }

    public Expense getExpenseByName(String name) {
        return repository.findByName(name).orElseThrow(
                () -> new RuntimeException(String.format("Cannot find Expense by name %s", name)));

    }

    public void deleteExpense(String id) {
        repository.deleteById(id);
    }
}
