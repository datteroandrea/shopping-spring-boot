package com.example.shopping.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shopping.models.Account;
import com.example.shopping.repositories.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return this.accountRepository.save(account);
    }

    public Account updateAccount(Account account, long id) {
        Account oldAccount = this.accountRepository.findById(id).get();
        oldAccount.setEmail(account.getEmail());
        oldAccount.setName(account.getName());
        return this.accountRepository.save(oldAccount);
    }

    public Optional<Account> getAccount(long id) {
        return this.accountRepository.findById(id);
    }

    public void deleteAccount(long id) {
        this.accountRepository.deleteById(id);
    }

    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }

}
