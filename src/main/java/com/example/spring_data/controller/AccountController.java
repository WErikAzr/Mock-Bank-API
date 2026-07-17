package com.example.spring_data.controller;

import com.example.spring_data.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @PostMapping
    public void TransferMoney(){

    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return null;
    }
}
