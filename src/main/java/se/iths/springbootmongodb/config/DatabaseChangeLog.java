package se.iths.springbootmongodb.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import se.iths.springbootmongodb.model.Expense;
import se.iths.springbootmongodb.model.ExpenseCategory;
import se.iths.springbootmongodb.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static se.iths.springbootmongodb.model.ExpenseCategory.*;

@ChangeLog()
// @ChangeUnit(id = "seedDatabase", order = "001", author = "Felix")
public class DatabaseChangeLog {

    // @Execution
    @ChangeSet(id = "seedDatabase", order = "001", author = "Felix")
    public void seedDatabase(ExpenseRepository repository) {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(addNewExpense("Gym membership", MISC, BigDecimal.valueOf(249)));
        expenseList.add(addNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(99)));
        expenseList.add(addNewExpense("Internet", UTILITIES, BigDecimal.valueOf(149)));

        repository.insert(expenseList);
    }

    public Expense addNewExpense(String name, ExpenseCategory category, BigDecimal amount) {
        Expense expense = new Expense();
        expense.setExpenseName(name);
        expense.setExpenseCategory(category);
        expense.setExpenseAmount(amount);

        return expense;
    }


}
