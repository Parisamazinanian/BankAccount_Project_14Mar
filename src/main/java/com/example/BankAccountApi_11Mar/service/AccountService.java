package com.example.BankAccountApi_11Mar.service;

import com.example.BankAccountApi_11Mar.model.AccountModel;
import com.example.BankAccountApi_11Mar.model.HolderModel;
import com.example.BankAccountApi_11Mar.respositry.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

  @Autowired
  private HolderService holderService;

  @Autowired
  private AccountRepository accountRepository;

  public List<AccountModel> getAllAccounts() {
    //create an empty list for all the
    return accountRepository.findAll();
  }

  public AccountModel getAccountById(long id){
    return accountRepository.findById(id).orElseThrow();
  }

  public AccountModel addAccount(AccountModel newAccount){
    HolderModel holderModel = holderService.getHolderById(newAccount.getHolderId());
    newAccount.setHolderModel(holderModel);
    return accountRepository.save(newAccount);
  }

  public void deleteAccount(long id){
    accountRepository.deleteById(id);
  }
}
