package com.example.BankAccountApi_11Mar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class HolderModel{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  //  @Transient - Specifies that the property or field is not persistent
//  The line 26 and 27 is not needed
//    @Transient
//    AccountModel accountModel;
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private String address;
    private String phoneNumber;

  //  One to many relationship, because we have one account holder which can have many accounts
  @OneToMany(mappedBy = "holderModel", cascade = CascadeType.REMOVE )
  @JsonIgnore
//   We present a list of all accounts the Holder has
//  criar um retorno especifico
    private List<AccountModel> accounts;
}

//annotation commented @OneToMany and the foreignKey wasn't create
