package com.codegym.case_study.reposiroty.RepoSub;

import com.codegym.case_study.model.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeCustomerRepository extends JpaRepository<TypeCustomer,Long> {
}
