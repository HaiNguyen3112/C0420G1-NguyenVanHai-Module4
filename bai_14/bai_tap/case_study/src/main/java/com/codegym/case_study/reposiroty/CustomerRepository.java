package com.codegym.case_study.reposiroty;

import com.codegym.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findAllByNameContaining(String search, Pageable pageable);
}
