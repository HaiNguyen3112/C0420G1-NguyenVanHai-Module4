package com.codegym.customer_manager.service;

import com.codegym.customer_manager.model.Customer;

import com.codegym.customer_manager.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    List<Customer> findAllByProvince(Province province);
}
