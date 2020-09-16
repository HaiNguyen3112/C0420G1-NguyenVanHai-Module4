package com.codegym.case_study_md4.service.Impl;

import com.codegym.case_study_md4.model.AttachService;
import com.codegym.case_study_md4.reposiroty.RepoSub.AttachServiceRepository;
import com.codegym.case_study_md4.service.AttachServiceService;
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
