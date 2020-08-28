package com.codegym.customermanagement.repository;


import com.codegym.customermanagement.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {

}
