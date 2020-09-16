package com.codegym.case_study.service;

import com.codegym.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService {
    Page<Customer> findAllByNameContaining(String search, Pageable pageable);
    Customer findById(Long id);
    void save(Customer customer);
    void deleteById(Long id);
    List<Customer> findAll();
}
