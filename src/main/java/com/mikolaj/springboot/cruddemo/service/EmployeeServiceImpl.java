package com.mikolaj.springboot.cruddemo.service;

import com.mikolaj.springboot.cruddemo.dao.EmployeeDAO;
import com.mikolaj.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO empolyeDAO) {
        this.employeeDAO = empolyeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
