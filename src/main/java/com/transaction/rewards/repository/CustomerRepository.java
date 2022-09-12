package com.transaction.rewards.repository;

import com.transaction.rewards.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Customer findByCustomerId(Long customerId);
}
