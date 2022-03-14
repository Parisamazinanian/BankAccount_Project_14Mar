package com.example.BankAccountApi_11Mar.respositry;

import com.example.BankAccountApi_11Mar.model.HolderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional(readOnly = true)

public interface HolderRepository extends JpaRepository<HolderModel, Long> {


}
