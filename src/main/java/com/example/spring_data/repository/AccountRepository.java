package com.example.spring_data.repository;

import com.example.spring_data.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id=:accountId")
    void updateAmountById (Long accountId, BigDecimal amount);

    @Query("SELECT FROM account WHERE id = :accountId")
    Account findAccountById(Long accountId);

    @Query("SELECT FROM account WHERE account_name= :name")
    List<Account> findAccountByName(String name);
}
