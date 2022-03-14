package com.example.BankAccountApi_11Mar.controller;

import com.example.BankAccountApi_11Mar.model.HolderModel;
import com.example.BankAccountApi_11Mar.service.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class AccountController {

    @Autowired
    private HolderService holderService;

    //get all the account holders
    @GetMapping("/accounts")
    public List<HolderModel> getAllAccount(){
        //create an empty list for all the
        return holderService.getAllAccount();
    }

    //get account holders with a specific id
    @GetMapping("/{id}")
    public HolderModel getAccountById(@PathVariable(value="id") long id){
        return holderService.getAccountById(id);
    }

    //add a new account holder
    @PostMapping("/add")
    public HolderModel addAccount(@Validated @RequestBody HolderModel newAccount){
         return holderService.addAccount(newAccount);
    }

   /* @PutMapping(value="/{id}")
    public void updateAccount(@PathVariable(value="id") long id, @RequestBody AccountModel updateAccount){
        accountRepository.update(id, updateAccount);
    }*/

   @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable(value="id") long id){
       holderService.deleteAccount(id);
    }
}
