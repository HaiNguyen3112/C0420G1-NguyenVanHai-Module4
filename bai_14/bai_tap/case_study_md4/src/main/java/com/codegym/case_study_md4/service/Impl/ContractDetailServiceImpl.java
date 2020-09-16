package com.codegym.case_study_md4.service.Impl;

import com.codegym.case_study_md4.model.ContractDetail;
import com.codegym.case_study_md4.reposiroty.ContractDetailRepository;
import com.codegym.case_study_md4.service.ContractDetailService;
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
}
