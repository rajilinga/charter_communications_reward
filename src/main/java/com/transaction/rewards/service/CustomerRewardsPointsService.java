package com.transaction.rewards.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerRewardsPointsService {

    public int calculateCustomerRewardsPoints(double transactionAmount) {
        int points = 0;
        if(transactionAmount > 100) {
            points += (int) ((transactionAmount - 100) * 2);
            points += 50;
        } else if (transactionAmount > 50) {
            points += (int) ((transactionAmount - 50));
        }
        return points;
    }
}

