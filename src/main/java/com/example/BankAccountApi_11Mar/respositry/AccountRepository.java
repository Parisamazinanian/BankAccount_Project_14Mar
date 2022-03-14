package com.example.BankAccountApi_11Mar.respositry;

import com.example.BankAccountApi_11Mar.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
}
