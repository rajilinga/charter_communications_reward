package com.transaction.rewards.controller;

import com.transaction.rewards.model.Transaction;
import com.transaction.rewards.service.CustomerRewardsPointsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@Slf4j
@RestController
@RequestMapping("/api/customerRewards")
public class CustomerRewardsPointsController {

    private CustomerRewardsPointsService customerRewardsPointsService;

    @PostMapping("/calculateRewardsPoints")
    public int calculateCustomerRewardsPoints(@RequestBody Transaction transaction) {
        return customerRewardsPointsService.calculateCustomerRewardsPoints(transaction.getTransactionAmount());
    }
}
