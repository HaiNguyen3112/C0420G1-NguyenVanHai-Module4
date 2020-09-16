package com.codegym.case_study_md4.service.Impl;

import com.codegym.case_study_md4.model.Servicee;
import com.codegym.case_study_md4.reposiroty.ServiceRepository;
import com.codegym.case_study_md4.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<Servicee> findAllByNameContaining(String search, Pageable pageable) {
        return serviceRepository.findAllByNameContaining(search,pageable);
    }

    @Override
    public Servicee findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Servicee service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<Servicee> findAll() {
        return serviceRepository.findAll();
    }
}
