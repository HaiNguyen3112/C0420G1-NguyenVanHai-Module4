package com.codegym.case_study.service.Impl;

import com.codegym.case_study.model.TypeCustomer;
import com.codegym.case_study.reposiroty.RepoSub.TypeCustomerRepository;
import com.codegym.case_study.service.TypeCustomerService;
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
