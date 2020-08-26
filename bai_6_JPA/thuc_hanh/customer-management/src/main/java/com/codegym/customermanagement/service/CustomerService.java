package com.codegym.customermanagement.service;

import com.codegym.customermanagement.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
