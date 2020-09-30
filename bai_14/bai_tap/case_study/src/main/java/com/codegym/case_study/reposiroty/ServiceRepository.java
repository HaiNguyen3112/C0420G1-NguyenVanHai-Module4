package com.codegym.case_study.reposiroty;

import com.codegym.case_study.model.Servicee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Servicee,Long> {
    Page<Servicee> findAllByNameContaining(String search, Pageable pageable);
    Page<Servicee> findAllByNameContainingAndStatusTrue(String search, Pageable pageable);
}
