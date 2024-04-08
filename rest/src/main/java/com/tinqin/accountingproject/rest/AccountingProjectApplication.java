package com.tinqin.accountingproject.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.tinqin.**"})
@EntityScan(basePackages = {"com.tinqin.accountingproject.persistence.entity"})
@EnableJpaRepositories(basePackages = {"com.tinqin.accountingproject.persistence.repository"})
@EnableFeignClients(basePackages ={"com.tinqin.**"})
@SpringBootApplication

public class AccountingProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountingProjectApplication.class, args);
    }
}