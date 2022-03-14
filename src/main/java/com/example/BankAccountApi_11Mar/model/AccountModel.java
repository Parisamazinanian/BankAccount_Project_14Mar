package com.example.BankAccountApi_11Mar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table//(name = "Accounts")
public class AccountModel extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Double accountAmount;
    private Date dateOfAccountCreation;

//    One Holder has many account
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(nullable = false, name = "holder_id")
    @Transient
    private HolderModel holderModel;
}
