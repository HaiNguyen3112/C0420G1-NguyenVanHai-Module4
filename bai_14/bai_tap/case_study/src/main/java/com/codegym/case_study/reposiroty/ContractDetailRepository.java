package com.codegym.case_study.reposiroty;

import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    List<ContractDetail> findAllByContract(Contract contract);
}
