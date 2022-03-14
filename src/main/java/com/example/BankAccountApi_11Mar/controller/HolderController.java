package com.example.BankAccountApi_11Mar.controller;

import com.example.BankAccountApi_11Mar.model.HolderModel;
import com.example.BankAccountApi_11Mar.service.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class HolderController {

    @Autowired
    private HolderService holderService;

    //get all the account holders
    @GetMapping("/holders")
    public List<HolderModel> getAllHolders(){
        //create an empty list for all the
        return holderService.getAllHolders();
    }

    //get account holders with a specific id
    @GetMapping("/{holder_id}")
    public HolderModel getHolderById(@PathVariable(value="id") long id){
        return holderService.getHolderById(id);
    }

    //add a new account holder
    @PostMapping("/addholder")
    public HolderModel addHolders(@Validated @RequestBody HolderModel newHolder){
         return holderService.addHolder(newHolder);
    }

   /* @PutMapping(value="/{id}")
    public void updateAccount(@PathVariable(value="id") long id, @RequestBody AccountModel updateAccount){
        accountRepository.update(id, updateAccount);
    }*/

   @DeleteMapping("/{holder_id}")
    public void deleteHolder(@PathVariable(value="id") long id){
       holderService.deleteHolder(id);
    }
}
