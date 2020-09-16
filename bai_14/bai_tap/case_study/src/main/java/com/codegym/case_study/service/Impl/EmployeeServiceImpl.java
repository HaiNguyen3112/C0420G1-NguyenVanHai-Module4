package com.codegym.case_study.service.Impl;

import com.codegym.case_study.model.Employee;
import com.codegym.case_study.reposiroty.EmployeeRepository;
import com.codegym.case_study.service.EmployeeService;
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
