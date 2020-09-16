package com.codegym.case_study_md4.reposiroty.RepoSub;

import com.codegym.case_study_md4.model.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCustomerRepository extends JpaRepository<TypeCustomer,Long> {
}
