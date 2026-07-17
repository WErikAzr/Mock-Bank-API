package com.example.spring_data.service;
import com.example.spring_data.exception.AccountNotFoundException;
import com.example.spring_data.model.Account;
import com.example.spring_data.proxy.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long senderId, Long receiverId, BigDecimal amount){
        Account senderAccount = accountRepository
                .findById(senderId)
                .orElseThrow(() -> new AccountNotFoundException("Sender account not found"));

        Account receiverAccount = accountRepository.
                findById(receiverId).
                orElseThrow(() -> new AccountNotFoundException("Receiver account not found"));


        if(senderAccount.getAmount().compareTo(amount) <=0){
            throw new IllegalStateException("Insufficient funds to complete the operation");

        }
        BigDecimal senderNewAmount = senderAccount.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiverAccount.getAmount().subtract(amount);

        //updating sender account
        accountRepository.updateAmountById(senderId, senderNewAmount);
        accountRepository.updateAmountById(receiverId, receiverNewAmount);
    }
}
