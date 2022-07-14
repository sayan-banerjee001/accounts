package com.sayan.accounts.controller;

import com.sayan.accounts.model.Accounts;
import com.sayan.accounts.model.Customer;
import com.sayan.accounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer){

        Optional<Accounts> optAccounts = Optional.of(accountsRepository.findByCustomerId(customer.getCustomerId()));
        return optAccounts.orElse(null);
    }
}
