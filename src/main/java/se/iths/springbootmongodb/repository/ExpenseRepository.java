package se.iths.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import se.iths.springbootmongodb.model.Expense;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'name':?0}")
    Optional<Expense> findByName(String name);
}
