package com.example.BankAccountApi_11Mar.controller;

import com.example.BankAccountApi_11Mar.model.AccountModel;
import com.example.BankAccountApi_11Mar.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-accounts")
public class AccountController {

  @Autowired
  private AccountService accountService;

  //get all the account Accounts
  @GetMapping("/accounts")
  public List<AccountModel> getAllAccounts(){
    //create an empty list for all the
    return accountService.getAllAccounts();
  }

  //get account Accounts with a specific id
  @GetMapping("/{account_id}")
  public AccountModel getAccountById(@PathVariable(value="id") long id){
    return accountService.getAccountById(id);
  }

  //add a new account
  @PostMapping("/add")
  public AccountModel addAccounts(@Validated @RequestBody AccountModel newAccount){
    return accountService.addAccount(newAccount);
  }

   /* @PutMapping(value="/{id}")
    public void updateAccount(@PathVariable(value="id") long id, @RequestBody AccountModel updateAccount){
        accountRepository.update(id, updateAccount);
    }*/

  @DeleteMapping("/{account_id}")
  public void deleteAccount(@PathVariable(value="id") long id){
    accountService.deleteAccount(id);
  }
}
