package se.iths.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.iths.springbootmongodb.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
