package com.codegym.case_study_md4.service.Impl;

import com.codegym.case_study_md4.model.Employee;
import com.codegym.case_study_md4.reposiroty.EmployeeRepository;
import com.codegym.case_study_md4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
