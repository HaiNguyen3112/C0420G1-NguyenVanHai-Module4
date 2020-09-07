package com.codegym.phone_management.repository;

import com.codegym.phone_management.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPhoneRepository extends JpaRepository<SmartPhone,Integer> {
}
