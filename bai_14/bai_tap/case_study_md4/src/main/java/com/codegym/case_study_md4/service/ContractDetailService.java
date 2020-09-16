package com.codegym.case_study_md4.service;

import com.codegym.case_study_md4.model.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
