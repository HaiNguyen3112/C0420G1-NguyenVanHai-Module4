package com.codegym.customermanagement.service;

import com.codegym.customermanagement.model.Customer;
import com.codegym.customermanagement.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    List<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByName(String name, Pageable pageable);
}
