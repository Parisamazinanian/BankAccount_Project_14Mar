package com.example.BankAccountApi_11Mar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table//(name="holders")
public class HolderModel extends BaseEntity {

//  @Transient - Specifies that the property or field is not persistent
    @Transient
    AccountModel accountModel;
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private String address;
    private String phoneNumber;

  //  One to many relationship, because we have one account holder which can have many accounts
   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
       orphanRemoval = true, targetEntity = AccountModel.class)

//   We present a list of all accounts the Holder has
    private List<AccountModel> accounts;

}
