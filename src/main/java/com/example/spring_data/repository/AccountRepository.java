package com.example.spring_data.repository;

import com.example.spring_data.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id=:accountId")
    void updateAmountById (Long accountId, BigDecimal amount);

    @Query("SELECT * FROM account WHERE id = :accountId")
    Account findAccountById(Long accountId);

    @Query("SELECT * FROM account WHERE account_name= :name")
    List<Account> findAccountByName(String name);
}
