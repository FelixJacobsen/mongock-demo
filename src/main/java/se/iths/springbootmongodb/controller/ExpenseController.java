package se.iths.springbootmongodb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.springbootmongodb.model.Expense;
import se.iths.springbootmongodb.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> addExpense(@RequestBody Expense expense) {
        service.addExpense(expense);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(service.getAllExpenses());
    }

    @PutMapping
    public ResponseEntity<?> updateExpense(@RequestBody Expense expense) {
        service.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable String id) {
        service.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
