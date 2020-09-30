package com.codegym.case_study.service;

import com.codegym.case_study.model.Contract;

import java.util.List;


public interface ContractService {
    List<Contract> findAll();

    Contract findById(Long id);

    void save(Contract contract);

    void deleteById(Long id);

    List<Contract> findAllByCodeContractContaining(String search);
    List<Contract> findAllByCodeContractContainingAndStatusTrue(String codeContract);
    List<Contract> findAllByCodeContractContainingAndStatusFalse(String codeContract);
}
