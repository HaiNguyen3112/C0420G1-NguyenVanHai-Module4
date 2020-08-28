package com.codegym.customermanagement.repository;

import com.codegym.customermanagement.model.Customer;
import com.codegym.customermanagement.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable);
}
