package com.example.BankAccountApi_11Mar.controller;

import com.example.BankAccountApi_11Mar.model.AccountModel;
import com.example.BankAccountApi_11Mar.respositry.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    //get all the account holders
    @GetMapping("/accounts")
    public List<AccountModel> getAllAccount(){
        //create an empty list for all the
        return accountRepository.findAll();
    }

    //get account holders with a specific id
    @GetMapping("/{id}")
    public AccountModel getAccountById(@PathVariable(value="id") long id){
        return accountRepository.findById(id).orElseThrow();
    }

    //add a new account holder
    @PostMapping("/add")
    public AccountModel addAccount(@Validated @RequestBody AccountModel newAccount){
         return accountRepository.save(newAccount);
    }

   /* @PutMapping(value="/{id}")
    public void updateAccount(@PathVariable(value="id") long id, @RequestBody AccountModel updateAccount){
        accountRepository.update(id, updateAccount);
    }*/

   @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable(value="id") long id){
        accountRepository.deleteById(id);
    }
}
