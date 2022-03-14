package com.example.BankAccountApi_11Mar.service;

import com.example.BankAccountApi_11Mar.model.HolderModel;
import com.example.BankAccountApi_11Mar.respositry.HolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolderService {

    @Autowired
    private HolderRepository holderRepository;

    public List<HolderModel> getAllAccount(){
        //create an empty list for all the
        return holderRepository.findAll();
    }

    public HolderModel getAccountById(long id){
        return holderRepository.findById(id).orElseThrow();
    }

    public HolderModel addAccount(HolderModel newAccount){
        return holderRepository.save(newAccount);
    }

    public void deleteAccount(long id){
        holderRepository.deleteById(id);
    }


}
