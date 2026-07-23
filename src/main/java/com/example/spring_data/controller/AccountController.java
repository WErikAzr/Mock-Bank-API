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
    public ResponseEntity<TransferRequest> TransferMoney(@Valid @RequestBody TransferRequest transferRequest){
        accountService.transferMoney(
                transferRequest.getSenderId(),
                transferRequest.getReceiverId(),
                transferRequest.getAmount()
        );
        return ResponseEntity.status(HttpStatus.OK).body(transferRequest);
    }

    @PostMapping("/createAccount")
    public ResponseEntity<Account> createNewAccount(@RequestParam String newAccountName){
         accountService.createNewAccount(newAccountName);
         return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/deleteAccountById")
    public ResponseEntity<Account> deleteAccount(@RequestParam Long accountId){
        accountService.deleteAccount(accountId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
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
