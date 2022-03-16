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
public class AccountModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Double accountAmount;
    private Date dateOfAccountCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "holder_id", referencedColumnName="id", nullable = false)
    private HolderModel holderModel;
// Added the line 34 and 35
    @Transient
    Long holderId;
}

