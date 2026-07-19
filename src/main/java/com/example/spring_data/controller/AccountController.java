package com.example.spring_data.controller;

import com.example.spring_data.model.Account;
import com.example.spring_data.model.TransferRequest;
import com.example.spring_data.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountByID(@RequestParam Long id){
       Account account = accountService.getAccountById(id);
       return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @GetMapping
    public Iterable<Account> getAllAccounts(@RequestParam (required = false) String name){
        if(name == null){
            return accountService.getAllAccounts();
        }else{
         return accountService.findAccountByName(name);
        }
    }
}
