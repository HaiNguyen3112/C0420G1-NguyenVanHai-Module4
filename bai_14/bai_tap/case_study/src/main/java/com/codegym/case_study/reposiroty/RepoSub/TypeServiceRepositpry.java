package com.codegym.case_study.reposiroty.RepoSub;

import com.codegym.case_study.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeServiceRepositpry extends JpaRepository<ServiceType,Long> {
}
