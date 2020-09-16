package com.codegym.case_study.reposiroty;

import com.codegym.case_study.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
