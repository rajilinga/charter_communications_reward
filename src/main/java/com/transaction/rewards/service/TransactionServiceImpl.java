package com.transaction.rewards.service;

import com.transaction.rewards.TimeConstants.TimeConstants;
import com.transaction.rewards.entity.Transaction;
import com.transaction.rewards.model.TransactionRewards;
import com.transaction.rewards.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionRewards getTransactionRewardsByCustomerId(Long customerId) {

        Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(TimeConstants.daysInMonths);
        Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2 * TimeConstants.daysInMonths);
        Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3 * TimeConstants.daysInMonths);

        List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(
                customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
        List<Transaction> lastSecondMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
        List<Transaction> lastThirdMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthTimestamp,
                        lastSecondMonthTimestamp);

        Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
        Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
        Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

        TransactionRewards transactionRewards = new TransactionRewards();
        transactionRewards.setCustomerId(customerId);
        transactionRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
        transactionRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
        transactionRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
        transactionRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

        return transactionRewards;

    }

    private Long getRewardsPerMonth(List<Transaction> transactions) {
        return transactions.stream().map(transaction -> calculateRewards(transaction))
                .collect(Collectors.summingLong(r -> r.longValue()));
    }

    private Long calculateRewards(Transaction t) {
        if (t.getTransactionAmount() > TimeConstants.firstRewardLimit && t.getTransactionAmount() <= TimeConstants.secondRewardLimit) {
            return Math.round(t.getTransactionAmount() - TimeConstants.firstRewardLimit);
        } else if (t.getTransactionAmount() > TimeConstants.secondRewardLimit) {
            return Math.round(t.getTransactionAmount() - TimeConstants.secondRewardLimit) * 2
                    + (TimeConstants.secondRewardLimit - TimeConstants.firstRewardLimit);
        } else
            return 0L;

    }

    public Timestamp getDateBasedOnOffSetDays(int days) {
        return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
    }
}
