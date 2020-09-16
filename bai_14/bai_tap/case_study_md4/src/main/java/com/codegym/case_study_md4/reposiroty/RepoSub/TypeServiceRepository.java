package com.codegym.case_study_md4.reposiroty.RepoSub;


import com.codegym.case_study_md4.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeServiceRepository extends JpaRepository<ServiceType,Long> {
}
