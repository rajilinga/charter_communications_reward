package com.transaction.rewards.service;

import com.transaction.rewards.model.TransactionRewards;
import com.transaction.rewards.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceImplTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    public void getTransactionRewardsByCustomerIdTest() {
        TransactionRewards transactionRewards = new TransactionRewards();
        transactionRewards.setCustomerId(1L);
        transactionRewards.setTotalRewards(90L);
        transactionRewards.setLastMonthRewardPoints(30L);
        transactionRewards.setLastSecondMonthRewardPoints(30L);
        transactionRewards.setLastThirdMonthRewardPoints(30L);
        LocalDateTime now = LocalDateTime.now();
        Timestamp lastMonthTimestamp = Timestamp.valueOf(now.minusDays(30L));
        Timestamp lastSecondMonthTimestamp = Timestamp.valueOf(now.minusDays(60L));
        Timestamp lastThirdMonthTimestamp = Timestamp.valueOf(now.minusDays(90L));
        Timestamp timestamp = Timestamp.valueOf(now);


        doReturn(Collections.singletonList(transactionRewards.getLastMonthRewardPoints())).when(transactionRepository).
                findAllByCustomerIdAndTransactionDateBetween(1L, lastMonthTimestamp, timestamp);

        doReturn(Collections.singletonList(transactionRewards.getLastSecondMonthRewardPoints())).when(transactionRepository).
                findAllByCustomerIdAndTransactionDateBetween(1L, lastSecondMonthTimestamp, timestamp);

        doReturn(Collections.singletonList(transactionRewards.getLastThirdMonthRewardPoints())).when(transactionRepository).
                findAllByCustomerIdAndTransactionDateBetween(1L, lastThirdMonthTimestamp, timestamp);

        assertNotNull(transactionRewards);
    }
}
