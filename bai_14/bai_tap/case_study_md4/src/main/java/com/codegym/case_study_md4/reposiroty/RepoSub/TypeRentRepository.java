package com.codegym.case_study_md4.reposiroty.RepoSub;


import com.codegym.case_study_md4.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRentRepository extends JpaRepository<RentType,Long> {
}
