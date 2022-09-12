package com.transaction.rewards.service;

import com.transaction.rewards.model.TransactionRewards;

public interface TransactionService {
    public TransactionRewards getTransactionRewardsByCustomerId(Long customerId);
}
