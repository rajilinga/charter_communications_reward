package com.transaction.rewards.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRewardsPointsServiceTest {

    @InjectMocks
    private CustomerRewardsPointsService customerRewardsPointsService;

    @Test
    public void testCalculatePointsOver100Dollars() {
        double transactionAmount = 120.0;
        int points = 90; // (2 * 20) + 50
        assertEquals(points, customerRewardsPointsService.calculateCustomerRewardsPoints(transactionAmount));
    }

    @Test
    public void testCalculatePointsBetween50And100Dollars() {
        double transactionAmount = 80.0;
        int points = 30; // (80 - 50)
        assertEquals(points, customerRewardsPointsService.calculateCustomerRewardsPoints(transactionAmount));
    }

    @Test
    public void testCalculatePointsLess50Dollars() {
        double transactionAmount = 30.0;
        int points = 0;
        assertEquals(points, customerRewardsPointsService.calculateCustomerRewardsPoints(transactionAmount));
    }

    @Test
    public void testCalculatePointsEqualTo100Dollars() {
        double transactionAmount = 100.0;
        int points = 50;
        assertEquals(points, customerRewardsPointsService.calculateCustomerRewardsPoints(transactionAmount));
    }

    @Test
    public void testCalculatePointsEqualTo50Dollars() {
        double transactionAmount = 50.0;
        int points = 0;
        assertEquals(points, customerRewardsPointsService.calculateCustomerRewardsPoints(transactionAmount));
    }
}
