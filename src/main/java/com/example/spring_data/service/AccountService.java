package com.example.spring_data.service;
import com.example.spring_data.exception.AccountNotFoundException;
import com.example.spring_data.model.Account;
import com.example.spring_data.proxy.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long senderId, Long receiverId){
        Account senderAccount = accountRepository
                .findById(senderId)
                .orElseThrow(() -> new AccountNotFoundException("Sender account not found"));
    }
}
