package com.codegym.case_study_md4.service;


import com.codegym.case_study_md4.model.Servicee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    Page<Servicee> findAllByNameContaining(String search, Pageable pageable);
    Servicee findById(Long id);
    void save(Servicee service);
    void deleteById(Long id);
    List<Servicee> findAll();
}
