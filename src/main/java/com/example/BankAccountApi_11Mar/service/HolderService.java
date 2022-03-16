package com.example.BankAccountApi_11Mar.service;

import com.example.BankAccountApi_11Mar.model.AccountModel;
import com.example.BankAccountApi_11Mar.model.HolderModel;
import com.example.BankAccountApi_11Mar.respositry.HolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolderService {

    @Autowired
    private HolderRepository holderRepository;

    public List<HolderModel> getAllHolders(){
        //create an empty list for all the
        return holderRepository.findAll();
    }

    public HolderModel getHolderById(long id){
        return holderRepository.findById(id).orElseThrow();
    }

    public HolderModel addHolder(HolderModel newHolder){
        return holderRepository.save(newHolder);
    }

    public void deleteHolder(long id){
        holderRepository.deleteById(id);
    }


    public void alterAccount(HolderModel holder) {
        holderRepository.save(holder);
    }
}
