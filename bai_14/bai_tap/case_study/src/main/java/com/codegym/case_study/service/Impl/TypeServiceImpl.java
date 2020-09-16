package com.codegym.case_study.service.Impl;

import com.codegym.case_study.model.ServiceType;
import com.codegym.case_study.reposiroty.RepoSub.TypeServiceRepositpry;
import com.codegym.case_study.service.TypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeServiceService {
    @Autowired
    TypeServiceRepositpry typeServiceRepositpry;
    @Override
    public List<ServiceType> findAll() {
        return typeServiceRepositpry.findAll();
    }
}
