package com.example.shopping.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.shopping.models.Account;
import com.example.shopping.services.AccountService;

import jakarta.validation.Valid;

@RestController("/accounts")
public class AccountRestController {

    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        this.accountService.createAccount(account);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<Account>> getAccount(@PathVariable long id) {
        Optional<Account> account = this.accountService.getAccount(id);
        return new ResponseEntity<Optional<Account>>(account, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAccount(@PathVariable long id) {
        this.accountService.deleteAccount(id);
        return new ResponseEntity<String>("Account deleted successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
	public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account, @PathVariable long id) {
		Account updatedAccount = this.accountService.updateAccount(account, id);
		return new ResponseEntity<Account>(updatedAccount,HttpStatus.ACCEPTED);
    }

}
