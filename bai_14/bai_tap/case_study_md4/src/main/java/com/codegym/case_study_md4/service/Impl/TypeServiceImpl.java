package com.codegym.case_study_md4.service.Impl;


import com.codegym.case_study_md4.model.ServiceType;
import com.codegym.case_study_md4.reposiroty.RepoSub.TypeServiceRepository;
import com.codegym.case_study_md4.service.TypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeServiceService {
    @Autowired
    TypeServiceRepository typeServiceRepository;
    @Override
    public List<ServiceType> findAll() {
        return typeServiceRepository.findAll();
    }
}
