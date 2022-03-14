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
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private long account_id;
    //@Transient
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    //@Transient
    private Double accountAmount;
    //@Transient
    private Date dateOfAccountCreation;
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade=CascadeType.ALL)
    @JoinColumn(nullable = false, name = "holder_id")
    private HolderModel holderModel;





}
