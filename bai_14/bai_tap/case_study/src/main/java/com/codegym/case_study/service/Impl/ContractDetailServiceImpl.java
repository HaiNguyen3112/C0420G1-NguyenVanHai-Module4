package com.codegym.case_study.service.Impl;

import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.ContractDetail;
import com.codegym.case_study.reposiroty.ContractDetailRepository;
import com.codegym.case_study.reposiroty.ContractRepository;
import com.codegym.case_study.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAllByContract(Contract contract) {
        return contractDetailRepository.findAllByContract(contract);
    }
}
