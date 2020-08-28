package com.codegym.customermanagement.service;


import com.codegym.customermanagement.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);


}
