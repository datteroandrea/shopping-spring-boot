package com.example.shopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.shopping.models.Account;
import com.example.shopping.repositories.AccountRepository;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return this.accountRepository.save(account);
    }

    // TODO
    public Account updateAccount(Account account, long id) {
        Optional<Account> oldAccount = this.accountRepository.findById(id);
        return this.accountRepository.save(account);
    }

    public Optional<Account> getAccount(long id) {
        return this.accountRepository.findById(id);
    }

    public void deleteAccount(long id) {
        this.accountRepository.deleteById(id);
    }

}
