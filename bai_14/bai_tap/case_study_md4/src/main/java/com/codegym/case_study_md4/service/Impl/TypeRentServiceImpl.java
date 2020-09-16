package com.codegym.case_study_md4.service.Impl;

import com.codegym.case_study_md4.model.RentType;
import com.codegym.case_study_md4.reposiroty.RepoSub.TypeRentRepository;
import com.codegym.case_study_md4.service.TypeRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRentServiceImpl implements TypeRentService {
    @Autowired
    TypeRentRepository typeRentRepository;

    @Override
    public List<RentType> findAll() {
        return typeRentRepository.findAll();
    }
}
