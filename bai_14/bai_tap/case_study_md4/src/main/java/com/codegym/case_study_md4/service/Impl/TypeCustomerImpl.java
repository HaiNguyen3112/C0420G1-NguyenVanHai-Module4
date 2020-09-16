package com.codegym.case_study_md4.service.Impl;

import com.codegym.case_study_md4.model.TypeCustomer;
import com.codegym.case_study_md4.reposiroty.RepoSub.TypeCustomerRepository;
import com.codegym.case_study_md4.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCustomerImpl implements TypeCustomerService {
    @Autowired
    TypeCustomerRepository typeCustomerRepository;

    @Override
    public List<TypeCustomer> findAll() {
        return typeCustomerRepository.findAll();
    }

}
