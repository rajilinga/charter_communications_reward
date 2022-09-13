package com.transaction.rewards.controller;

import com.transaction.rewards.entity.Customer;
import com.transaction.rewards.model.TransactionRewards;
import com.transaction.rewards.repository.CustomerRepository;
import com.transaction.rewards.service.TransactionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionService transactionService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void getRewardsByCustomerIdTest() {
        Customer customer = new Customer();
        TransactionRewards transactionRewards = new TransactionRewards();
        customer.setCustomerId(1L);
        customer.setCustomerName("Test User");
        Mockito.when(transactionService.getTransactionRewardsByCustomerId(customer.getCustomerId())).thenReturn(transactionRewards);
        ResponseEntity<TransactionRewards> transactionRewardsResponseEntity = transactionController.getRewardsByCustomerId(customer.getCustomerId());
        Assert.assertEquals(200, transactionRewardsResponseEntity.getStatusCode().value());
    }

    @Test(expected = Exception.class)
    public void getRewardsByNullCustomerTest() {
        Customer customer = new Customer();
        customer.setCustomerId(null);
        customer.setCustomerName(null);
        Mockito.when(transactionService.getTransactionRewardsByCustomerId(customer.getCustomerId())).thenThrow(Exception.class);
    }
}
