package com.transaction.rewards.controller;

import com.transaction.rewards.model.Transaction;
import com.transaction.rewards.service.CustomerRewardsPointsService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRewardsPointsControllerTest {

    @InjectMocks
    CustomerRewardsPointsController customerRewardsPointsController;

    @Mock
    private CustomerRewardsPointsService customerRewardsPointsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateCustomerRewardsPoints() {
        double transactionAmount = 100.0;
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(transactionAmount);
        int points = 50;
        Mockito.when(customerRewardsPointsService.calculateCustomerRewardsPoints(any(Double.class))).thenReturn(points);
        int result = customerRewardsPointsController.calculateCustomerRewardsPoints(transaction);
        assertEquals(points, result);
        verify(customerRewardsPointsService).calculateCustomerRewardsPoints(transactionAmount);
    }
}



