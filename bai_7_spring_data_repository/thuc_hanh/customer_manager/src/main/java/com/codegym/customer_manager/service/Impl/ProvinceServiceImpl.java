package com.codegym.customer_manager.service.Impl;

import com.codegym.customer_manager.model.Customer;
import com.codegym.customer_manager.model.Province;
import com.codegym.customer_manager.repository.ProvinceRepository;
import com.codegym.customer_manager.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;


    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }


}
