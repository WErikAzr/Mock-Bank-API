package com.example.spring_data.controller;

import com.example.spring_data.model.Account;
import com.example.spring_data.model.TransferRequest;
import com.example.spring_data.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/transferMoney")
    public void TransferMoney(@Valid @RequestBody TransferRequest transferRequest){
        accountService.transferMoney(
                transferRequest.getSenderId(),
                transferRequest.getReceiverId(),
                transferRequest.getAmount()
        );
    }

    @PostMapping("/createAccount")
    public void createNewAccount(@RequestParam String newAccountName){
         accountService.createNewAccount(newAccountName);
    }

    @DeleteMapping("/deleteAccountById")
    public void deleteAccount(@RequestParam Long accountId){
        accountService.deleteAccount(accountId);
    }

    @GetMapping("/getAccountById")
    public ResponseEntity<Account> getAccountByID(@RequestParam Long id){
       Account account = accountService.getAccountById(id);
       return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @GetMapping("/getAllAccounts")
    public Iterable<Account> getAllAccounts(){
            return accountService.getAllAccounts();
    }
}
