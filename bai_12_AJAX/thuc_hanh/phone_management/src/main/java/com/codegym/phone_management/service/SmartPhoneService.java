package com.codegym.phone_management.service;

import com.codegym.phone_management.model.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    List<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    SmartPhone remove(Integer id);
}
