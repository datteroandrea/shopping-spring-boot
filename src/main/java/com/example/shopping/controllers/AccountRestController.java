package com.example.shopping.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.models.Account;
import com.example.shopping.services.AccountService;

@RestController
public class AccountRestController {

    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccount() {
        return this.accountService.getAccounts();
    }


}
