package com.example.spring_data.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {

    @Id
    private Long accountId;
    private String name;
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
