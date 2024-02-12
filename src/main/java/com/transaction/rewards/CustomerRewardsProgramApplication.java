package com.transaction.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableCaching
@ComponentScan(basePackages = {"com.transaction.rewards.*"})
public class CustomerRewardsProgramApplication {

    private static final boolean EXIT_AFTER_START = false;

    public static void main(String[] args ) {
       start();
    }

    public static ConfigurableApplicationContext start() {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CustomerRewardsProgramApplication.class);
        if(EXIT_AFTER_START) {
            applicationContext.stop();
        }
        return applicationContext;
    }

}
