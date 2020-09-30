package com.codegym.case_study.reposiroty;

import com.codegym.case_study.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
    List<Contract> findAllByCodeContractContaining(String codeContract);
    List<Contract> findAllByCodeContractContainingAndStatusTrue(String codeContract);
    List<Contract> findAllByCodeContractContainingAndStatusFalse(String codeContract);
}
