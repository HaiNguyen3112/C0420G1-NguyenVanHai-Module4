package com.codegym.case_study.reposiroty;

import com.codegym.case_study.model.AppUser;
import com.codegym.case_study.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
