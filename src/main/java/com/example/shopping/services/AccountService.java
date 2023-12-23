package com.example.shopping.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopping.models.Account;
import com.example.shopping.repositories.AccountRepository;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    
    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }

}
