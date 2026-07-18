package com.example.spring_data.controller;

import com.example.spring_data.model.Account;
import com.example.spring_data.model.TransferRequest;
import com.example.spring_data.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public void TransferMoney(@Valid @RequestBody TransferRequest transferRequest){
        accountService.transferMoney(
                transferRequest.getSenderId(),
                transferRequest.getReceiverId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping
    public Iterable<Account> getAllAccounts(){
        return null;
    }
}
