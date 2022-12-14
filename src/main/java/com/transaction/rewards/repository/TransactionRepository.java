package com.transaction.rewards.repository;

import com.transaction.rewards.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from, Timestamp to);
}
