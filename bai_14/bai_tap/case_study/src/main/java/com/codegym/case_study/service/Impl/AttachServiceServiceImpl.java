package com.codegym.case_study.service.Impl;

import com.codegym.case_study.model.AttachService;
import com.codegym.case_study.reposiroty.RepoSub.AttachServiceRepository;
import com.codegym.case_study.service.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
