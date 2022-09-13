package com.transaction.rewards.controller;

import com.transaction.rewards.entity.Customer;
import com.transaction.rewards.model.TransactionRewards;
import com.transaction.rewards.repository.CustomerRepository;
import com.transaction.rewards.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class TransactionController {

    @Autowired
    CustomerRepository customerRepository;

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/{customerId}/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionRewards> getRewardsByCustomerId(@PathVariable("customerId") Long customerId) {
        TransactionRewards transactionRewards = transactionService.getTransactionRewardsByCustomerId(customerId);
        return new ResponseEntity<>(transactionRewards, HttpStatus.OK);
    }
}
