package com.codegym.case_study.service.Impl;

import com.codegym.case_study.model.Contract;
import com.codegym.case_study.reposiroty.ContractRepository;
import com.codegym.case_study.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> findAllByCodeContractContaining(String search) {
        return contractRepository.findAllByCodeContractContaining(search);
    }

    @Override
    public List<Contract> findAllByCodeContractContainingAndStatusTrue(String codeContract) {
        return contractRepository.findAllByCodeContractContainingAndStatusTrue(codeContract);
    }

    @Override
    public List<Contract> findAllByCodeContractContainingAndStatusFalse(String codeContract) {
        return contractRepository.findAllByCodeContractContainingAndStatusFalse(codeContract);
    }
}
