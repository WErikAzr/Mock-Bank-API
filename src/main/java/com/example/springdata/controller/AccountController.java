package com.example.springdata.controller;

import com.example.springdata.model.Account;
import com.example.springdata.model.TransferRequest;
import com.example.springdata.proxy.JSONPlaceholderProxy;
import com.example.springdata.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AccountController {

    private final AccountService accountService;
    private final JSONPlaceholderProxy jsonPlaceholderProxy;

    public AccountController(AccountService accountService,
    JSONPlaceholderProxy jsonPlaceholderProxy) {
        this.jsonPlaceholderProxy = jsonPlaceholderProxy;
        this.accountService = accountService;
    }

    @GetMapping("/getAllResources")
    public ResponseEntity<List<JSONPlaceholderProxy>> getAllResources(){
        List<JSONPlaceholderProxy> allResources = jsonPlaceholderProxy.listAllResources();
        return ResponseEntity.status(HttpStatus.OK).body(allResources);
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
