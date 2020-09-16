package com.codegym.case_study_md4.service;

import com.codegym.case_study_md4.model.Contract;

import java.util.List;


public interface ContractService {
    List<Contract> findAll();

    Contract findById(Long id);

    void save(Contract contract);

    void deleteById(Long id);

    List<Contract> findAllByCodeContractContaining(String search);
}
